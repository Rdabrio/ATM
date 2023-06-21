package persistencia.ctrldata;

import dominio.clases.Titular;

import java.util.ArrayList;

public interface CtrlTitular {
    public Titular get(String email, int id, String nombreUsuario);

    public ArrayList<Titular> getAll();

    public boolean exists(String email, int id, String nombreUsuario);
}
