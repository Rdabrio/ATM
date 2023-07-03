package dominio.excepciones;

public class CantidadOperacionIncorrecta extends Exception {
    public CantidadOperacionIncorrecta() {
        super("La cantidad no puede ser mayor a 1000 ni menor a 0");
    }
}
