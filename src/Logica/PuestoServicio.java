
package Logica;
import Utilidades.*;
/**
 *
 * @author emami
 */
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
    

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public String obtenerTipo() {
        return "Puesto de Servicio";
    }
    @Override
public String toString() {
    return String.format("Tipo: %s | Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s | Servicio: %s",
            obtenerTipo(), codigo, nombre, altitud, getNivelAcces(), getTipoServicio());
}
    
    
    
}
