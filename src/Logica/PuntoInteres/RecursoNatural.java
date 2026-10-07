package Logica.PuntoInteres;

import Logica.Excepciones.DatoInvalidoException;
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

    public RecursoNatural(int codigo) {
        super(codigo);
        this.categoria = 0;
    }

    public String[] getCatText() {
        return catText;
    }

    public String getCategoria() {
        if (this.categoria < 1 || this.categoria > catText.length) {
            return "Sin Definir";
        }
        return catText[categoria - 1];
    }

    public void setCategoria(int categoria) throws DatoInvalidoException {
        if (!Validador.esNroValido(categoria, 1, catText.length)) {
            throw new DatoInvalidoException("numero de categoria invalido...");
        }
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
