package persistencia.ctrldata;

import dominio.clases.Operacion;
import dominio.clases.Persona;

import java.util.ArrayList;

public interface CtrlPersona {
    public Persona get(String email);

    public ArrayList<Persona> getAll();

    public boolean exists(String email);

    public void add(Persona p);

    public void remove(Persona p);

    public void save();
}
