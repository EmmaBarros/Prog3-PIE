package Logica;

import Utilidades.*;

import Utilidades.Validador;

/**
 *
 * @author emami
 */
public class PuestoServicio extends PuntoInteres {

    private int tipoServ;
    private String[] tipoServText = {"Guarda Parques", "Primeros Auxilios", "Informacion al visitante"};

    public PuestoServicio() {
        super();
        this.tipoServ = 0;
    }
    
    @Override
    public void cargarDatos() throws DatoInvalidoException {
        super.cargarDatos();
        leerTipoServ();
    }

    private void leerTipoServ() throws DatoInvalidoException {
        int serv;
        Consola.emitirMensajeLN("Ingrese el tipo de servicio:");
        Consola.emitirLista(tipoServText);
        serv = Lector.leerInt();

        if (!Validador.esNroValido(serv, 1, tipoServText.length)) {
            throw new DatoInvalidoException("El rango de tipo de Servicio debe estar entre 1-2-3 ...");
        }
        setTipoServ(serv);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    public String getTipoServicio() {
        if (this.tipoServ < 1 || this.tipoServ > tipoServText.length) {
            return "Sin definir";
        }
        return tipoServText[tipoServ - 1];
    }

    private void setTipoServ(int tipoServ) throws DatoInvalidoException {
        if (!Validador.esNroValido(tipoServ, 1, 3)) {
            throw new DatoInvalidoException("el rango de tipo de Servicio debe estar entre 1-2-3 ...");
        }
        this.tipoServ = tipoServ;
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
