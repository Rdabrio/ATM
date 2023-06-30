package dominio.controladores;

import dominio.clases.FechaYHora;
import dominio.clases.Titular;
import dominio.clases.Transferencia;
import dominio.excepciones.*;
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

        //Comprobacion balances
        if (cantidad > emisor.getBalance()) throw new BalanceInsuficiente();
        if (cantidad > 500000 || cantidad <= 0) throw new CantidadTransferenciaIncorrecta();

        //Crear transferencia y añadir los conjuntos de datos
        Transferencia transferencia = new Transferencia(emisor, receptor, new FechaYHora(), cantidad, concepto);
        receptor.addTransferenciaRecibida(transferencia);
        emisor.addTransferenciaEmitida(transferencia);
        receptor.setBalance(receptor.getBalance()+cantidad);
        emisor.setBalance(receptor.getBalance()-cantidad);

        CtrlTransferencia ctrlTransferencia = FactoriaCtrl.getInstance().getCtrlTransferencia();
        ctrlTransferencia.add(transferencia);
    }
}
