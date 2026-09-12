/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Excepciones.DatoInvalidoException;
import Utilidades.*;

/**
 *
 * @author emami
 */
public class Mirador extends PuntoInteres {

    private final String[] tipoVistaText = {"Panoramica", "Paisaje", "Fauna"};
    private int tipoVista;

    
    public Mirador() {
        super();
        this.tipoVista = 0;
    }

    public Mirador(int codigo) {
        super(codigo);
        this.tipoVista = 0;
    }

    public String[] getTipoVistaText() {
        return tipoVistaText;
    }

    public String getTipoVista() {
        if (this.tipoVista < 1 || this.tipoVista > tipoVistaText.length) {
            return "Sin definir";
        }
        return tipoVistaText[this.tipoVista - 1];
    }

    public void setTipoVista(int tipoVista) throws DatoInvalidoException {
        if (!Validador.esNroValido(tipoVista, 1, tipoVistaText.length)) {
            throw new DatoInvalidoException("tipo de vista invalido..");
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
        return String.format("Tipo: %s | Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s | Vista: %s",
                obtenerTipo(), codigo, nombre, altitud, getNivelAcces(), getTipoVista());
    }
}
