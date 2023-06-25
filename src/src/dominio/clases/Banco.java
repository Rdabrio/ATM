package dominio.clases;

import java.util.HashMap;

public class Banco {
    private String nombre;
    private HashMap<Integer, CuentaBancaria> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new HashMap<>();
    }

    public Banco(String nombre, HashMap<Integer, CuentaBancaria> cuentas) {
        this.nombre = nombre;
        this.cuentas = cuentas;
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

    public void removeCuenta(int id) {
        cuentas.remove(id);
    }

    public HashMap<Integer, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(HashMap<Integer, CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
}
