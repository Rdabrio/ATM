package dominio.clases;

public class Moneda {

    private static Moneda instance;

    private String monedaActual = "EUR";

    private Moneda() {

    }

    public static Moneda getInstance() {
        if (instance == null) instance = new Moneda();
        return instance;
    }
}
