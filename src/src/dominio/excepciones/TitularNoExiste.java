package dominio.excepciones;

public class TitularNoExiste extends Exception {
    public TitularNoExiste() {
        super("El titular no existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
