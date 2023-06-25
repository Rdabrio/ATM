package dominio.controladores;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;
import dominio.clases.Titular;
import dominio.excepciones.BancoNoExiste;
import dominio.excepciones.CuentaBancariaYaExiste;
import dominio.excepciones.TitularNoExiste;
import persistencia.ctrldata.CtrlBanco;
import persistencia.ctrldata.CtrlCuentaBancaria;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaCuentaBancaria extends Transaccion {

    private int id;
    private String nombreBanco;
    private String emailTitular;

    public TrAltaCuentaBancaria(int id, String nombreBanco, String emailTitular) {
        this.id = id;
        this.nombreBanco = nombreBanco;
        this.emailTitular = emailTitular;
    }

    @Override
    public void execute() throws CuentaBancariaYaExiste, BancoNoExiste, TitularNoExiste {

        //Comprobar si ya existe la cuenta bancaria
        CtrlCuentaBancaria ctrlCuentaBancaria = FactoriaCtrl.getInstance().getCtrlCuentaBancaria();
        if (ctrlCuentaBancaria.exists(this.id)) throw new CuentaBancariaYaExiste();

        //Obtener el banco al que se va a asociar
        CtrlBanco ctrlBanco = FactoriaCtrl.getInstance().getCtrlBanco();
        if (!ctrlBanco.exists(this.nombreBanco)) throw new BancoNoExiste();
        Banco banco = ctrlBanco.get(this.nombreBanco);

        CuentaBancaria cuentaBancaria;

        //Si se quiere asociar un titular
        if (!emailTitular.equals("")) {
            CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
            if (!ctrlTitular.exists(this.emailTitular, this.id)) throw new TitularNoExiste();
            Titular titular = ctrlTitular.get(this.emailTitular, this.id);
            cuentaBancaria = new CuentaBancaria(this.id, banco, titular);
        }
        else cuentaBancaria = new CuentaBancaria(this.id, banco);

        //Añadir la cuenta bancaria al controlador para guardarlo en datos
        ctrlCuentaBancaria.add(cuentaBancaria);
    }
}
