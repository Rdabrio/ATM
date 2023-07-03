package dominio.controladores;

import dominio.excepciones.*;

public abstract class Transaccion {
    public abstract void execute() throws PasswordIncorrecta, UsuarioNoExiste, BancoYaExiste, CuentaBancariaYaExiste, BancoNoExiste, TitularNoExiste, CuentaBancariaNoExiste, PersonaYaExiste, TitularYaExiste, PersonaNoExiste, BalanceInsuficiente, CantidadTransferenciaIncorrecta, CantidadIngresoIncorrecta;
}
