package persistencia.rowdata;

import java.sql.*;

public class GatewayFechaYHora {
    private Date fechaYHora;
    private String url;
    private String user;
    private String passwd;

    public GatewayFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM fechayhora");
        rs.moveToInsertRow();
        rs.updateDate("fechaYHora", this.fechaYHora);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM fechayhora WHERE fechaYHora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.updateDate("fechaYHora", this.fechaYHora);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM fechayhora WHERE fechaYHora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.deleteRow();
    }
}
