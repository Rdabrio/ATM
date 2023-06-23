package persistencia.ctrldata;

import dominio.clases.Persona;

import java.util.ArrayList;

public class ICtrlPersona implements CtrlPersona {
    @Override
    public Persona get(String email) {
        return null;
    }

    @Override
    public ArrayList<Persona> getAll() {
        return null;
    }

    @Override
    public boolean exists(String email) {
        return false;
    }
}
