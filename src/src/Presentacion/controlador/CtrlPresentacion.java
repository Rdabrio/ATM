package Presentacion.controlador;

import Presentacion.eventos.EventosVPrincipal;
import Presentacion.eventos.IEventosVPrincipal;
import Presentacion.vistas.VPrincipal;
import dominio.controladores.*;

public class CtrlPresentacion {


    private VPrincipal vPrincipal;

    public CtrlPresentacion() {
        this.vPrincipal = new VPrincipal(this);
    }

    public EventosVPrincipal getEventosVPrincipal() {
        return new EventosVPrincipal(vPrincipal);
    }

}
