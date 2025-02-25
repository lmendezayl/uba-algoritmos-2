from __future__ import annotations
from math import sqrt
from typing import TypeVar


class Punto2D:
    def __init__(self, x: float, y: float) -> None:
        self.x = x
        self.y = y

    def mover(self, dx: float, dy: float) -> Punto2D:
        return Punto2D(
            self.x + dx,
            self.y + dy)

    def distancia(self, p1: Punto2D, p2: Punto2D) -> float:
        return sqrt((p2.x - p1.x)**2 + (p2.y - p1.y)**2)

    def distanciaAlOrigen(self, p: Punto2D) -> float:
        return self.distancia(p, Punto2D(0, 0))


class Rectangulo2D:
    def __init__(self, a: Punto2D, b: Punto2D, c: Punto2D, d: Punto2D) -> None:
        self.a = a
        self.b = b
        self.c = c
        self.d = d

    def mover(self, dx: float, dy: float) -> Rectangulo2D:
        return Rectangulo2D(
            self.a.mover(dx, dy),
            self.b.mover(dx, dy),
            self.c.mover(dx, dy),
            self.d.mover(dx, dy)
        )

    def estaContenido(self, r2: Rectangulo2D) -> bool:
        return True


class Cola:
    def __init__(self) -> None:
        self.elems = []

    def estaVacia(self) -> bool:
        return len(self.elems) == 0

    def encolar(self, elem: object) -> None:
        self.elems.append(elem)

    def desencolar(self) -> object:
        return self.elems.pop(0)


class Pila():
    def __init__(self) -> None:
        self.elems = []

    def estaVacia(self) -> bool:
        return len(self.elems) == 0

    def apilar(self, elem: object) -> None:
        self.elems.append(elem)

    def desapilar(self) -> object:
        return self.elems.pop(-1)


class SecuenciaLSE:
    class NodoLista:
            def __init_subclass__(cls, valor: object) -> None:
                cls.valor = valor
                cls.siguiente = None
                
    def __init__(self) -> None:
        self.primero = None
        self.ultimo = None
        self.longitud = 0
    
    def agregarAdelante(self, elem):
        