package dominio.controladores;

import dominio.clases.FechaYHora;
import dominio.clases.Ingreso;
import dominio.clases.Titular;
import dominio.excepciones.*;
import persistencia.ctrldata.*;

public class TrAltaIngreso extends Transaccion {

    private String email;
    private int id;
    private String concepto;
    private float cantidad;

    public TrAltaIngreso(String email, int id, String concepto, float cantidad) {
        this.email = email;
        this.id = id;
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    @Override
    public void execute() throws PasswordIncorrecta, UsuarioNoExiste, BancoYaExiste, CuentaBancariaYaExiste, BancoNoExiste, TitularNoExiste, CuentaBancariaNoExiste, PersonaYaExiste, TitularYaExiste, PersonaNoExiste, BalanceInsuficiente, CantidadTransferenciaIncorrecta, CantidadOperacionIncorrecta {

        //Pre: el titular existe
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        Titular titular = ctrlTitular.get(email, id);

        //Comprobacion de excepciones
        if (cantidad <= 0 || cantidad > 1000) throw new CantidadOperacionIncorrecta();

        //Crear ingreso y añadirlo a datos
        FechaYHora fechaYHora = new FechaYHora();
        Ingreso ingreso = new Ingreso(titular, fechaYHora, cantidad, concepto);
        titular.addOperacion(ingreso);
        fechaYHora.addOperacion(ingreso);

        CtrlFechaYHora ctrlFechaYHora = FactoriaCtrl.getInstance().getCtrlFechaYHora();
        ctrlFechaYHora.add(fechaYHora);
        CtrlIngreso ctrlIngreso = FactoriaCtrl.getInstance().getCtrlIngreso();
        ctrlIngreso.add(ingreso);
        CtrlOperacion ctrlOperacion = FactoriaCtrl.getInstance().getCtrlOperacion();
        ctrlOperacion.add(ingreso);
    }
}
