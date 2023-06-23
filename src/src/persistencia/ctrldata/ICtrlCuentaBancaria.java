package persistencia.ctrldata;

import dominio.clases.CuentaBancaria;

import java.util.ArrayList;

public class ICtrlCuentaBancaria implements CtrlCuentaBancaria {
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
}
