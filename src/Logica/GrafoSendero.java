/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Utilidades.Consola;
import java.util.*;
import Logica.PuntoInteres.PuntoInteres;
import org.jgrapht.graph.SimpleGraph;
/**
 *
 * @author emami
 */
public class GrafoSendero {
    private SimpleGraph<PuntoInteres,Sendero> grafo;
    
  public void agregarVertice(PuntoInteres p){
      grafo.addVertex(p);
  }
  
  public void agregarSendero(PuntoInteres verticeA,PuntoInteres verticeB,Sendero s){
      grafo.addEdge(verticeB, verticeB, s);
  }
    
  public boolean esCompleto(){
      //n es la cantidad de vertices del grafo
     int n = grafo.vertexSet().size();
     //calcula la cantidad maxima de aristas que puede tener el grafo
     int maximo = n * (n-1) / 2;
     //compara si la cantidad de aristas es igual a la cantidad maxima de aristas
     return grafo.edgeSet().size() == maximo;
  }
  
  public Sendero eliminarSendero(PuntoInteres verticeA,PuntoInteres verticeB){
      return grafo.removeEdge(VerticeA, verticeB);
  }
  
  public void mostrarConextiones(){
      if (!esVacio()) {
          
      }
  }
  
  
  
  
}
