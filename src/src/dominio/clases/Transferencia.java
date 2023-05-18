package dominio.clases;

public class Transferencia {
    private Titular emisor;
    private Titular receptor;
    private FechaYHora fechaYHora;
    private float cantidad;
    private String concepto;

    public Transferencia(Titular emisor, Titular receptor, FechaYHora fechaYHora, float cantidad) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.fechaYHora = fechaYHora;
        this.cantidad = cantidad;
    }

    public Transferencia(Titular emisor, Titular receptor, FechaYHora fechaYHora, float cantidad, String concepto) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.fechaYHora = fechaYHora;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public FechaYHora getFechaYHora() {
        return fechaYHora;
    }

    public Titular getEmisor() {
        return emisor;
    }

    public Titular getReceptor() {
        return receptor;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setFechaYHora(FechaYHora fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setEmisor(Titular emisor) {
        this.emisor = emisor;
    }

    public void setReceptor(Titular receptor) {
        this.receptor = receptor;
    }
}
