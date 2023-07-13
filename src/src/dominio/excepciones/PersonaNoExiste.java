package dominio.excepciones;

public class PersonaNoExiste extends Exception {
    public PersonaNoExiste() {
        super("La persona no existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
