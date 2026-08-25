package Logica;

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

    public PuestoServicio(int tipoServ, int codigo, String nombre, double altitud, int nivelAcces) throws DatoInvalidoException{
        super(codigo, nombre, altitud, nivelAcces);
        setTipoServ(tipoServ);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public String obtenerTipo() {
        return "Puesto de Servicio";
    }

    public String getTipoServ() {
        return tipoServText[tipoServ-1];
    }

    private void setTipoServ(int tipoServ) throws DatoInvalidoException {
        if(!Validador.esNroValido(tipoServ, 1, 3)){
            throw new DatoInvalidoException("el rango de tipo de Servicio debe estar entre 1-2-3 ...");
        }
        this.tipoServ = tipoServ;
    }

}
