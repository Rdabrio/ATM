package dominio.excepciones;

public class CuentaBancariaNoExiste extends Exception {
    public CuentaBancariaNoExiste() {
        super("La cuenta bancaria no existe");
    }
}
