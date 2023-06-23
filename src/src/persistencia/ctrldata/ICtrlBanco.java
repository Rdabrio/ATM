package persistencia.ctrldata;

import dominio.clases.Banco;

import java.util.ArrayList;

public class ICtrlBanco implements CtrlBanco{
    @Override
    public Banco get(String nombre) {
        return null;
    }

    @Override
    public ArrayList<Banco> getAll() {
        return null;
    }

    @Override
    public boolean exists(String nombre) {
        return false;
    }
}
