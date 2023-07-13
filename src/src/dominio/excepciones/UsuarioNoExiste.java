package dominio.excepciones;

public class UsuarioNoExiste extends Exception {
    public UsuarioNoExiste() {
        super("El usuario no existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
