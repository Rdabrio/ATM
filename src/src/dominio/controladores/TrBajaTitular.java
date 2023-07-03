package dominio.controladores;

import dominio.clases.*;
import dominio.excepciones.*;
import persistencia.ctrldata.*;

import java.util.ArrayList;

public class TrBajaTitular extends Transaccion {

    private String emailPersona;
    private int idCuenta;

    public TrBajaTitular(String emailPersona, int idCuenta) {
        this.emailPersona = emailPersona;
        this.idCuenta = idCuenta;
    }

    @Override
    public void execute() throws TitularNoExiste {

        //Comprobar que no se ha borrado ya
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        if (!ctrlTitular.exists(emailPersona, idCuenta)) throw new TitularNoExiste();
        Titular titular = ctrlTitular.get(emailPersona, idCuenta);

        //Eliminar el titular de las clases que lo contienen y del conjunto de datos
        CtrlCuentaBancaria ctrlCuentaBancaria = FactoriaCtrl.getInstance().getCtrlCuentaBancaria();
        CuentaBancaria cuentaBancaria = ctrlCuentaBancaria.get(idCuenta);
        cuentaBancaria.setTitular(null);

        CtrlPersona ctrlPersona = FactoriaCtrl.getInstance().getCtrlPersona();
        Persona persona = ctrlPersona.get(emailPersona);
        persona.removeTitular(titular.getNombreUsuario());

        //Eliminar las transferencias emitidas o recibidas por el titular que queremos dar de baja y sus asociaciones
        CtrlTransferencia ctrlTransferencia = FactoriaCtrl.getInstance().getCtrlTransferencia();
        ArrayList<Transferencia> transferencias = ctrlTransferencia.getAll();

        for (Transferencia t : transferencias) {
            if (t.getEmisor() == titular || t.getReceptor() == titular) {
                FechaYHora fechaYHora = t.getFechaYHora();
                fechaYHora.removeTransferencia(t);
                ctrlTransferencia.remove(t);
            }
        }

        //Eliminar las operaciones hechas por el titular que queremos dar de baja y sus asociaciones
        CtrlOperacion ctrlOperacion = FactoriaCtrl.getInstance().getCtrlOperacion();
        ArrayList<Operacion> operaciones = ctrlOperacion.getAll();

        for (Operacion o : operaciones) {
            if (o.getTitular() == titular) {
                FechaYHora fechaYHora = o.getFechaYHora();
                fechaYHora.removeOperacion(o);
                ctrlOperacion.remove(o);
            }
        }

        //Eliminar titular
        ctrlTitular.remove(titular);
    }
}
