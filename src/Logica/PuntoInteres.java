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

    public boolean esMismoCodigo(int codB) {
        return this.codigo == codB;
    }

    public boolean esAccesibilidadAlta() {
        return this.nivelAcces == 0 || this.nivelAcces == 1;
    }

    //metodos abstractos
    public abstract void mostrarInformacion();

    public abstract String obtenerTipo();

    //gts y sts 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws DatoInvalidoException {
        if (!Validador.esNroPositivo(codigo) || codigo == 0) {
            throw new DatoInvalidoException("El código debe ser un número positivo mayor a cero.");
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) throws DatoInvalidoException {
        if (Validador.esStringVacio(nombre)) {
            throw new DatoInvalidoException("el nombre no debe ser vacio...");
        }
        this.nombre = nombre;
    }

    public void setAltitud(double altitud) throws DatoInvalidoException {
        if (!Validador.esDecimalPositivo(altitud)) {
            throw new DatoInvalidoException("la altitud debe ser positiva...");
        }
        this.altitud = altitud;
    }

    public void setNivelAcces(int nivelAcces) throws DatoInvalidoException {
        if (!Validador.esNroValido(nivelAcces, 1, nivAccesVal.length)) {
            throw new DatoInvalidoException("opcion de nivel de acceso invalida");
        }
        this.nivelAcces = nivelAcces;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltitud() {
        return altitud;
    }

    public String[] getNivAccesVal() {
        return nivAccesVal;
    }
    

    public String getNivelAcces() {
        if (this.nivelAcces < 1 || this.nivelAcces > nivAccesVal.length) {
            return "Sin definir";
        }
        return nivAccesVal[this.nivelAcces - 1];
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s",
                codigo, nombre, altitud, getNivelAcces());
    }

}
