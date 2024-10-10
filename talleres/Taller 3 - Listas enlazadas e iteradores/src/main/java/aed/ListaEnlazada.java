package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    /*
     *  Idea principal: 
     * 
     *  primero <--> Nodo <--> Nodo <--> ... <--> Nodo <--> Nodo <--> ultimo
     * 
     *  Cada nodo tiene referencias tanto al sigueitne nodo como al anteriro nodo. 
     *  
     *  "Given an element x in the list, x.next points to its successor in the linked list, and 
     *  x.prev points to its predecessor."
     * 
     */

    Nodo primero;   // pointer al primer nodo
    Nodo ultimo;    // pointer al ultimo nodo
    
    private class Nodo {
        // no hace falta declarar si son privadas o publicas 
        T valor;
        Nodo anterior; 
        Nodo siguiente;

        // constructor
        Nodo(T v){
            valor = v;
            siguiente = null;
            anterior = null;
        }
    }

    // constructor base
    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    // constructor por copia
    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }
    

    public int longitud() {
        int res = 0;
        Nodo actual = primero;
        while(actual != null){
            actual = actual.siguiente;
            res = res + 1;
        }
        return res;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo_nodo = new Nodo(elem);
        nuevo_nodo.siguiente = primero;
        if (primero != null) {
            primero.anterior = nuevo_nodo;
        }
        primero = nuevo_nodo;
        nuevo_nodo.anterior = null;
    }

    public void agregarAtras(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public T obtener(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
