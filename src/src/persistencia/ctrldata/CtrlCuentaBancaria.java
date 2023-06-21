package persistencia.ctrldata;

import dominio.clases.CuentaBancaria;

import java.util.ArrayList;

public interface CtrlCuentaBancaria {
    public CuentaBancaria get(int id);

    public ArrayList<CuentaBancaria> getAll();

    public boolean exists(int id);
}
