package dominio.clases;

import java.util.ArrayList;
import java.util.Date;

public class FechaYHora extends Date {

    private ArrayList<Operacion> operaciones;
    private ArrayList<Transferencia> transferencias;

    public FechaYHora() {
        super();
        operaciones = new ArrayList<>();
        transferencias = new ArrayList<>();
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public ArrayList<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(ArrayList<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    public void addOperacion(Operacion operacion) {
        operaciones.add(operacion);
    }

    public void removeOperacion(Operacion operacion) {
        operaciones.remove(operacion);
    }

    public void addTransferencia(Transferencia transferencia) {
        transferencias.add(transferencia);
    }

    public void removeTransferencia(Transferencia transferencia) {
        transferencias.remove(transferencia);
    }
}
