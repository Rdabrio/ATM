package dominio.excepciones;

public class CantidadIngresoIncorrecta extends Exception {
    public CantidadIngresoIncorrecta() {
        super("La cantidad no puede ser mayor a 1000 ni menor a 0");
    }
}
