package persistencia.ctrldata;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;

import java.util.ArrayList;

public class ICtrlCuentaBancaria implements CtrlCuentaBancaria {

    private ArrayList<CuentaBancaria> toSave;

    public ICtrlCuentaBancaria() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public CuentaBancaria get(int id) {
        return null;
    }

    @Override
    public ArrayList<CuentaBancaria> getAll() {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public void add(CuentaBancaria cb) {

    }

    @Override
    public void remove(CuentaBancaria cb) {

    }

    @Override
    public void save() {

    }
}
