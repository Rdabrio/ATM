package persistencia.ctrldata;

import dominio.clases.CuentaBancaria;
import dominio.clases.FechaYHora;

import java.util.ArrayList;

public class ICtrlFechaYHora implements CtrlFechaYHora {

    private ArrayList<FechaYHora> toSave;

    public ICtrlFechaYHora() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public FechaYHora get(String fecha) {
        return null;
    }

    @Override
    public ArrayList<FechaYHora> getAll() {
        return null;
    }

    @Override
    public boolean exists(String fecha) {
        return false;
    }

    @Override
    public void add(FechaYHora f) {

    }

    @Override
    public void remove(FechaYHora f) {

    }

    @Override
    public void save() {

    }
}
