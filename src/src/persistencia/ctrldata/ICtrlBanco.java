package persistencia.ctrldata;

import dominio.clases.Banco;

import java.util.ArrayList;

public class ICtrlBanco implements CtrlBanco {

    private ArrayList<Banco> toSave;

    public ICtrlBanco() {
        this.toSave = new ArrayList<>();
    }

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

    @Override
    public void add(Banco b) {

    }

    @Override
    public void remove(Banco b) {

    }

    @Override
    public void save() {
        for (Banco b : toSave);
    }
}
