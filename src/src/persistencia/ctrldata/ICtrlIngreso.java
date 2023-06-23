package persistencia.ctrldata;

import dominio.clases.Ingreso;

import java.util.ArrayList;

public class ICtrlIngreso implements CtrlIngreso {
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
}
