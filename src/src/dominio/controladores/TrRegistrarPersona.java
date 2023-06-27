package dominio.controladores;

import dominio.clases.Persona;
import dominio.excepciones.*;
import persistencia.ctrldata.CtrlPersona;
import persistencia.ctrldata.FactoriaCtrl;

public class TrRegistrarPersona extends Transaccion {

    private String email;
    private String nombre;

    public TrRegistrarPersona(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    @Override
    public void execute() throws PersonaYaExiste {

        //Comprobar que no exista la persona
        CtrlPersona ctrlPersona = FactoriaCtrl.getInstance().getCtrlPersona();
        if (ctrlPersona.exists(email)) throw new PersonaYaExiste();

        //Crear persona y añadirla al conjunto de datos de personas
        Persona p = new Persona(email, nombre);
        ctrlPersona.add(p);
    }
}
