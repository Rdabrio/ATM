package persistencia.ctrldata;

import dominio.clases.Operacion;
import dominio.clases.Persona;

import java.util.ArrayList;

public class ICtrlPersona implements CtrlPersona {

    private ArrayList<Persona> toSave;

    public ICtrlPersona() {
        this.toSave = new ArrayList<>();
    }

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

    @Override
    public void add(Persona p) {

    }

    @Override
    public void remove(Persona p) {

    }

    @Override
    public void save() {

    }
}
