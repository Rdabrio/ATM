package dominio.controladores;

import dominio.clases.Banco;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlBanco;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaBanco extends Transaccion {

    private String nombre;

    public TrAltaBanco(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void execute() throws BancoYaExiste {

        //Comprobar que no existe
        CtrlBanco ctrlBanco = FactoriaCtrl.getInstance().getCtrlBanco();
        if (ctrlBanco.exists(nombre)) throw new BancoYaExiste();

        //Crear banco y añadirlo al conjunto de datos de bancos
        Banco b = new Banco(nombre);
        ctrlBanco.add(b);
    }
}
