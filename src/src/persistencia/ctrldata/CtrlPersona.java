package persistencia.ctrldata;

import dominio.clases.Persona;

import java.util.ArrayList;

public interface CtrlPersona {
    public Persona get(String email);

    public ArrayList<Persona> getAll();

    public boolean exists(String email);
}
