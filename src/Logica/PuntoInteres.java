/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author emami
 */
public abstract class PuntoInteres {

    private final String[] nivAccesval = {"muy dificil", "dificl", "moderado", "facil"};

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

    //metodos carga y lectura
    public void cargarDatos() throws DatoInvalidoException {

    }
    public void leerNombre() throws DatoInvalidoException {
        
    }
    public void leerCodigo()throws DatoInvalidoException{
        
    }
    public void leerAltitud() throws DatoInvalidoException{
        
    }
    public void leerNivelAcss()throws DatoInvalidoException{
        
    }
    
    public boolean esMismoCodigo(int codB){
        return this.codigo == codB;
    }
    
    //metodos abstractos
    public abstract void mostrarInformacion();

    public abstract String obtenerTipo();

    //gts y sts 
    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltitud() {
        return altitud;
    }

    private void setAltitud(double altitud) {
        this.altitud = altitud;
    }

    public int getNivelAcces() {
        return nivelAcces;
    }

    private void setNivelAcces(int nivelAcces) {
        this.nivelAcces = nivelAcces;
    }

}
