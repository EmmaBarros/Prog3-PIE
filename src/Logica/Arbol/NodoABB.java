package Logica.Arbol;

/**
 *
 * @author emami
 */
public class NodoABB<T> {

    private T dato;
    private NodoABB<T> pi;
    private NodoABB<T> pd;

    public NodoABB(T dato) {
        this.dato = dato;
        this.pi = null;
        this.pd = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoABB<T> getPi() {
        return pi;
    }

    public void setPi(NodoABB<T> pi) {
        this.pi = pi;
    }

    public NodoABB<T> getPd() {
        return pd;
    }

    public void setPd(NodoABB<T> pd) {
        this.pd = pd;
    }

}
