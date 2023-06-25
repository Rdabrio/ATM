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

    }

    public static FactoriaCtrl getInstance() {
        if (instance == null) instance = new FactoriaCtrl();
        return instance;
    }

    public CtrlBanco getCtrlBanco() {
        if (ctrlBanco == null) ctrlBanco = new ICtrlBanco();
        return ctrlBanco;
    }

    public CtrlCuentaBancaria getCtrlCuentaBancaria() {
        if (ctrlCuentaBancaria == null) ctrlCuentaBancaria = new ICtrlCuentaBancaria();
        return ctrlCuentaBancaria;
    }

    public CtrlFechaYHora getCtrlFechaYHora() {
        if (ctrlFechaYHora == null) ctrlFechaYHora = new ICtrlFechaYHora();
        return ctrlFechaYHora;
    }

    public CtrlIngreso getCtrlIngreso() {
        if (ctrlIngreso == null) ctrlIngreso = new ICtrlIngreso();
        return ctrlIngreso;
    }

    public CtrlOperacion getCtrlOperacion() {
        if (ctrlOperacion == null) ctrlOperacion = new ICtrlOperacion();
        return ctrlOperacion;
    }

    public CtrlPersona getCtrlPersona() {
        if (ctrlPersona == null) ctrlPersona = new ICtrlPersona();
        return ctrlPersona;
    }

    public CtrlRetirada getCtrlRetirada() {
        if (ctrlRetirada == null) ctrlRetirada = new ICtrlRetirada();
        return ctrlRetirada;
    }

    public CtrlTitular getCtrlTitular() {
        if (ctrlTitular == null) ctrlTitular = new ICtrlTitular();
        return ctrlTitular;
    }

    public CtrlTransferencia getCtrlTransferencia() {
        if (ctrlTransferencia == null) ctrlTransferencia = new ICtrlTransferencia();
        return ctrlTransferencia;
    }
}
