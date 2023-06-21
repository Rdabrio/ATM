package dominio.clases;

public class Ingreso extends Operacion{

    private String concepto;

    public Ingreso(Titular titular, FechaYHora fechaYHora, float cantidad, String concepto) {
        super(titular, fechaYHora, cantidad);
        this.concepto = concepto;
    }


    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
