package persistencia.ctrldata;

import dominio.clases.Persona;
import dominio.clases.Titular;

import java.util.ArrayList;

public interface CtrlTitular {
    public Titular get(String email, int id);

    public Titular getByNombreUsuario(String nombreUsuario);

    public ArrayList<Titular> getAll();

    public boolean exists(String email, int id, String nombreUsuario);

    public void add(Titular t);

    public void remove(Titular t);

    public void save();
}
