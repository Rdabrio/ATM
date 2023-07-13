package dominio.excepciones;

public class BalanceInsuficiente extends Exception {
    public BalanceInsuficiente() {
        super("El balance de la cuenta es insuficiente");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
