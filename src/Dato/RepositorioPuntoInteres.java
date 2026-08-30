
package Dato;

import Logica.CodigoDuplicadoException;
import Logica.PuntoInteres;
import Logica.RepositorioLlenoException;

/**
 * @author emami
 */
public interface RepositorioPuntoInteres {
    void agregar (PuntoInteres punto)throws RepositorioLlenoException,CodigoDuplicadoException;
    PuntoInteres obtener(int posicion);
    PuntoInteres buscarPorCodigo(int codigo);
    boolean existeCodigo(int codigo);
    int cantidad();
    boolean estaLleno();
    boolean estaVacio();
}
