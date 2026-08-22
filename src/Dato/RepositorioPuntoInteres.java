
package Dato;

import Logica.PuntoInteres;

/**
 * @author emami
 */
public interface RepositorioPuntoInteres {
    void agregar (PuntoInteres punto);
    PuntoInteres obtener(int posicion);
    PuntoInteres buscarPorCodigo(int codigo);
    int cantidad();
    boolean estaLleno();
}
