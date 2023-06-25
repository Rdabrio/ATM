package persistencia.ctrldata;

import dominio.clases.FechaYHora;
import dominio.clases.Ingreso;

import java.util.ArrayList;

public class ICtrlIngreso implements CtrlIngreso {

    private ArrayList<Ingreso> toSave;

    public ICtrlIngreso() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public Ingreso get(String fecha, String email, int id, String nombreUsuario) {
        return null;
    }

    @Override
    public ArrayList<Ingreso> getAll() {
        return null;
    }

    @Override
    public boolean exists(String fecha, String email, int id, String nombreUsuario) {
        return false;
    }

    @Override
    public void add(Ingreso i) {

    }

    @Override
    public void remove(Ingreso i) {

    }

    @Override
    public void save() {

    }
}
