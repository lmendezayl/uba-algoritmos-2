package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    Nodo raiz;
    int cardinal;
    int altura;

    private class Nodo {
        T valor;
        Nodo left;
        Nodo right;
        Nodo parent;
        
        Nodo(T valor){
            this.valor = valor;
            left = null;
            right = null;
            parent = null;
        }
    }

    public ABB() {
        raiz = null;
        cardinal = 0; 
        altura = 0;
    }

    public int cardinal() {
    /* Cormen p.289, ejercicio 12.1.3
     * sugiere usar un stack como una estructura de datos auxiliar si queremos 
     * no usar recursion (fuck recursion)
     * si fueramos valientes, sugiere no usar un stack pero asumir que podemos
     * usar dos punteros para testear la igualdad de nodos. (no somos valientes)
    */

        Stack<Nodo> stack = new Stack<>();
        Nodo nodo = raiz;
        int res = 0;

        while (raiz != null || !stack.empty()){   
            while(raiz != null){          // si ABB esta vacio, y retorna 0
                stack.push(nodo);               // 
                nodo = nodo.left;
            }
            stack.pop();
            res = res + 1;

            nodo = nodo.right;
        }
        return res; 
    }

    public T minimo(){
        Nodo nodo = raiz;
        while (nodo.left != null) {
            nodo = nodo.left;            
        }
        return nodo.valor;
    }

    public T maximo(){
        Nodo nodo = raiz;
        while (nodo.left != null) {
            nodo = nodo.right;            
        }
        return nodo.valor;
    }

    public void insertar(T elem){
        
    }

    public boolean pertenece(T elem){
        // version iterativa (Cormen  p.291)
        Nodo nodo = raiz; // fix: estaba comparando el elem con el nodo del elem XD

        while (nodo != null) {
            if (elem.compareTo(nodo.valor) == 0) {
                return true;
            }
            else if (elem.compareTo(nodo.valor) < 0){
                nodo = nodo.left;
            }
            else nodo = nodo.right;
        }
        return false;
    }

        /* // caso 1: ABB es null
        if (elem == null){
            return false;
        } 
        
        // caso 2: la raiz contiene al elemento
        else if (elem.compareTo(nodo.valor) == 0){
            return true;
        } 
        
        // paso recursivo: busqueda recursiva en el subarbol correspondiente
        // caso recursivo 1: elem < nodo.valor
        if (elem.compareTo(nodo.valor) < 0){
            nodo = nodo.left;
            return pertenece(nodo.valor);
        }
        else {
            nodo = nodo.right;
            return pertenece(nodo.valor);
        }
    } */

    public void eliminar(T elem){
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
