package persistencia.ctrldata;

import dominio.clases.Transferencia;

import java.util.ArrayList;

public interface CtrlTransferencia {
    public Transferencia get(String emailR, int idR, String nusuarioR, String emailE, int idE, String nusuarioE, String fecha);

    public ArrayList<Transferencia> getAll();

    public boolean exists(String emailR, int idR, String nusuarioR, String emailE, int idE, String nusuarioE, String fecha);
}
