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
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.BreadthFirstIterator;
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
      return grafo.removeEdge(verticeA, verticeB);
  }
  
  public void mostrarConextiones(){
      if (!esVacio()) {
          for (PuntoInteres vertice1 : grafo.vertexSet()) {
              Consola.emitirMensajeLN("");
              vertice1.mostrarInformacion();
              mostrarPorVertice(vertice1);
              
          }
  
      }else{
          Consola.emitirMensajeLN("No hay puntos de interes guardados.");
      }
  }
  public void mostrarPorVertice(PuntoInteres vertice){
      PuntoInteres vertice2;
      if (!estaDesconectado(vertice)) {
          for (Sendero s : grafo.edgesOf(vertice)) {
              vertice2 = Graphs.getOppositeVertex(grafo, s, vertice);
              Consola.emitirMensajeLN("Conectado con: ");
              vertice2.mostrarInformacion();
              s.mostrarInfo();
          }
      }else{
          Consola.emitirMensajeLN("no posee senderos");
      }
  }
  
  public boolean existeConexion(PuntoInteres vertice1,PuntoInteres vertice2){
      return grafo.containsEdge(vertice1,vertice2);
  }
  
  public boolean existeCamino(PuntoInteres verticeOrigen,PuntoInteres verticeDestino){
      DepthFirstIterator<PuntoInteres,Sendero> dfs = new DepthFirstIterator<>(grafo,verticeOrigen);
      while (dfs.hasNext()) {
          PuntoInteres actual = dfs.next();
          if (actual.esMismoCodigo(verticeDestino.getCodigo())) {
              return true;
          }
      }
      return false;
  }
  public List<PuntoInteres> recorridoDFS(PuntoInteres verticeInicio){
        DepthFirstIterator<PuntoInteres, Sendero> dfs = new DepthFirstIterator<>(grafo, verticeInicio);
        
        return recorrer(dfs);
    }
    public List<PuntoInteres> recorridoBFS(PuntoInteres verticeInicio){
        BreadthFirstIterator<PuntoInteres, Sendero> bfs = new BreadthFirstIterator<>(grafo, verticeInicio);
        
        return recorrer(bfs);
    }
    
    private List<PuntoInteres> recorrer(Iterator<PuntoInteres> iterador) {
        List<PuntoInteres> lista = new ArrayList<>();
        while (iterador.hasNext()) {
            lista.add(iterador.next());
        }
        
        return lista;
    }
  
     public int contarComponentes(){
        ConnectivityInspector<PuntoInteres, Sendero> coneciones = new ConnectivityInspector<>(grafo);
        
        return coneciones.connectedSets().size();
    }
    
  
  
  
  //booleans verf.
  //verifica si el grafo tiene al menos una arista
  public boolean noTieneAristas(){
      return grafo.edgeSet().isEmpty();
  }
  
  //verifica si el grafo esta vacio
  public boolean esVacio(){
      return grafo.vertexSet().isEmpty();
  }
  
  //verifica si un vertice tiene aristas
  private boolean estaDesconectado(PuntoInteres p){
      return grafo.edgesOf(p).isEmpty();
  }
  
  
}
