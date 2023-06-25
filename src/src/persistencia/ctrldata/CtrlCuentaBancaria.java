package persistencia.ctrldata;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;

import java.util.ArrayList;

public interface CtrlCuentaBancaria {
    public CuentaBancaria get(int id);

    public ArrayList<CuentaBancaria> getAll();

    public boolean exists(int id);

    public void add(CuentaBancaria cb);

    public void remove(CuentaBancaria cb);

    public void save();
}
