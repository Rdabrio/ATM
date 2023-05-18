package dominio;

public abstract class Operacion {
    private Titular titular;
    private FechaYHora fechaYHora;
    private float cantidad;

    public Operacion(Titular titular, FechaYHora fechaYHora, float cantidad) {
        this.titular = titular;
        this.fechaYHora = fechaYHora;
        this.cantidad = cantidad;
    }

    public Titular getTitular() {
        return titular;
    }

    public FechaYHora getFechaYHora() {
        return fechaYHora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaYHora(FechaYHora fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
