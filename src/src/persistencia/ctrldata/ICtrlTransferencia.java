package persistencia.ctrldata;

import dominio.clases.Transferencia;

import java.util.ArrayList;

public class ICtrlTransferencia implements CtrlTransferencia {
    @Override
    public Transferencia get(String emailR, int idR, String nusuarioR, String emailE, int idE, String nusuarioE, String fecha) {
        return null;
    }

    @Override
    public ArrayList<Transferencia> getAll() {
        return null;
    }

    @Override
    public boolean exists(String emailR, int idR, String nusuarioR, String emailE, int idE, String nusuarioE, String fecha) {
        return false;
    }
}
