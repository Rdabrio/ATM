package persistencia.ctrldata;

import dominio.clases.Ingreso;

import java.util.ArrayList;

public interface CtrlIngreso {
    public Ingreso get(String fecha, String email, int id, String nombreUsuario);

    public ArrayList<Ingreso> getAll();

    public boolean exists(String fecha, String email, int id, String nombreUsuario);
}
