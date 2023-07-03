package dominio.controladores;

import dominio.clases.FechaYHora;
import dominio.clases.Retirada;
import dominio.clases.Titular;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlFechaYHora;
import persistencia.ctrldata.CtrlRetirada;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.FactoriaCtrl;

public class TrAltaRetirada extends Transaccion {

    private String email;
    private int id;
    private float cantidad;

    public TrAltaRetirada(String email, int id, float cantidad) {
        this.email = email;
        this.id = id;
        this.cantidad = cantidad;
    }

    @Override
    public void execute() throws PasswordIncorrecta, UsuarioNoExiste, BancoYaExiste, CuentaBancariaYaExiste, BancoNoExiste, TitularNoExiste, CuentaBancariaNoExiste, PersonaYaExiste, TitularYaExiste, PersonaNoExiste, BalanceInsuficiente, CantidadTransferenciaIncorrecta, CantidadOperacionIncorrecta {
        //Pre: el titular existe
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        Titular titular = ctrlTitular.get(email, id);

        //Comprobacion de excepciones
        if (cantidad <= 0 || cantidad > 1000) throw new CantidadOperacionIncorrecta();
        if (cantidad > titular.getBalance()) throw new BalanceInsuficiente();

        //Crear retirada y añadirla a datos
        FechaYHora fechaYHora = new FechaYHora();
        Retirada retirada = new Retirada(titular, fechaYHora, cantidad);
        titular.addOperacion(retirada);
        fechaYHora.addOperacion(retirada);

        CtrlFechaYHora ctrlFechaYHora = FactoriaCtrl.getInstance().getCtrlFechaYHora();
        ctrlFechaYHora.add(fechaYHora);
        CtrlRetirada ctrlRetirada = FactoriaCtrl.getInstance().getCtrlRetirada();
        ctrlRetirada.add(retirada);
    }
}
