package dominio.excepciones;

public class BancoYaExiste extends Exception {
    public BancoYaExiste() {
        super("El Banco identificado por el nombre ya existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
