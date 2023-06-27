package dominio.controladores;

import dominio.clases.Titular;
import dominio.excepciones.PasswordIncorrecta;
import dominio.excepciones.UsuarioNoExiste;
import persistencia.ctrldata.CtrlTitular;
import persistencia.ctrldata.FactoriaCtrl;

public class TrIniciarSesion extends Transaccion {

    private String nombreUsuario;
    private String password;
    private String result;

    public TrIniciarSesion(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.result = "";
    }

    public String getResult() {
        return this.result;
    }

    @Override
    public void execute() throws PasswordIncorrecta, UsuarioNoExiste {

        //Obtener el Titular identificado por su nombre de usuario
        CtrlTitular ctrlTitular = FactoriaCtrl.getInstance().getCtrlTitular();
        if (!ctrlTitular.existsNombreUsuario(nombreUsuario)) throw new UsuarioNoExiste();
        Titular t = ctrlTitular.getByNombreUsuario(nombreUsuario);

        //Comprobacion si la  contraseña es incorrecta
        if (!password.equals(t.getPassword())) throw new PasswordIncorrecta();

        //El resultado es la informacion basica de la cuenta
        result += t.getBalance() + "\n";
        result += t.getIBAN();
    }

}
