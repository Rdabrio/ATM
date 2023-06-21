package persistencia.ctrldata;

import dominio.clases.Operacion;

import java.util.ArrayList;

public interface CtrlOperacion {
    public Operacion get(String fecha, String email, int id, String nombreUsuario);

    public ArrayList<Operacion> getAll();

    public boolean exists(String fecha, String email, int id, String nombreUsuario);
}
