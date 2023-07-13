package Presentacion.eventos;

import Presentacion.vistas.VPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class EventosVPrincipal implements IEventosVPrincipal {

    private VPrincipal vPrincipal;

    public EventosVPrincipal(VPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "registrarseButton":
                System.out.println("registrarseButton");
                break;

            case "altaCuentaButton":
                System.out.println("altaCuentaButton");
                break;

            case "iniciarSesionButton":
                this.vPrincipal.iniciarSesion();
                break;
            default: break;
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
