    
package Dato;

import Logica.CodigoDuplicadoException;
import Logica.PuntoInteres;
import Logica.RepositorioLlenoException;


/**
 *
 * @author emami
 */
public class RepositorioPuntoArreglo implements RepositorioPuntoInteres{
   private PuntoInteres[] punto;
    private int cant;

    public RepositorioPuntoArreglo() {
        punto = new PuntoInteres[30];
        this.cant = 0;
    }

    @Override
    public void agregar(PuntoInteres nuevoPunto) throws RepositorioLlenoException,CodigoDuplicadoException {
        if (estaLleno()) {
            throw new RepositorioLlenoException("el repositorio esta lleno");
        }
        if (existeCodigo(nuevoPunto.getCodigo())) {
            throw new CodigoDuplicadoException("ya existe un punto registrado");
        }
        punto[cant] = nuevoPunto;
        cant ++;
    }
    
    @Override
    public boolean existeCodigo(int codigo){
        return buscarPorCodigo(codigo) != null;
    }

    @Override
    public PuntoInteres obtener(int posicion) {
     if(posicion >=0 && posicion < cant){
         return punto[posicion];
     }
     return null;
    }

    @Override
    public PuntoInteres buscarPorCodigo(int codigo) {
        for (int i = 0; i < cant; i++) {
            if(punto[i].esMismoCodigo(codigo)){
                return punto[i];
            }
        }
        return null;
    }

    @Override
    public int cantidad() {
        return cant;
    }

    @Override
    public boolean estaLleno() {
        return cant == punto.length;
        }
    
    
}
