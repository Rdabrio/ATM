package persistencia.ctrldata;

import dominio.clases.Retirada;
import dominio.clases.Titular;

import java.util.ArrayList;

public class ICtrlTitular implements CtrlTitular {

    private ArrayList<Titular> toSave;

    public ICtrlTitular() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public Titular get(String email, int id) {
        return null;
    }

    @Override
    public Titular getByNombreUsuario(String nombreUsuario) {
        return null;
    }

    @Override
    public ArrayList<Titular> getAll() {
        return null;
    }

    @Override
    public boolean exists(String email, int id, String nombreUsuario) {
        return false;
    }

    @Override
    public void add(Titular t) {

    }

    @Override
    public void remove(Titular t) {

    }

    @Override
    public void save() {

    }
}
