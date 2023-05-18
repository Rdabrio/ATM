package dominio;

public class Retirada extends Operacion{
    public Retirada(Titular titular, FechaYHora fechaYHora, float cantidad) {
        super(titular, fechaYHora, cantidad);
    }
}
