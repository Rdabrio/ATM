package persistencia.ctrldata;

import java.sql.*;

public class GatewayBanco {
    private String nombre;
    private String url;
    private String user;
    private String passwd;

    public GatewayBanco(String nombre) {
        this.nombre = nombre;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM banco");
        rs.moveToInsertRow();
        rs.updateString("nombre", this.nombre);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM banco WHERE nombre='"+nombre+"'");
        rs.first();
        rs.updateString("nombre", this.nombre);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM banco WHERE nombre='"+nombre+"'");
        rs.first();
        rs.deleteRow();
    }
}
