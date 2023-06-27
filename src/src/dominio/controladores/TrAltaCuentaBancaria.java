package dominio.controladores;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;
import dominio.excepciones.BancoNoExiste;
import dominio.excepciones.CuentaBancariaYaExiste;
import persistencia.ctrldata.CtrlBanco;
import persistencia.ctrldata.CtrlCuentaBancaria;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaCuentaBancaria extends Transaccion {

    private String nombreBanco;
    private int id;

    public TrAltaCuentaBancaria(String nombreBanco, int id) {
        this.nombreBanco = nombreBanco;
        this.id = id;
    }

    @Override
    public void execute() throws CuentaBancariaYaExiste, BancoNoExiste {

        //Comprobar que no exista la cuenta bancaria
        CtrlCuentaBancaria ctrlCuentaBancaria = FactoriaCtrl.getInstance().getCtrlCuentaBancaria();
        if (ctrlCuentaBancaria.exists(id)) throw new CuentaBancariaYaExiste();

        //Comprobar que el banco existe
        CtrlBanco ctrlBanco = FactoriaCtrl.getInstance().getCtrlBanco();
        if (!ctrlBanco.exists(nombreBanco)) throw new BancoNoExiste();
        Banco banco = ctrlBanco.get(nombreBanco);

        //Crear cuenta bancaria y añadirla al conjunto de datos
        CuentaBancaria cuentaBancaria = new CuentaBancaria(id, banco);
        banco.addCuenta(cuentaBancaria);
        ctrlCuentaBancaria.add(cuentaBancaria);
    }
}
