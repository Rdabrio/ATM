package dominio.controladores;

import dominio.clases.FechaYHora;
import dominio.clases.Titular;
import dominio.clases.Transferencia;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlFechaYHora;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.CtrlTransferencia;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaTransferencia extends Transaccion {

    private String nombreUsuarioReceptor;
    private String nombreUsuarioEmisor;
    private String concepto;
    private float cantidad;

    public TrAltaTransferencia(String nombreUsuarioReceptor, String nombreUsuarioEmisor, String concepto, float cantidad) {
        this.nombreUsuarioReceptor = nombreUsuarioReceptor;
        this.nombreUsuarioEmisor = nombreUsuarioEmisor;
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    @Override
    public void execute() throws PasswordIncorrecta, UsuarioNoExiste, BancoYaExiste, CuentaBancariaYaExiste, BancoNoExiste, TitularNoExiste, CuentaBancariaNoExiste, PersonaYaExiste, TitularYaExiste, PersonaNoExiste, BalanceInsuficiente, CantidadTransferenciaIncorrecta {

        //Comprobar que el receptor existe
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        if (!ctrlTitular.existsNombreUsuario(nombreUsuarioReceptor)) throw new TitularNoExiste();

        Titular emisor = ctrlTitular.getByNombreUsuario(nombreUsuarioEmisor);
        Titular receptor = ctrlTitular.getByNombreUsuario(nombreUsuarioReceptor);

        float balanceEmisor = emisor.getBalance();

        //Comprobacion balances
        if (cantidad > balanceEmisor) throw new BalanceInsuficiente();
        if (cantidad > 500000 || cantidad <= 0) throw new CantidadTransferenciaIncorrecta();

        //Crear transferencia y añadir los conjuntos de datos
        FechaYHora fechaYHora = new FechaYHora();
        Transferencia transferencia = new Transferencia(emisor, receptor, fechaYHora, cantidad, concepto);
        receptor.addTransferenciaRecibida(transferencia);
        emisor.addTransferenciaEmitida(transferencia);
        receptor.setBalance(receptor.getBalance()+cantidad);
        emisor.setBalance(balanceEmisor-cantidad);
        fechaYHora.addTransferencia(transferencia);

        CtrlFechaYHora ctrlFechaYHora = FactoriaCtrl.getInstance().getCtrlFechaYHora();
        ctrlFechaYHora.add(fechaYHora);
        CtrlTransferencia ctrlTransferencia = FactoriaCtrl.getInstance().getCtrlTransferencia();
        ctrlTransferencia.add(transferencia);
    }
}
