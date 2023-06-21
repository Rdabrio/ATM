package persistencia.rowdata;

import java.sql.*;

public class GatewayPersona {
    private String email;
    private String nombre;
    private String url;
    private String user;
    private String passwd;

    public GatewayPersona(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona");
        rs.moveToInsertRow();
        rs.updateString("email", this.email);
        rs.updateString("nombre", this.nombre);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona WHERE email='"+this.email+"'");
        rs.first();
        rs.updateString("email", this.email);
        rs.updateString("nombre", this.nombre);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona WHERE email='"+this.email+"'");
        rs.first();
        rs.deleteRow();
    }
}
