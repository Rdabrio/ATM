package persistencia.ctrldata;

import dominio.clases.Persona;
import dominio.clases.Retirada;

import java.util.ArrayList;

public class ICtrlRetirada implements CtrlRetirada {

    private ArrayList<Retirada> toSave;

    public ICtrlRetirada() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public Retirada get(String fecha, String email, int id, String nombreUsuario) {
        return null;
    }

    @Override
    public ArrayList<Retirada> getAll() {
        return null;
    }

    @Override
    public boolean exists(String fecha, String email, int id, String nombreUsuario) {
        return false;
    }

    @Override
    public void add(Retirada r) {

    }

    @Override
    public void remove(Retirada r) {

    }

    @Override
    public void save() {

    }
}
