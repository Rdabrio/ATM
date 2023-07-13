package dominio.excepciones;

public class CuentaBancariaYaExiste extends Exception {
    public CuentaBancariaYaExiste() {
        super("La cuenta bancaria identificada por el ID ya existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
