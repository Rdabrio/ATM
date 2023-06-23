package persistencia.ctrldata;

import dominio.clases.Titular;

import java.util.ArrayList;

public class ICtrlTitular implements CtrlTitular {
    @Override
    public Titular get(String email, int id, String nombreUsuario) {
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
}
