package dominio.controladores;

import dominio.clases.CuentaBancaria;
import dominio.clases.Persona;
import dominio.clases.Titular;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlCuentaBancaria;
import persistencia.ctrldata.CtrlPersona;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.FactoriaCtrl;

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

        //AQUI ELIMINAR TITULAR DE LAS TRANSFERENCIAS Y SUS OPERACIONES

        ctrlTitular.remove(titular);

    }
}
