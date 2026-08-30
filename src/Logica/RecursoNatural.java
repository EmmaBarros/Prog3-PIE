package Logica;

import Utilidades.*;

/**
 *
 * @author emami
 */
public class RecursoNatural extends PuntoInteres {

    private final String[] catText = {"Cascada", "Laguna", "Bosque", "Formacion Rocosa"};
    private int categoria;

    public RecursoNatural() {
        super();
        this.categoria = 0;
    }

    @Override
    public void cargarDatos(int codVal) throws DatoInvalidoException {
        super.cargarDatos(codVal);
        leerCategoria();

    }

    private void leerCategoria() throws DatoInvalidoException {
        int cat;
        Consola.emitirMensajeLN("ingrese la categoria ");
        Consola.emitirLista(catText);
        cat = Lector.leerInt();
        if (!Validador.esNroValido(cat, 1, catText.length)) {
            throw new DatoInvalidoException("numero de categoria invalio");
        }
        setCategoria(cat);
    }

    public String[] getCatText() {
        return catText;
    }

   

    public String getCategoria() {
        if(this.categoria < 1 || this.categoria > catText.length){
            return "Sin Definir";
        }
        return catText[categoria - 1];
    }

    private void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(toString());
    }

    @Override
    public String obtenerTipo() {
        return "Recurso Natural";
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s | Código: %d | Nombre: %s | Altitud: %.2f m | Accesibilidad: %s | Categoría: %s",
                obtenerTipo(), codigo, nombre, altitud, getNivelAcces(), getCategoria());
    }

}
