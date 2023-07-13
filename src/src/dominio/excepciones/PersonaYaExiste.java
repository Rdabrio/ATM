package dominio.excepciones;

public class PersonaYaExiste extends Exception {
    public PersonaYaExiste() {
        super("La persona ya existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
