package Logica;
import Utilidades.Validador;
/**
 *
 * @author emami
 */
public class RecursoNatural extends PuntoInteres {

    private String[] catText = {"Cascada", "Laguna", "Bosque", "Formacion Rocosa"};
    private int categoria;

    public RecursoNatural() {
        super();
        this.categoria = 0;
    }

    public RecursoNatural(int codigo, String nombre, double altitud, int nivelAcces,int categoria)throws DatoInvalidoException {
        super(codigo, nombre, altitud, nivelAcces);
        setCategoria(categoria);
    }
    
    

    public String[] getCatText() {
        return catText;
    }

    private void setCatText(String[] catText) {
        this.catText = catText;
    }

    public String getCategoria() {
        return catText[categoria-1];
    }

    private void setCategoria(int categoria) throws DatoInvalidoException {
        if(!Validador.esNroValido(categoria, 1, catText.length)){
            throw new DatoInvalidoException("La categoria debe estar entre 1-2-3-4");
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
