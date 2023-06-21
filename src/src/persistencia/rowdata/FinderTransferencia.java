package persistencia.rowdata;

import java.sql.*;
import java.util.ArrayList;

public class FinderTransferencia {
    private static FinderTransferencia instance;
    private String url;
    private String user;
    private String passwd;

    private FinderTransferencia() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderTransferencia getInstance() {
        if (instance == null) instance = new FinderTransferencia();
        return instance;
    }

    public GatewayTransferencia find(String nombreEmisor, String nombreReceptor, Date fechaYHora) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE nombreEmisor='"+nombreEmisor+ "' and nombreReceptor='"+nombreReceptor+"' and fechaYHora='"+fechaYHora.toString()+"'");
        rs.first();
        String nombreE = rs.getString("nombreEmisor");
        String nombreR = rs.getString("nombreReceptor");
        Date fecha = rs.getDate("fechaYHora");
        if (nombreE == null || nombreR == null || fecha == null) {
            System.out.println("No hay ninguna transferencia");
            return null;
        }
        float cantidad = rs.getFloat("cantidad");
        String concepto = rs.getString("concepto");
        if (concepto == null) concepto = "";
        return new GatewayTransferencia(nombreE, nombreR, fecha, cantidad, concepto);
    }

    public ArrayList<GatewayTransferencia> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia");

        ArrayList<GatewayTransferencia> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreE = rs.getString("nombreEmisor");
            String nombreR = rs.getString("nombreReceptor");
            Date fecha = rs.getDate("fechaYHora");
            float cantidad = rs.getFloat("cantidad");
            String concepto = rs.getString("concepto");
            lcb.add(new GatewayTransferencia(nombreE, nombreR, fecha, cantidad, concepto));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayTransferencia> findByCantidad(float cantidad) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE cantidad = '"+cantidad+"'");

        ArrayList<GatewayTransferencia> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreE = rs.getString("nombreEmisor");
            String nombreR = rs.getString("nombreReceptor");
            Date fecha = rs.getDate("fechaYHora");
            String concepto = rs.getString("concepto");
            lcb.add(new GatewayTransferencia(nombreE, nombreR, fecha, cantidad, concepto));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayTransferencia> findByEmisor(String nombreE) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE nombreEmisor = '"+nombreE+"'");

        ArrayList<GatewayTransferencia> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreR = rs.getString("nombreReceptor");
            Date fecha = rs.getDate("fechaYHora");
            float cantidad = rs.getFloat("cantidad");
            String concepto = rs.getString("concepto");
            lcb.add(new GatewayTransferencia(nombreE, nombreR, fecha, cantidad, concepto));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayTransferencia> findByReceptor(String nombreR) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM transferencia WHERE nombreReceptor = '"+nombreR+"'");

        ArrayList<GatewayTransferencia> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreE = rs.getString("nombreEmisor");
            Date fecha = rs.getDate("fechaYHora");
            float cantidad = rs.getFloat("cantidad");
            String concepto = rs.getString("concepto");
            lcb.add(new GatewayTransferencia(nombreE, nombreR, fecha, cantidad, concepto));
            rs.next();
        }
        return lcb;
    }
}
