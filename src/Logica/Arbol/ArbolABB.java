package Logica.Arbol;

import Logica.Arbol.NodoABB;

public class ArbolABB<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    public ArbolABB() {
        raiz = null;
    }

    public NodoABB<T> getRaiz() {
        return raiz;
    }
    // -------------------------------------------------
    // VERIFICAR SI EL ÁRBOL ESTÁ VACÍO
    // -------------------------------------------------

    public boolean estaVacio() {
        return raiz == null;
    }

    // -------------------------------------------------
    // INSERTAR
    // -------------------------------------------------
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoABB<T> insertarRecursivo(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoABB<>(dato);
        }
        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion < 0) {
            nodo.setPi(insertarRecursivo(nodo.getPi(), dato));
        } else if (comparacion > 0) {
            nodo.setPd(insertarRecursivo(nodo.getPd(), dato));
        }
        // Si comparacion == 0 no se inserta
        // porque no permitimos duplicados

        return nodo;
    }

    // -------------------------------------------------
    // BUSCAR
    // -------------------------------------------------
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return false;
        }
        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion == 0) {
            return true;
        }
        if (comparacion < 0) {
            return buscarRecursivo(nodo.getPi(), dato);
        }
        return buscarRecursivo(nodo.getPd(), dato);
    }

    // -------------------------------------------------
    // ELIMINAR
    // -------------------------------------------------
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    private NodoABB<T> eliminarRecursivo(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }
        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion < 0) {
            nodo.setPi(eliminarRecursivo(nodo.getPi(), dato));
        } else if (comparacion > 0) {
            nodo.setPd(eliminarRecursivo(nodo.getPd(), dato));
        } else {
            // -----------------------------------------
            // CASO 1:
            // Nodo sin hijo izquierdo
            // -----------------------------------------
            if (nodo.getPi() == null) {
                return nodo.getPd();
            }
            // -----------------------------------------
            // CASO 2:
            // Nodo sin hijo derecho
            // -----------------------------------------
            if (nodo.getPd() == null) {
                return nodo.getPi();
            }
            // -----------------------------------------
            // CASO 3:
            // Nodo con dos hijos
            // -----------------------------------------
            NodoABB<T> sucesor = buscarMinimo(nodo.getPd());
            nodo.setDato(sucesor.getDato());
            nodo.setPd(eliminarRecursivo(nodo.getPd(), sucesor.getDato()));
        }
        return nodo;
    }

    // -------------------------------------------------
    // BUSCAR EL MENOR ELEMENTO DE UN SUBÁRBOL
    // -------------------------------------------------
    private NodoABB<T> buscarMinimo(NodoABB<T> nodo) {
        NodoABB<T> actual = nodo;
        while (actual.getPi() != null) {
            actual = actual.getPi();
        }
        return actual;
    }
    // -------------------------------------------------
    // RECORRIDO INORDEN
    // -------------------------------------------------

    public void inOrden() {
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    private void inOrdenRecursivo(NodoABB<T> nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getPi());
            System.out.print(nodo.getDato() + " ");
            inOrdenRecursivo(nodo.getPd());
        }
    }

    // -------------------------------------------------
    // RECORRIDO PREORDEN
    // -------------------------------------------------
    public void preOrden() {
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    private void preOrdenRecursivo(NodoABB<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrdenRecursivo(nodo.getPi());
            preOrdenRecursivo(nodo.getPd());
        }
    }
    
    // -------------------------------------------------
    // RECORRIDO POSTORDEN
    // -------------------------------------------------

    public void postOrden() {
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    private void postOrdenRecursivo(NodoABB<T> nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.getPi());
            postOrdenRecursivo(nodo.getPd());
            System.out.print(nodo.getDato() + " ");
        }
    }
}
