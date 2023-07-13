package dominio.excepciones;

public class BancoNoExiste extends Exception{
    public BancoNoExiste() {
        super("El Banco identificado por el nombre no existe");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
