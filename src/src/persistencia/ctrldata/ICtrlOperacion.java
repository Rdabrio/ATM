package persistencia.ctrldata;

import dominio.clases.Operacion;

import java.util.ArrayList;

public class ICtrlOperacion implements CtrlOperacion {
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
}
