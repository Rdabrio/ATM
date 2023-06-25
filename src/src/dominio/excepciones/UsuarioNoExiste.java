package dominio.excepciones;

public class UsuarioNoExiste extends Exception {
    public UsuarioNoExiste() {
        super("El usuario no existe");
    }
}
