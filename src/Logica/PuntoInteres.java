/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Utilidades.Consola;
import Utilidades.Validador;
import Utilidades.Lector;

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
    //carga y lectura

<<<<<<< HEAD
    public void cargarDatos() throws DatoInvalidoException {
        leerCodigo();
        leerNombre();
        leerAltitud();
        leerNivelAcces();
    }

    private void leerCodigo() throws DatoInvalidoException {
        int codigo;

        Consola.emitirMensajeLN("ingrese el codigo :");
        codigo = Lector.leerInt();

        if (!Validador.esNroPositivo(codigo) || codigo == 0) {
            throw new DatoInvalidoException("el codigo no puede ser negativo");

        }
=======
    public PuntoInteres(int codigo, String nombre, double altitud, int nivelAcces) throws DatoInvalidoException{
>>>>>>> 78bec90202d021c9726414f5439327cce007f8de
        setCodigo(codigo);
    }

    private void leerNombre() throws DatoInvalidoException {
        String nombre;

        Consola.emitirMensajeLN("ingrese el nombre :");
        nombre = Lector.leerString();

        if (Validador.esStringVacio(nombre)) {
            throw new DatoInvalidoException("el nombre no debe ser vacio...");
        }
        setNombre(nombre);
    }

    private void leerAltitud() throws DatoInvalidoException {
        double altitud;

        Consola.emitirMensajeLN("ingrese la altitud s. Niv/mar");
        altitud = Lector.leerDouble();

        if (!Validador.esDecimalPositivo(altitud)) {
            throw new DatoInvalidoException("la altitud debe ser positiva");
        }
        setAltitud(altitud);
    }

    private void leerNivelAcces() throws DatoInvalidoException {
        int nivel;

        Consola.emitirMensajeLN("ingrese el nivel de acceso");
        Consola.emitirLista(nivAccesVal);
        nivel = Lector.leerInt();
        if (!Validador.esNroValido(nivel, 1, nivAccesVal.length)) {
            throw new DatoInvalidoException("opcion de nivel de acceso invalida");
        }
        setNivelAcces(nivel);

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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public void setNivelAcces(int nivelAcces) {
        this.nivelAcces = nivelAcces;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltitud() {
        return altitud;
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
