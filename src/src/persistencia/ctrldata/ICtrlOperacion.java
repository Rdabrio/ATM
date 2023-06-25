package persistencia.ctrldata;

import dominio.clases.Ingreso;
import dominio.clases.Operacion;

import java.util.ArrayList;

public class ICtrlOperacion implements CtrlOperacion {

    private ArrayList<Operacion> toSave;

    public ICtrlOperacion() {
        this.toSave = new ArrayList<>();
    }

    @Override
    public Operacion get(String fecha, String email, int id, String nombreUsuario) {
        return null;
    }

    @Override
    public ArrayList<Operacion> getAll() {
        return null;
    }

    @Override
    public boolean exists(String fecha, String email, int id, String nombreUsuario) {
        return false;
    }

    @Override
    public void add(Operacion o) {

    }

    @Override
    public void remove(Operacion o) {

    }

    @Override
    public void save() {

    }
}
