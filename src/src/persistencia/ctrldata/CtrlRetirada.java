package persistencia.ctrldata;

import dominio.clases.Persona;
import dominio.clases.Retirada;

import java.util.ArrayList;

public interface CtrlRetirada {
    public Retirada get(String fecha, String email, int id, String nombreUsuario);

    public ArrayList<Retirada> getAll();

    public boolean exists(String fecha, String email, int id, String nombreUsuario);

    public void add(Retirada r);

    public void remove(Retirada r);

    public void save();
}
