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

        Nodo(T valor) {
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
        return cardinalRecursiva(raiz);
    }

    public int cardinalRecursiva(Nodo nodo) {
        // caso base: raiz = null
        if (nodo == null) {
            return 0;
        } else {
            return 1 + cardinalRecursiva(nodo.left) + cardinalRecursiva(nodo.right);
        }
    }
    /*
     * public int cardinalIterativo() {
     * /*Cormen p.289, ejercicio 12.1.3
     * sugiere usar un stack como una estructura de datos auxiliar si queremos
     * no usar recursion (fuck recursion)
     * si fueramos valientes, sugiere no usar un stack pero asumir que podemos
     * usar dos punteros para testear la igualdad de nodos. (no somos valientes)
     * 
     * Stack<Nodo> stack = new Stack<>();
     * Nodo nodo = raiz;
     * int res = 0;
     * 
     * while (raiz != null || !stack.isEmpty()){
     * while(raiz != null){ // si ABB esta vacio, y retorna 0
     * stack.push(nodo);
     * if (nodo.left != null) nodo = nodo.left;
     * }
     * stack.pop();
     * res = res + 1;
     * 
     * if (nodo.right != null) nodo = nodo.right;
     * }
     * return res;
     * }
     */

    public T minimo() {
        Nodo nodo = raiz;
        while (nodo.left != null) {
            nodo = nodo.left;
        }
        return nodo.valor;
    }

    public T maximo() {
        return maximoNodo(raiz);
    }

    public T maximoNodo(Nodo nodo){
        while (nodo.right != null) {
            nodo = nodo.right;
        }
        return nodo.valor;
    }


    public void insertar(T elem){
        /* Cormen p.294, Ch.12.3
         * implementacion de TREE-INSERT(T,z)
         */
        Nodo y = null;                                 
        Nodo x = raiz;
        Nodo z = new Nodo(elem);         
        z.left = null;
        z.right = null;               

        while (x != null) {                             //solo entra aca si ABB no vacio
            y = x;                        
            if (z.valor.compareTo(x.valor) == 0){
                return;         // esto esta GAGA (creo)       
            } else if (z.valor.compareTo(x.valor) < 0){
                x = x.left;
            } else{
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            raiz = z;                                   // ABB estaba vacio 
        } else if (z.valor.compareTo(y.valor) < 0){
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public boolean pertenece(T elem) {
        // version iterativa (Cormen p.291)
        Nodo nodo = raiz; // fix: estaba comparando el elem con el nodo del elem XD

        while (nodo != null) {
            if (elem.compareTo(nodo.valor) == 0) {
                return true;
            } else if (elem.compareTo(nodo.valor) < 0) {
                nodo = nodo.left;
            } else
                nodo = nodo.right;
        }
        return false;
    }

/*     public void transplant(Nodo u, Nodo v){
        if (u.parent == null){
            raiz = v;
        } else if (u.valor.compareTo(u.parent.left.valor) == 0){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        } if (v != null){
            v.parent = u.parent;
        }
    }

    public void eliminar(T elem) {
        Nodo z = new Nodo(elem);
        if (z.left == null) {                                       // z no tiene hijo izquierdo
            transplant(z, z.right);
        } else if (z.right == null){                                // z tiene hijo izquierdo pero no tiene derecho 
            transplant(z, z.left);
        } else {                                                    // z tiene dos hijos
            Nodo y = minimNodo(z.right);                            
            if (y.parent.valor.compareTo(z.valor) != 0){
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    } */

    public void eliminar (T elem){
        raiz = eliminarRecursivo(elem, raiz);
    }

    private Nodo eliminarRecursivo(T elem, Nodo raiz){
        if (raiz == null) return raiz;
        
        int comparacion = raiz.valor.compareTo(elem);

        if (comparacion != 0){
            if (comparacion > 0) raiz.left = eliminarRecursivo(elem, raiz.left);
            if (comparacion < 0) raiz.right = eliminarRecursivo(elem, raiz.right);
        } else{
            if(raiz.right == null && raiz.left == null) return null;
            else if(raiz.right == null && raiz.left != null) {
                raiz.left.parent = raiz.parent;

                return raiz.left;
            }else if(raiz.right != null && raiz.left == null) {
                raiz.right.parent = raiz.parent;
                
                return raiz.right;
            }else if(raiz.right != null && raiz.left != null){
                T maximo = maximoNodo(raiz.left);

                raiz.valor = maximo;

                raiz.left = eliminarRecursivo(maximo, raiz.left);
            }
        }

        return raiz;
    }

    private Nodo sucesor(Nodo nodo){
        // caso tiene subarbol derecho
        if (nodo.right != null){
            return minimNodo(nodo.right);
        }
        Nodo res = nodo.parent;
        while (res != null && res.right.valor.compareTo(nodo.valor) == 0) {
            nodo = res; 
            res = res.parent;
        }
        return res;
    }

    public String toString() {
        if (raiz == null) {
            return "{}";
        }
        Iterador<T> iterador = iterador();
        String res = "{";
        while (iterador.haySiguiente()) {
            res = res + iterador.siguiente() + ",";
        }
        res = res + iterador.siguiente() + "}";
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        public Nodo actual;

        public ABB_Iterador(){
            actual = minimNodo();
        }

        public boolean haySiguiente() {
            if (actual.valor.compareTo(maximo()) == 0){
                return false;
            }
            return true;
        }

        public T siguiente() {
            T valor = actual.valor;
            Nodo sucesor = sucesor(actual);
            actual = sucesor;
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

    public Nodo minimNodo(){
        return minimNodo(raiz);
    }

    public Nodo minimNodo(Nodo nodo){
        while (nodo.left != null) {
            nodo = nodo.left;
        }
        return nodo;
    }
}
