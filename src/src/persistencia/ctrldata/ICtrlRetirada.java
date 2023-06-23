package persistencia.ctrldata;

import dominio.clases.Retirada;

import java.util.ArrayList;

public class ICtrlRetirada implements CtrlRetirada {
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
}
