package dominio.controladores;

import dominio.clases.Banco;
import dominio.clases.CuentaBancaria;
import dominio.excepciones.BancoYaExiste;
import persistencia.ctrldata.CtrlBanco;
import persistencia.ctrldata.FactoriaCtrl;

import java.util.ArrayList;

public class TrAltaBanco extends Transaccion {

    String nombre;

    ArrayList<CuentaBancaria> cuentas;

    Banco result;

    public TrAltaBanco(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void execute() throws BancoYaExiste {
        //Comprobar si ya existe el banco
        CtrlBanco ctrlBanco = FactoriaCtrl.getInstance().getCtrlBanco();
        if (ctrlBanco.exists(nombre)) throw new BancoYaExiste();

        //Crear banco y añadir las cuentas asociadas a el (en caso de indicar alguna)
        Banco banco = new Banco(nombre);
        for (CuentaBancaria cb : cuentas) banco.addCuenta(cb);

        //Añadir el banco al controlador para guardarlo en datos y dejarlo como resultado
        ctrlBanco.add(banco);
        result = banco;
    }

    public Banco getResult() {
        return this.result;
    }
}
