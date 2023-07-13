package dominio.excepciones;

public class CantidadTransferenciaIncorrecta extends Exception {
    public CantidadTransferenciaIncorrecta() {
        super("La cantidad no puede ser mayor a 500000 ni menor o igual a 0");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
