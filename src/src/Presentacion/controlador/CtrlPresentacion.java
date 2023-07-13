package Presentacion.controlador;

import Presentacion.eventos.EventosVPrincipal;
import Presentacion.eventos.IEventosVPrincipal;
import Presentacion.vistas.VPrincipal;
import dominio.controladores.*;
import dominio.excepciones.PasswordIncorrecta;
import dominio.excepciones.UsuarioNoExiste;

import javax.swing.*;

public class CtrlPresentacion {


    private VPrincipal vPrincipal;

    public CtrlPresentacion() {
        this.vPrincipal = new VPrincipal(this);
    }

    public void inicializa() {
        vPrincipal.inicializa();
        vPrincipal.hacerVisible(true);
    }

    public EventosVPrincipal getEventosVPrincipal() {
        return new EventosVPrincipal(vPrincipal);
    }

    public void iniciarSesion(String nombreUsuario, String password) throws PasswordIncorrecta, UsuarioNoExiste {
        TrIniciarSesion trIniciarSesion = new TrIniciarSesion(nombreUsuario, password);
        trIniciarSesion.execute();
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater (
                () -> {
                    CtrlPresentacion presentacion = new CtrlPresentacion();
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e.toString());
                    }
                    try {
                        presentacion.inicializa();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,e.toString());
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                }
        );

    }

}
