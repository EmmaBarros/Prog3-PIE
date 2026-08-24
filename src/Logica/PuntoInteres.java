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
public abstract class PuntoInteres {

    private final String[] nivAccesVal = {"muy dificil", "dificl", "moderado", "facil"};

    protected int codigo;
    protected String nombre;
    protected double altitud;
    protected int nivelAcces;

    public PuntoInteres() {
        this.codigo = 0;
        this.nombre = "";
        this.altitud = 0;
        this.nivelAcces = 0;
    }

    public PuntoInteres(int codigo, String nombre, double altitud, int nivelAcces) {
        setCodigo(codigo);
        setNombre(nombre);
        setAltitud(altitud);
        setNivelAcces(nivelAcces);
    }

    public boolean esMismoCodigo(int codB) {
        return this.codigo == codB;
    }

    //metodos abstractos
    public abstract void mostrarInformacion();

    public abstract String obtenerTipo();

    //gts y sts 
    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) throws DatoInvalidoException {
        if (!Validador.esNroPositivo(codigo)) {
            throw new DatoInvalidoException("el codigo debe ser positivo...");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) throws DatoInvalidoException {
        if (!Validador.esStringVacio(nombre)) {
            throw new DatoInvalidoException("el nombre no debe ser vacio...");
        }
        this.nombre = nombre;
    }

    public double getAltitud() {
        return altitud;
    }

    private void setAltitud(double altitud) throws DatoInvalidoException {
        if (!Validador.esDecimalPositivo(altitud)) {
            throw new DatoInvalidoException("la altitud no puede ser positiva...");
        }
        this.altitud = altitud;
    }

    public String getNivelAcces() {
        return nivAccesVal[this.nivelAcces - 1];
    }

    private void setNivelAcces(int nivelAcces) throws DatoInvalidoException {
        if (!Validador.esNroValido(nivelAcces, 1, 5)) {
            throw new DatoInvalidoException("nivel de acceso invalido...");
        }
        this.nivelAcces = nivelAcces;
    }

  @Override
public String toString() {
    return String.format("Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s", 
            codigo, nombre, altitud, getNivelAcces());
}

}
