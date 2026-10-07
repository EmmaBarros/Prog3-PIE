
package Dato;

import Logica.Excepciones.CodigoDuplicadoException;
import Logica.PuntoInteres.PuntoInteres;
import Logica.Excepciones.RepositorioLlenoException;

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
