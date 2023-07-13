package Presentacion.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface IEventosVPrincipal extends ActionListener, WindowListener {

    public void actionPerformed(ActionEvent e);
}
