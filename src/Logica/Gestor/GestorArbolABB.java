package Logica.Gestor;

import Dato.RepositorioPuntoInteres;
import Logica.ArbolABB;
import Logica.Excepciones.ArbolVacioException;
import Logica.Mirador;
import Logica.NodoABB;
import Logica.PuntoInteres;

/**
 *
 * @author emami
 */
public class GestorArbolABB {

    private ArbolABB<PuntoInteres> arbol;

    public GestorArbolABB() {
        this.arbol = new ArbolABB<PuntoInteres>();
    }

    //metodo para ver si el arbol esta vacio utilizando estaVacio() de ArbolABB
    public void arbolVacio() throws ArbolVacioException {
        if (arbol.estaVacio()) {
            throw new ArbolVacioException("no hay puntos de interes guardados");
        }
    }

    //metodo de insertar para usar en el gestorPuntoInteres para la sincronizacion a la hora de la insercion individiual al vector y a la vez al arbol
    public void insertar(PuntoInteres punto) {
        arbol.insertar(punto);
    }
    //metodo construir utilizando la interface RepositorioPuntoInteres como parametro respetando las dependencias y el contrato de los metodos  
    public void construirIndice(RepositorioPuntoInteres repo) {
        this.arbol = new ArbolABB<PuntoInteres>();
        for (int i = 0; i < repo.cantidad(); i++) {
            arbol.insertar(repo.obtener(i));
        }
    }

    //metodos de muestra
    public void mostrarInOrden() {
        arbolVacio();
        mostrarInOrdenRecur(arbol.getRaiz());    //optiene el primer elemento(Raiz)
    }

    //metodo recursivo de muestra
    private void mostrarInOrdenRecur(NodoABB<PuntoInteres> nodo) {//utiliza un atrib. NodoABB para obtener el dato
        if (nodo != null) {
            mostrarInOrdenRecur(nodo.getPi());
            PuntoInteres p = nodo.getDato();//obtenemos el dato
            p.mostrarInformacion();
            mostrarInOrdenRecur(nodo.getPd());
        }
    }
    //metodo de busqueda 
    public PuntoInteres buscarCodigo(int codigo){
        arbolVacio();
       return  buscarCodigoRecursivo(arbol.getRaiz(),new Mirador(codigo));
    }

    private PuntoInteres buscarCodigoRecursivo(NodoABB<PuntoInteres> nodo,PuntoInteres dato){
        if (nodo == null) {
            return null;
        }
        PuntoInteres actual = nodo.getDato();
        int comparacion = dato.compareTo(actual);
        if (comparacion == 0) {
            return actual;
        }
        if (comparacion < 0) {
            return buscarCodigoRecursivo(nodo.getPi(),dato);
        }else{
            return buscarCodigoRecursivo(nodo.getPd(),dato);
        }
        
    }
}
