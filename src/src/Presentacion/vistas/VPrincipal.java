package Presentacion.vistas;

import Presentacion.controlador.CtrlPresentacion;
import dominio.excepciones.PasswordIncorrecta;
import dominio.excepciones.UsuarioNoExiste;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VPrincipal {
    private CtrlPresentacion ctrlPresentacion;
    private JFrame frameVista = new JFrame("Vista Principal");
    private JTextField usuarioTextField;
    private JPanel panelContenidos;
    private JPasswordField passwordField;
    private JButton RegistrarseButton;
    private JButton AltaCuentaButton;
    private JButton IniciarSesionButton;
    private JPanel panelBotones;
    private JLabel UsuarioLabel;
    private JLabel passwordLabel;
    private JLabel spaceLabel;
    private JLabel spaceLabel2;
    private JLabel spaceLabel3;
    private JLabel spaceLabel4;
    private JLabel spaceLabel5;

    public VPrincipal(CtrlPresentacion ctrlPresentacion) {
        this.ctrlPresentacion = ctrlPresentacion;
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

        RegistrarseButton.setActionCommand("registrarseButton");
        RegistrarseButton.addActionListener(ctrlPresentacion.getEventosVPrincipal());
        AltaCuentaButton.setActionCommand("altaCuentaButton");
        AltaCuentaButton.addActionListener(ctrlPresentacion.getEventosVPrincipal());
        IniciarSesionButton.setActionCommand("iniciarSesionButton");
        IniciarSesionButton.addActionListener(ctrlPresentacion.getEventosVPrincipal());


    }

    public void hacerVisible(boolean b) {
        this.frameVista.setVisible(b);
    }

    public void iniciarSesion() {
        String nombreUsuario = usuarioTextField.getText();
        String password = Arrays.toString(passwordField.getPassword());
        try {
            this.ctrlPresentacion.iniciarSesion(nombreUsuario, password);
        } catch(PasswordIncorrecta | UsuarioNoExiste e) {
            usuarioTextField.setText("");
            passwordField.setText("");
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
