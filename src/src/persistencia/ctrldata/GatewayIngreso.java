package persistencia.ctrldata;

import java.sql.*;

import static java.sql.JDBCType.NULL;

public class GatewayIngreso {
    private String nombreUsuario;
    private Date fechaYHora;
    private String concepto;
    private float balance;
    private String url;
    private String user;
    private String passwd;

    public GatewayIngreso(String nombreUsuario, Date fechaYHora, String concepto, float balance) {
        this.nombreUsuario = nombreUsuario;
        this.fechaYHora = fechaYHora;
        this.concepto = concepto;
        this.balance = balance;
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

    public String getConcepto() {
        return concepto;
    }

    public float getBalance() {
        return balance;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void insert() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso");
        rs.moveToInsertRow();
        rs.updateString("nombreUsuario", this.nombreUsuario);
        rs.updateDate("fechayhora", this.fechaYHora);
        if (!this.concepto.equals("")) rs.updateString("concepto", this.concepto);
        rs.updateFloat("balance", this.balance);
        rs.insertRow();
    }

    public void update() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso WHERE nombreUsuario='"+this.nombreUsuario+"' and fechayhora='"+this.fechaYHora.toString()+"'");
        rs.first();
        if (!concepto.equals("")) rs.updateString("concepto", this.concepto);
        rs.updateFloat("balance", this.balance);
        rs.updateRow();
    }

    public void remove() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso WHERE nombreUsuario='"+this.nombreUsuario+"' and fechayhora='"+this.fechaYHora.toString()+"'");
        rs.first();
        rs.deleteRow();
    }
}
