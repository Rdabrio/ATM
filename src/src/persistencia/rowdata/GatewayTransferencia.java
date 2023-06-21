package persistencia.rowdata;

import java.sql.*;

public class GatewayTransferencia {
    private String nombreEmisor;
    private String nombreReceptor;
    private Date fechaYHora;
    private float cantidad;
    private String concepto;
    private String url;
    private String user;
    private String passwd;

    public GatewayTransferencia(String nombreEmisor, String nombreReceptor, Date fechaYHora, float cantidad, String concepto) {
        this.nombreEmisor = nombreEmisor;
        this.nombreReceptor = nombreReceptor;
        this.fechaYHora = fechaYHora;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia");
        rs.moveToInsertRow();
        rs.updateString("nombreEmisor", this.nombreEmisor);
        rs.updateString("nombreReceptor", this.nombreReceptor);
        rs.updateDate("fechaYHora", this.fechaYHora);
        rs.updateFloat("cantidad", this.cantidad);
        if (!this.concepto.equals("")) rs.updateString("concepto", this.concepto);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE nombreEmisor='"+this.nombreEmisor+ "' and nombreReceptor='"+this.nombreReceptor+"' and fechaYHora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.updateFloat("cantidad", this.cantidad);
        if (!this.concepto.equals("")) rs.updateString("concepto", this.concepto);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE nombreEmisor='"+this.nombreEmisor+ "' and nombreReceptor='"+this.nombreReceptor+"' and fechaYHora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.deleteRow();
    }
}
