package Presentacion.eventos;

import Presentacion.vistas.VPrincipal;

import java.awt.event.ActionEvent;

public class EventosVPrincipal implements IEventosVPrincipal {

    private VPrincipal vPrincipal;

    public EventosVPrincipal(VPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            default: break;
        }
    }
}
