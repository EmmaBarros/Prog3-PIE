package presentacion;

import Dato.RepositorioPuntoArreglo;
import Dato.RepositorioPuntoInteres;
import Logica.*;
import Utilidades.*;

/**
 *
 * @author emami
 */
public class AppIE {

    private final GestorPuntoInteres gestor;
    private Menu menu;
    private final MenuEcuRoute menuEcRou;

    public AppIE() {
        //se crea el repo del Arreglo con la instancia de la interface
        RepositorioPuntoInteres repositorio = new RepositorioPuntoArreglo();
        //se inyecta la dependencia desde la capa de logica 
        this.gestor = new GestorPuntoInteres(repositorio);
        //se prepara el menu 
        this.menuEcRou = new MenuEcuRoute();
        this.menuEcRou.cargar();
        //inicializamos el menu de tipos con las opciones
        inicializarMenuTipo();
    }

    //se configura el menu auxiliar para elejir los tiposde punto
    private void inicializarMenuTipo() {
        this.menu = new Menu(3);
        String[] op = {
            "Mirador",
            "Recurso Natural",
            "Puesto de Servicio"
        };
        this.menu.cargarDato("Selecione el Tipo de Punto", op);
    }

    public void ejecutar() {
        int opc;
        do {
            opc = menuEcRou.ejecutar();
            procesarOp(opc);
        } while (opc != 8);
    }

    private void procesarOp(int opc) {
        try {
            switch (opc) {
                case 1:
                    registrarPunto();
                    break;
                case 2:
                    mostarTodosPuntos();
                    break;
                case 3:
                    buscarPorCodigo();
                    break;
                case 4:
                    contarPorTipo();
                    break;
                case 5:
                    determinarMayAltitud();
                    break;
                case 6:
                    calcularPromedioAltitud();
                    break;
                case 7:
                    contarYmostrarAccesAlta();
                    break;
                case 8:
                    Consola.emitirMensajeLN("Cerrando Programa ...");
                    break;
                default:
                    Consola.emitirMensajeLN("opcion Invalida");
                    break;
          
            }
        }catch (Exception e) {
            Consola.emitirError("Ocurrio un error inesperado: " + e.getMessage());
        }
    }

   // Método de registro principal refactorizado
   private void registrarPunto() {
        try {
            // Verificar si el repositorio está lleno antes de empezar
            gestor.estaLleno(); 

            PuntoInteres p;
            boolean objCargado = false;

            Consola.emitirTitulo(3, 30, "=", "Alta de Punto de Interés");

            int tipoPuntInteres = menu.ejecutar();
            p = CreadorPuntoInteres.getTipoPInteres(tipoPuntInteres);

            // Bucle exclusivo para validar el código
            do {
                try {
                    int codigo = leerCodigo(); // Lanza DatoInvalidoException si es negativo/cero

                    if (gestor.exsiteCodigo(codigo)) {
                        throw new CodigoDuplicadoException("El codigo " + codigo + " ya existe en el sistema.");
                    }

                    // Se le pasa el código validado y recién se le piden los demás datos
                    p.cargarDatos(codigo); 
                    objCargado = true;

                } catch (CodigoDuplicadoException | DatoInvalidoException e) {
                    Consola.emitirError(e.getMessage());
                }
            } while (!objCargado);

            // Se guarda en el repositorio
            gestor.registrarPuntoInteres(p);
            Consola.emitirMensajeLN("¡Punto de interes guardado correctamente!");

        } catch (RepositorioLlenoException e) {
            Consola.emitirError(e.getMessage());
        }
    }
    // Método auxiliar para leer y validar el código
    private int leerCodigo() throws DatoInvalidoException {
        Consola.emitirBordeLN(40, "=");
        Consola.emitirMensaje("Ingrese codigo: ");
        int codigo = Lector.leerInt();
        Consola.emitirBordeLN(40, "=");
        
        boolean codigoValido = Validador.esNroPositivo(codigo);
        
        if (!codigoValido) {
            throw new DatoInvalidoException("El codigo no puede ser negativo.");
        }
        return codigo;
    }

    //metodo de muestra
    private void mostarTodosPuntos() {
        try {
            gestor.estaVacio();//utiliza el metodo para capturar y lanzar la excception
            gestor.mostrarPuntos();
        } catch (RepositorioVacioException e) {
            Consola.emitirError(e.getMessage());
        }
    }
    //metodo de busqueda por codigo
  private void buscarPorCodigo(){
     try{
      gestor.estaVacio();
      Consola.emitirMensajeLN("Buscar Punto de interes Por Codigo :");
      Consola.emitirMensajeLN("-> ingrese el codigo a buscar :");
      int codigo = Lector.leerInt();
      
      PuntoInteres encontrado = gestor.buscarPorCodigo(codigo);
      if(encontrado != null){
          Consola.emitirMensajeLN("Punto Encontrado!");
          encontrado.mostrarInformacion();
      }else{
          Consola.emitirError("no se encontro Punto de Interes con el codigo"+codigo);
      }
     }catch(RepositorioVacioException e){
              Consola.emitirError(e.getMessage());
              }
  }
  //metodo de contar por tipo de punto
  private void contarPorTipo(){
      try{
          gestor.estaVacio();//lanza la excepcion si no hay pubntos
          Consola.emitirMensajeLN("\n--- CONTAR POR TIPO DE PUNTO ---");
          int tipo = menu.ejecutar();
          String strTipo = obtenerNombreTipo(tipo);
          
          int total = gestor.contarPorTipo(strTipo);
          Consola.emitirResultado(40,"-","Cantidad de tipo: "+strTipo+": "+total);
          
      }catch(RepositorioVacioException e){
          Consola.emitirError(e.getMessage());
      }
  }
  private String obtenerNombreTipo(int tipo){
      if (tipo == 1) {
          return "Mirador";
      }else if(tipo == 2){
          return "Recurso Natural";
      }
      return "Puesto Servicio";
  }
//metodo de calcualr mayor altitud
  private void determinarMayAltitud(){
      try{
        gestor.estaVacio();
        Consola.emitirMensajeLN("Punto de Mayor Altitud");
        PuntoInteres mayor = gestor.determinarMayorAltitud();
        if(mayor != null){
            mayor.mostrarInformacion();
        }
      }catch(RepositorioVacioException e){
          Consola.emitirError(e.getMessage());
      }
  }
  //metodo de calculo del promedio
  private void calcularPromedioAltitud(){
      try{
          gestor.estaVacio();
          Consola.emitirMensajeLN("Promedio de Altitud");
          double prom = gestor.calcularPromedioAltitud();
          Consola.emitirMensajeLN(String.format("el promedio de altitud es:%.2f msnm",prom));
      }catch(RepositorioVacioException e){
          Consola.emitirError(e.getMessage());
      }
  }
  //metodo de contar la accesibilad alta 
  private void contarYmostrarAccesAlta(){
      try{
          gestor.estaVacio();
          Consola.emitirMensajeLN("Punto de Accesibilidad alta");
          int cant = gestor.contarAccesAlta();
          Consola.emitirResultado(40, "-","la cantidad de Accesibilidad alta es :"+cant );
      }catch(RepositorioVacioException e){
          Consola.emitirError(e.getMessage());
      }
  }
}
