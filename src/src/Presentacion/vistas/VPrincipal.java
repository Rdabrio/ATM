package Presentacion.vistas;

import Presentacion.controlador.CtrlPresentacion;

import javax.swing.*;
import java.awt.*;

public class VPrincipal {
    private CtrlPresentacion ctrlPresentacion;
    private JFrame frameVista;
    private JPanel panelContenidos;

    public VPrincipal(CtrlPresentacion ctrlPresentacion) {
        this.ctrlPresentacion = ctrlPresentacion;
        frameVista = new JFrame("Vista Principal");
        panelContenidos = new JPanel();
    }

    public void inicializa() {
        frameVista.setContentPane(panelContenidos);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() / 1.5, height = screenSize.getHeight() / 1.5;
        frameVista.setBounds((int) (width / 3.7), (int) (height / 3.7), (int) width, (int) height);
        frameVista.setResizable(false);

        inicializarComponentes();
    }

    public void inicializarComponentes() {
        frameVista.addWindowListener(ctrlPresentacion.getEventosVPrincipal());
        frameVista.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
