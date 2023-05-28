package persistencia.ctrldata;

import java.sql.*;

public class GatewayTitular {
    private String emailPersona;
    private int idCuenta;
    private String nombreUsuario;
    private String contrasena;
    private float balance;
    private int iban;
    private String url;
    private String user;
    private String passwd;

    public GatewayTitular(String emailPersona, int idCuenta, String nombreUsuario, String contrasena, float balance, int iban) {
        this.emailPersona = emailPersona;
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.balance = balance;
        this.iban = iban;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public float getBalance() {
        return balance;
    }

    public int getIban() {
        return iban;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM titular");
        rs.moveToInsertRow();
        rs.updateString("nombreUsuario", this.nombreUsuario);
        rs.updateString("contrasena", this.contrasena);
        rs.updateFloat("balance", this.balance);
        rs.updateInt("iban", this.iban);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM titular WHERE emailPersona='"+this.emailPersona+"' and idCuenta='"+this.idCuenta+"'");
        rs.first();
        rs.updateString("nombreUsuario", this.nombreUsuario);
        rs.updateString("contrasena", this.contrasena);
        rs.updateFloat("balance", this.balance);
        rs.updateInt("iban", this.iban);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM titular WHERE emailPersona='"+this.emailPersona+"' and idCuenta='"+this.idCuenta+"'");
        rs.first();
        rs.deleteRow();
    }
}
