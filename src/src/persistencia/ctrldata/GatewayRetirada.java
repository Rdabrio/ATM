package persistencia.ctrldata;

import java.sql.*;

public class GatewayRetirada {
    private String nombreUsuario;
    private Date fechaYHora;
    private float cantidad;
    private String url;
    private String user;
    private String passwd;

    public GatewayRetirada(String nombreUsuario, Date fechaYHora, float balance) {
        this.nombreUsuario = nombreUsuario;
        this.fechaYHora = fechaYHora;
        this.cantidad = balance;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada");
        rs.moveToInsertRow();
        rs.updateString("nombreUsuario", this.nombreUsuario);
        rs.updateDate("fechayhora", this.fechaYHora);
        rs.updateFloat("cantidad", this.cantidad);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada WHERE nombreUsuario='"+this.nombreUsuario+"' and fechayhora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.updateFloat("cantidad", this.cantidad);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada WHERE nombreUsuario='"+this.nombreUsuario+"' and fechayhora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.deleteRow();
    }
}
