package presentacion;

import Logica.*;
import Utilidades.Consola;
import Utilidades.Lector;
import Utilidades.Validador;

/**
 *
 * @author emami
 */
public class LectorPuntoInteres {

    //metodo de carga 
    public void cargarPunto(PuntoInteres p, int codigo, int tipo) throws DatoInvalidoException {
        p.setCodigo(codigo); // codigo entra por parametros xq se leen en el registrar() en  AppIE
        leerDatosBase(p);
        leerDatosEspecificos(p, tipo);
    }

    //metodos de lectura de datos y especificos
    private void leerDatosBase(PuntoInteres p) throws DatoInvalidoException {
        leerNombre(p);//llama a los lectores 
        leerAltitud(p);
        leerNivelAcces(p);
    }
//meotods de leer especificos llamando a los setters que ya aplican su verificacion 

    private void leerNombre(PuntoInteres p) throws DatoInvalidoException {
        Consola.emitirMensajeLN("ingrese el nombre :");
        String nombre = Lector.leerString();
        p.setNombre(nombre);
    }

    private void leerAltitud(PuntoInteres p) throws DatoInvalidoException {
        Consola.emitirMensajeLN("ingrese la altitud s. Niv/mar :");
        double altitud = Lector.leerDouble();
        p.setAltitud(altitud);
    }

    private void leerNivelAcces(PuntoInteres p) throws DatoInvalidoException {
        Consola.emitirMensajeLN("ingrese el nivel de acceso :");
        Consola.emitirLista(p.getNivAccesVal());
        int nivel = Lector.leerInt();
        p.setNivelAcces(nivel);
    }

    //metodo de leer los datos especificos de las sublcases utilizando switch para seleccionar el metodod especifico
    private void leerDatosEspecificos(PuntoInteres p, int tipo) throws DatoInvalidoException {
        switch (tipo) {
            case 1:
                leerTipoVista((Mirador) p);
                break;
            case 2:
                leerCategoria((RecursoNatural) p);
                break;
            case 3:
                leerTipoServ((PuestoServicio) p);
                break;
        }
    }

    private void leerTipoVista(Mirador m) throws DatoInvalidoException {
        Consola.emitirMensajeLN("ingrese el tipo de Vista");
        Consola.emitirLista(m.getTipoVistaText());
        int tipoVista = Lector.leerInt();
        m.setTipoVista(tipoVista);
    }

    private void leerCategoria(RecursoNatural r) throws DatoInvalidoException {
        Consola.emitirMensajeLN("ingrese la categoria ");
        Consola.emitirLista(r.getCatText());
        int cat = Lector.leerInt();
        r.setCategoria(cat);
    }

    private void leerTipoServ(PuestoServicio ps) throws DatoInvalidoException {
        Consola.emitirMensajeLN("Ingrese el tipo de servicio:");
        Consola.emitirLista(ps.getTipoServText());
        int serv = Lector.leerInt();
        ps.setTipoServ(serv);
    }

}
