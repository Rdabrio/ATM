package dominio;

import java.util.HashMap;

public class Banco {
    private String nombre;
    private HashMap<Integer, CuentaBancaria> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCuenta(CuentaBancaria c) {
        cuentas.put(c.getId(), c);
    }

    public void removeCuenta(String id) {
        cuentas.remove(id);
    }

    public HashMap<Integer, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(HashMap<Integer, CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
}
