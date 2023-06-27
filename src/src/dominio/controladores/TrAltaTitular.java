package dominio.controladores;

import dominio.clases.CuentaBancaria;
import dominio.clases.Persona;
import dominio.clases.Titular;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlCuentaBancaria;
import persistencia.ctrldata.CtrlPersona;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaTitular extends Transaccion {

    private String emailPersona;
    private int idCuenta;
    private String nombreUsuario;
    private String password;

    private int IBAN;

    public TrAltaTitular(String emailPersona, int idCuenta, String nombreUsuario, String password, int IBAN) {
        this.emailPersona = emailPersona;
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.IBAN = IBAN;
    }

    @Override
    public void execute() throws CuentaBancariaNoExiste, TitularYaExiste, PersonaNoExiste {

        //Comprobar que no existe el titular
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        if (ctrlTitular.exists(emailPersona, idCuenta)) throw new TitularYaExiste();
        Titular titular = new Titular(nombreUsuario, password, 0, IBAN);

        //Comprobar que existe la persona y la cuenta bancaria, asignarlas y guardar el titular en datos
        CtrlPersona ctrlPersona = FactoriaCtrl.getInstance().getCtrlPersona();
        if (!ctrlPersona.exists(emailPersona)) throw new PersonaNoExiste();
        Persona persona = ctrlPersona.get(emailPersona);

        CtrlCuentaBancaria ctrlCuentaBancaria = FactoriaCtrl.getInstance().getCtrlCuentaBancaria();
        if (!ctrlCuentaBancaria.exists(idCuenta)) throw new CuentaBancariaNoExiste();
        CuentaBancaria cuentaBancaria = ctrlCuentaBancaria.get(idCuenta);

        titular.setPropietario(persona);
        persona.addTitular(nombreUsuario, titular);
        titular.setCuenta(cuentaBancaria);
        cuentaBancaria.setTitular(titular);
        ctrlTitular.add(titular);
    }
}
