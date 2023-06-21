package persistencia.ctrldata;

import dominio.clases.FechaYHora;

import java.util.ArrayList;

public interface CtrlFechaYHora {
    public FechaYHora get(String fecha);

    public ArrayList<FechaYHora> getAll();

    public boolean exists(String fecha);
}
