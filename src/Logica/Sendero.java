/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Utilidades.Consola;
import Logica.Excepciones.DatoInvalidoException;
/**
 *
 * @author emami
 */
public class Sendero {
    private double distancia;
    private int dificultad;
    private int tiempoEstimado;
    private boolean habilitado;

    public Sendero(double distancia, int dificultad, int tiempoEstimado, boolean habilitado) {
        this.distancia = distancia;
        this.dificultad = dificultad;
        this.tiempoEstimado = tiempoEstimado;
        this.habilitado = habilitado;
    }
    
    
     public Sendero() {
        this.distancia = 0;
        this.dificultad = 0;
        this.tiempoEstimado = 0;
        this.habilitado = false;
    }
    
   //--
    private String getDistFormateada() {
        if (distancia % 1 == 0) {
            return String.valueOf((long) distancia); 
        }
        return String.valueOf(distancia);            
    }
     
      private String stringTiempo(){
        int hora = tiempoEstimado/60;
        int minuto = tiempoEstimado%60;
        
        return String.format("%02d:%02d", hora, minuto);
    }
     
       
    private String stringHabilitado(){
        if(habilitado){
            return "Habilitado";
        }
        
        return "No Habilitado";
    }

    public double getDistancia() {
        return distancia;
    }

    public int getDificultad() {
        return dificultad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setDistancia(double distancia) throws DatoInvalidoException{
        if(distancia <= 0){
            throw new DatoInvalidoException("La distancia debe ser mayor a cero.");
        }
        
        this.distancia = distancia;
    }

    public void setDificultad(int dificultad) throws DatoInvalidoException{
        if(dificultad < 1 || dificultad > 5){
            throw new DatoInvalidoException("La dificultad solo puede ser de 1 a 5.");
        }
        
        this.dificultad = dificultad;
    }

    public void setTiempoEstimado(int tiempoEstimado) throws DatoInvalidoException{
        if(tiempoEstimado <= 0){
            throw new DatoInvalidoException("El tiempo estimado debe ser mayor a cero.");
        }
        
        this.tiempoEstimado = tiempoEstimado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
      
     public void mostrarInfo(){
          Consola.emitirMensajeLN(toString());
     }
@Override
    public String toString() {
        return String.format("Sendero [ Distancia: %s m | Dificultad: %d/5 | Tiempo: %s | Estado: %s ]",
                getDistFormateada(), dificultad, stringTiempo(), stringHabilitado());
    }
   
     
     
     
}
