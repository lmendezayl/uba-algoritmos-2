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
        Nodo(T valor){
            this.valor = valor;
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
        Nodo nodo = new Nodo(elem);

        if(primero == null) {
            primero = nodo;
            ultimo = nodo;
        } else {
            nodo.siguiente = primero;
            primero.anterior = nodo;

            primero = nodo;
        }
    }

    public void agregarAtras(T elem){
        Nodo nodo = new Nodo(elem);

        if(ultimo == null) {
            primero = new Nodo(elem);
            ultimo = primero;
        } else {
            ultimo.siguiente = nodo;
            nodo.anterior = ultimo;
            ultimo = nodo;
        }
    }

    public T obtener(int i) {
        Nodo nodo = primero;

        for(int j = 0; j < i; j++) { 
            nodo = nodo.siguiente; 
        }

        return nodo.valor;
    }

    public Nodo obtenerNodo(int i) {
        Nodo nodo = primero;

        for(int j = 0; j < i; j++) { 
            nodo = nodo.siguiente; 
        }

        return nodo;
    }

    public void eliminar(int i) {
        Nodo eliminar = obtenerNodo(i);
        Nodo anterior =  eliminar.anterior;
        Nodo siguiente = eliminar.siguiente;
        
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        } else if(eliminar == primero){
            primero = siguiente;
            siguiente.anterior = null;
        } else if(eliminar == ultimo){
            ultimo = anterior;
            anterior.siguiente = null;
        } else {
            anterior.siguiente = siguiente;
            siguiente.anterior = anterior;
        }

        eliminar = null;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo cambiar = obtenerNodo(indice);

        cambiar.valor = elem;
    }

    @Override public String toString() {
        String string = "[";

        for(int i = 0; i < longitud(); i++){
            if(i != longitud()-1){
                string = string + obtener(i).toString() + ", "; 
            } else {
                string = string + obtener(i).toString(); 
            }
        }

        string += "]";
        return string;
    }


    private class ListaIterador implements Iterador<T> {
        int indice;

        ListaIterador(){
            this.indice = 0;
        }

        public boolean haySiguiente() {
	        return indice < longitud();
        }
        
        public boolean hayAnterior() {
	        return indice > 0;
        }

        public T siguiente() {
	        int i = indice;
            indice = indice + 1;

            return obtener(i);
        }
        

        public T anterior() {
	        int i = indice - 1;
            indice = indice - 1;

            return obtener(i);
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }
}
