package persistencia.ctrldata;

import java.sql.*;

public class GatewayCuentaBancaria {
    private int id;
    private String emailPersona;
    private String nombreBanco;
    private String url;
    private String user;
    private String passwd;

    public GatewayCuentaBancaria(int id, String emailPersona, String nombreBanco) {
        this.id = id;
        this.emailPersona = emailPersona;
        this.nombreBanco = nombreBanco;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public int getId() {
        return id;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria");
        rs.moveToInsertRow();
        rs.updateInt("id", this.id);
        rs.updateString("emailPersona", this.emailPersona);
        rs.updateString("nombreBanco", this.nombreBanco);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria WHERE id='"+this.id+"'");
        rs.first();
        rs.updateString("emailPersona", this.emailPersona);
        rs.updateString("nombreBanco", this.nombreBanco);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria WHERE id='"+this.id+"'");
        rs.first();
        rs.deleteRow();
    }
}
