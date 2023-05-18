package dominio.clases;

import java.util.ArrayList;

public class Titular {

    private String nombreUsuario;
    private String password;
    private float balance;
    private int IBAN;
    private Persona propietario;
    private CuentaBancaria cuenta;
    private ArrayList<Operacion> operaciones;
    private ArrayList<Transferencia> transferenciasEmitidas;
    private ArrayList<Transferencia> transferenciasRecibidas;

    public Titular(String nombreUsuario, String password, float balance, int IBAN, Persona propietario, CuentaBancaria cuenta) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.balance = balance;
        this.IBAN = IBAN;
        this.propietario = propietario;
        this.cuenta = cuenta;
        operaciones = new ArrayList<>();
        transferenciasEmitidas = new ArrayList<>();
        transferenciasRecibidas = new ArrayList<>();
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public float getBalance() {
        return balance;
    }

    public int getIBAN() {
        return IBAN;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public ArrayList<Transferencia> getTransferenciasEmitidas() {
        return transferenciasEmitidas;
    }

    public ArrayList<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public void setIBAN(int IBAN) {
        this.IBAN = IBAN;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public void setOperaciones(ArrayList<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public void setTransferenciasEmitidas(ArrayList<Transferencia> transferenciasEmitidas) {
        this.transferenciasEmitidas = transferenciasEmitidas;
    }

    public void setTransferenciasRecibidas(ArrayList<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }

    public void addOperacion(Operacion operacion) {
        operaciones.add(operacion);
    }

    public void removeOperacion(Operacion operacion) {
        operaciones.remove(operacion);
    }

    public void addTransferenciaEmitida(Transferencia transferencia) {
        transferenciasEmitidas.add(transferencia);
    }

    public void removeTransferenciaEmitida(Transferencia transferencia) {
        transferenciasEmitidas.remove(transferencia);
    }

    public void addTransferenciaRecibida(Transferencia transferencia) {
        transferenciasRecibidas.add(transferencia);
    }

    public void removeTransferenciaRecibida(Transferencia transferencia) {
        transferenciasRecibidas.remove(transferencia);
    }
}
