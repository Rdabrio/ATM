package dominio.idata;

import persistencia.ctrldata.*;

public class FactoriaCtrl {
    private static FactoriaCtrl instance;
    private ICtrlBanco ctrlBanco;
    private ICtrlCuentaBancaria ctrlCuentaBancaria;
    private ICtrlFechaYHora ctrlFechaYHora;
    private ICtrlIngreso ctrlIngreso;
    private ICtrlOperacion ctrlOperacion;
    private ICtrlPersona ctrlPersona;
    private ICtrlRetirada ctrlRetirada;
    private ICtrlTitular ctrlTitular;
    private ICtrlTransferencia ctrlTransferencia;

    private FactoriaCtrl() {
        ctrlBanco = new CtrlBanco();
        ctrlCuentaBancaria = new CtrlCuentaBancaria();
        ctrlFechaYHora = new CtrlFechaYHora();
        ctrlIngreso = new CtrlIngreso();
        ctrlOperacion = new CtrlOperacion();
        ctrlPersona = new CtrlPersona();
        ctrlRetirada = new CtrlRetirada();
        ctrlTitular = new CtrlTitular();
        ctrlTransferencia = new CtrlTransferencia();
    }

    public static FactoriaCtrl getInstance() {
        if (instance == null) instance = new FactoriaCtrl();
        return instance;
    }

    public ICtrlBanco getCtrlBanco() {
        return ctrlBanco;
    }

    public ICtrlIngreso getCtrlIngreso() {
        return ctrlIngreso;
    }

    public ICtrlOperacion getCtrlOperacion() {
        return ctrlOperacion;
    }

    public ICtrlPersona getCtrlPersona() {
        return ctrlPersona;
    }

    public ICtrlCuentaBancaria getCtrlCuentaBancaria() {
        return ctrlCuentaBancaria;
    }

    public ICtrlRetirada getCtrlRetirada() {
        return ctrlRetirada;
    }

    public ICtrlTitular getCtrlTitular() {
        return ctrlTitular;
    }

    public ICtrlTransferencia getCtrlTransferencia() {
        return ctrlTransferencia;
    }

    public ICtrlFechaYHora getCtrlFechaYHora() {
        return ctrlFechaYHora;
    }
}
