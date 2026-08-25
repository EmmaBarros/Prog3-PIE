<<<<<<< HEAD

package Logica;
import Utilidades.*;
=======
package Logica;

import Utilidades.Validador;

>>>>>>> 78bec90202d021c9726414f5439327cce007f8de
/**
 *
 * @author emami
 */
<<<<<<< HEAD
public class PuestoServicio extends PuntoInteres{
    private final String[] tipoText = {"guarda parques","primeros auxilios","informacion al visitante"};
    private int tipoServicio;

    public PuestoServicio() {
        super();
        this.tipoServicio = 0;
    }

    @Override
    public void cargarDatos() throws DatoInvalidoException {
        super.cargarDatos();
        leerTipoServicio();
    }
    private void leerTipoServicio() throws DatoInvalidoException {
        int tipo;
        Consola.emitirMensajeLN("ingrese el tipo de servicio");
        Consola.emitirLista(tipoText);
        tipo = Lector.leerInt();
        if(!Validador.esNroValido(tipo, 1, tipoText.length)){
            throw new DatoInvalidoException("tipo de servicio invalido");
        }
        setTipoServicio(tipo);
    }

    public String getTipoServicio() {
        if(this.tipoServicio < 1 || this.tipoServicio > tipoText.length){
            return "Sin definir";
        }
        return tipoText[tipoServicio-1];
    }

    private void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
=======
public class PuestoServicio extends PuntoInteres {

    private int tipoServ;
    private String[] tipoServText = {"Guarda Parques", "Primeros Auxilios", "Informacion al visitante"};

    public PuestoServicio() {
        super();
        this.tipoServ = 0;
    }

    public PuestoServicio(int tipoServ, int codigo, String nombre, double altitud, int nivelAcces) throws DatoInvalidoException{
        super(codigo, nombre, altitud, nivelAcces);
        setTipoServ(tipoServ);
    }
>>>>>>> 78bec90202d021c9726414f5439327cce007f8de

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public String obtenerTipo() {
        return "Puesto de Servicio";
    }
<<<<<<< HEAD
    @Override
public String toString() {
    return String.format("Tipo: %s | Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s | Servicio: %s",
            obtenerTipo(), codigo, nombre, altitud, getNivelAcces(), getTipoServicio());
}
    
    
    
=======

    public String getTipoServ() {
        return tipoServText[tipoServ-1];
    }

    private void setTipoServ(int tipoServ) throws DatoInvalidoException {
        if(!Validador.esNroValido(tipoServ, 1, 3)){
            throw new DatoInvalidoException("el rango de tipo de Servicio debe estar entre 1-2-3 ...");
        }
        this.tipoServ = tipoServ;
    }

>>>>>>> 78bec90202d021c9726414f5439327cce007f8de
}
