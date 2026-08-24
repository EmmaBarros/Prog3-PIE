/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Utilidades.Validador;

/**
 *
 * @author emami
 */
public class Mirador extends PuntoInteres {

    private String[] tipoVistaText = {"Panoramica", "Paisaje", "Fauna"};
    private int tipoVista;

    public Mirador() {
        super();
        this.tipoVista = 0;
    }

    public Mirador(int tipoVista, int codigo, String nombre, double altitud, int nivelAcces) {
        super(codigo, nombre, altitud, nivelAcces);
        setTipoVista(tipoVista);
    }

    public String[] getTipoVistaText() {
        return tipoVistaText;
    }

    private void setTipoVistaText(String[] tipoVistaText) throws DatoInvalidoException {
        this.tipoVistaText = tipoVistaText;
    }

    public String getTipoVista() {
        return tipoVistaText[this.tipoVista - 1];
    }

    private void setTipoVista(int tipoVista) throws DatoInvalidoException {
        if (!Validador.esNroValido(tipoVista, 1, tipoVistaText.length)) {
            throw new DatoInvalidoException("el tipo de vista debe estar entre 1-2-3");
        }
        this.tipoVista = tipoVista;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public String obtenerTipo() {
        return "Mirador";
    }

   @Override
    public String toString() {
        return String.format("Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s | Vista: %s",
                codigo, nombre, altitud, getNivelAcces(), getTipoVistaText());
    }

}
