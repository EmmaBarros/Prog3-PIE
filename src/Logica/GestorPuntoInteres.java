package Logica;

import Dato.RepositorioPuntoInteres;

/**
 *
 * @author emami
 */
public class GestorPuntoInteres {

    private final RepositorioPuntoInteres repositorio;

    public GestorPuntoInteres(RepositorioPuntoInteres repositorio) {
        this.repositorio = repositorio;
    }

    /*func.1
valida la duplicidad y agrega
     */
    public void registrarPuntoInteres(PuntoInteres nuevoPunto) throws CodigoDuplicadoException, RepositorioLlenoException {
        if (repositorio.existeCodigo(nuevoPunto.getCodigo())) {
            throw new CodigoDuplicadoException("el codigo " + nuevoPunto.getCodigo() + "inrgresado ya exsite");
        }
        repositorio.agregar(nuevoPunto);
    }

    public boolean exsiteCodigo(int codigo) {
        return repositorio.existeCodigo(codigo);
    }
    
    public void estaVacio()throws RepositorioVacioException{
        if(repositorio.estaVacio()){
            throw new RepositorioVacioException("no hay puntos de interese cargados");
        }
    }
    public void estaLleno()throws RepositorioLlenoException{
        if (repositorio.estaLleno()) {
            throw new RepositorioLlenoException("no queda mas espacio");
        }
    }
    
    /*func.2 metodo de muestra que utiliza otro mostrar con recorrido recursivo
     */
    public void mostrarPuntos() {
        mostrarRecursivo(0);
    }

    /*metodo privado recursivo que recorre y muestra los datos*/
    private void mostrarRecursivo(int posicion) {
        if (posicion >= repositorio.cantidad()) {
            return;
        }//caso base retorna y sale cuando la posicion alcance la cantidad
        PuntoInteres actual = repositorio.obtener(posicion);//utiliza la interface para obtener el elemento sin ingrear al arreglo
        if (actual != null) {
            actual.mostrarInformacion();//muestra
        }

        mostrarRecursivo(posicion + 1);//avanza al siguiente elemento 
    }

    //func 3. busca un puntode interes por codigo usando la busqueda recursiva del repo
    public PuntoInteres buscarPorCodigo(int codigo) {
        return repositorio.buscarPorCodigo(codigo);
    }

    //func4. contar llama al metodo recursivo  que retorna la cantidad
    public int contarPorTipo(String tipo) {
        return contarPorTipoRecursivo(tipo, 0);
    }

    private int contarPorTipoRecursivo(String tipo, int posicion) {
        if (posicion >= repositorio.cantidad()) {
            return 0;//caso base si llegamos al final
        }
        PuntoInteres actual = repositorio.obtener(posicion);//obtiene el elemento mediante la interface
        int coincide = 0;
        if (actual != null && actual.obtenerTipo().equalsIgnoreCase(tipo)) {
            coincide = 1;  // inicializa 
        }
        return coincide + contarPorTipoRecursivo(tipo, posicion + 1);//suma 1 + el resultadodel resto del arreglo 
    }

    // func.5 llama al metodo recursivo que se encarga de buscar el objeto con la mayor altitud y lo0 devuelve 
    public PuntoInteres determinarMayorAltitud() {
        if (repositorio.cantidad() == 0) {
            return null;
        }
        return mayorAltitudRecursivo(1, repositorio.obtener(0));
    }

    private PuntoInteres mayorAltitudRecursivo(int posicion, PuntoInteres mayorActual) {
        if (posicion >= repositorio.cantidad()) {
            return mayorActual;//caso base si llegasmo al final del arreglo
        }
        PuntoInteres actual = repositorio.obtener(posicion);
        //comparacion de mayor
        if (actual.getAltitud() > mayorActual.getAltitud()) {
            mayorActual = actual;
        }
        return mayorAltitudRecursivo(posicion + 1, mayorActual);
    }

    //func6. metodo de calcularAltitud calcula el promedo llamando al sumar altitudes que es recursivo
    public double calcularPromedioAltitud() {
        if (repositorio.cantidad() == 0) {
            return 0.0;
        }
        double sumaTotal = sumarAltitudRecursivo(0);
        return sumaTotal / repositorio.cantidad();
    }

    private double sumarAltitudRecursivo(int posicion) {
        if (posicion >= repositorio.cantidad()) {
            return 0.0;//caso base si se llega al final
        }
        PuntoInteres actual = repositorio.obtener(posicion);//se obtiene el elemento
        return actual.getAltitud() + sumarAltitudRecursivo(posicion + 1);//retorna la suma de altitudes
    }

    //func7. cuentalos puntos con accesibilidad Alta usando el ignoreCase
    public int contarAccesAlta() {
        return contarAccesAltaRecursivo(0);
    }

    private int contarAccesAltaRecursivo(int posicion) {
        if (posicion >= repositorio.cantidad()) {
            return 0; // caso base si se llega al final
        }
        PuntoInteres actual = repositorio.obtener(posicion);//Se obtiene el elemento
        int cuenta = 0;
        if (actual != null && actual.esAccesibilidadAlta()) {
            cuenta = 1;
        }
        return cuenta + contarAccesAltaRecursivo(posicion +1);//retorna la cuenta de puntos 
    }

}
