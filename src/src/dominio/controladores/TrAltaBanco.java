package dominio.controladores;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;
import dominio.excepciones.BancoYaExiste;
import dominio.excepciones.CuentaBancariaNoExiste;
import persistencia.ctrldata.CtrlBanco;
import persistencia.ctrldata.CtrlCuentaBancaria;
import persistencia.ctrldata.FactoriaCtrl;

import java.util.ArrayList;

public class TrAltaBanco extends Transaccion {

    private String nombre;

    private ArrayList<Integer> cuentas;


    public TrAltaBanco(String nombre, ArrayList<Integer> cuentas) {
        this.nombre = nombre;
        this.cuentas = cuentas;
    }

    @Override
    public void execute() throws BancoYaExiste, CuentaBancariaNoExiste {
        //Comprobar si ya existe el banco
        CtrlBanco ctrlBanco = FactoriaCtrl.getInstance().getCtrlBanco();
        if (ctrlBanco.exists(nombre)) throw new BancoYaExiste();

        //Crear banco y añadir las cuentas asociadas a el (en caso de indicar alguna)
        Banco banco = new Banco(nombre);
        CtrlCuentaBancaria ctrlCuentaBancaria = FactoriaCtrl.getInstance().getCtrlCuentaBancaria();
        for (int id : cuentas) {
            if (!ctrlCuentaBancaria.exists(id)) throw new CuentaBancariaNoExiste();
            banco.addCuenta(ctrlCuentaBancaria.get(id));
        }

        //Añadir el banco al controlador para guardarlo en datos
        ctrlBanco.add(banco);
    }

}
