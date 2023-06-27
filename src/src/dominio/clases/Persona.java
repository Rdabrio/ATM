package dominio.clases;

import java.util.HashMap;

public class Persona {
    private String email;
    private String nombre;
    private HashMap<String, Titular> titulares;

    public Persona(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
        titulares = new HashMap<>();
    }

    public Persona(String email, String nombre, HashMap<String, Titular> titulares) {
        this.email = email;
        this.nombre = nombre;
        this.titulares = titulares;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(HashMap<String, Titular> titulares) {
        this.titulares = titulares;
    }

    public void addTitular(String nombreusuario, Titular titular) {
        titulares.put(nombreusuario, titular);
    }

    public void removeTitular(String nombreusuario) {
        titulares.remove(nombreusuario);
    }
}
