package persistencia.ctrldata;

public class FactoriaCtrl {

    private static FactoriaCtrl instance;
    private CtrlBanco ctrlBanco;
    private CtrlCuentaBancaria ctrlCuentaBancaria;
    private CtrlFechaYHora ctrlFechaYHora;
    private CtrlIngreso ctrlIngreso;
    private CtrlOperacion ctrlOperacion;
    private CtrlPersona ctrlPersona;
    private CtrlRetirada ctrlRetirada;
    private CtrlTitular ctrlTitular;
    private CtrlTransferencia ctrlTransferencia;

    private FactoriaCtrl() {
        ctrlBanco = new ICtrlBanco();
        ctrlCuentaBancaria = new ICtrlCuentaBancaria();
        ctrlFechaYHora = new ICtrlFechaYHora();
        ctrlIngreso = new ICtrlIngreso();
        ctrlOperacion = new ICtrlOperacion();
        ctrlPersona = new ICtrlPersona();
        ctrlRetirada = new ICtrlRetirada();
        ctrlTitular = new ICtrlTitular();
        ctrlTransferencia = new ICtrlTransferencia();
    }

    public static FactoriaCtrl getInstance() {
        if (instance == null) instance = new FactoriaCtrl();
        return instance;
    }

    public CtrlBanco getCtrlBanco() {
        return ctrlBanco;
    }

    public CtrlCuentaBancaria getCtrlCuentaBancaria() {
        return ctrlCuentaBancaria;
    }

    public CtrlFechaYHora getCtrlFechaYHora() {
        return ctrlFechaYHora;
    }

    public CtrlIngreso getCtrlIngreso() {
        return ctrlIngreso;
    }

    public CtrlOperacion getCtrlOperacion() {
        return ctrlOperacion;
    }

    public CtrlPersona getCtrlPersona() {
        return ctrlPersona;
    }

    public CtrlRetirada getCtrlRetirada() {
        return ctrlRetirada;
    }

    public CtrlTitular getCtrlTitular() {
        return ctrlTitular;
    }

    public CtrlTransferencia getCtrlTransferencia() {
        return ctrlTransferencia;
    }
}
