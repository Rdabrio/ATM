package persistencia.ctrldata;

import dominio.clases.FechaYHora;

import java.util.ArrayList;

public class ICtrlFechaYHora implements CtrlFechaYHora {
    @Override
    public FechaYHora get(String fecha) {
        return null;
    }

    @Override
    public ArrayList<FechaYHora> getAll() {
        return null;
    }

    @Override
    public boolean exists(String fecha) {
        return false;
    }
}
