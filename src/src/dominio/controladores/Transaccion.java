package dominio.controladores;

import dominio.excepciones.BancoYaExiste;
import dominio.excepciones.PasswordIncorrecta;
import dominio.excepciones.UsuarioNoExiste;

public abstract class Transaccion {
    public abstract void execute() throws PasswordIncorrecta, UsuarioNoExiste, BancoYaExiste;
}
