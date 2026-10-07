package presentacion;

import Logica.PuntoInteres.Menu;

public class MenuEcuRoute {
    private Menu menu;
    
    public MenuEcuRoute(){
        menu = new Menu(7);
    }
    
    public int ejecutar(){
        return menu.ejecutar();
    }
    
    public void cargar(){
        String[] opciones = {
    "cargar", "mostrar", "buscar", "contar", "Mayor altitud",
    "Promedio altitud", "cantidad de accesibilidad alta",
    "Construir indice", "Mostrar ordenado (indice)", "Buscar por indice",
    "Salir"
};
        
        menu.cargarDato("Menu Ecu Route", opciones);
    }
}
