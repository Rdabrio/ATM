package dominio.excepciones;

public class PasswordIncorrecta extends Exception {
    public PasswordIncorrecta() {
        super("La contrasena es incorrecta");
    }
}
