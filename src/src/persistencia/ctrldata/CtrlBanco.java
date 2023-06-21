package persistencia.ctrldata;

import dominio.clases.Banco;

import java.util.ArrayList;

public interface CtrlBanco {
    public Banco get(String nombre);

    public ArrayList<Banco> getAll();

    public boolean exists(String nombre);
}
