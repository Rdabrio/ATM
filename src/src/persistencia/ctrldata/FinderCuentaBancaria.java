package persistencia.ctrldata;

import java.sql.*;
import java.util.ArrayList;

public class FinderCuentaBancaria {
    private static FinderCuentaBancaria instance;
    private String url;
    private String user;
    private String passwd;

    private FinderCuentaBancaria() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderCuentaBancaria getInstance() {
        if (instance == null) instance = new FinderCuentaBancaria();
        return instance;
    }

    public GatewayCuentaBancaria find(int id) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria WHERE id='"+id+"'");
        rs.first();
        int idCuenta = rs.getInt("id");
        if (idCuenta == 0) {
            System.out.println("No hay ninguna cuentaBancaria con ese id");
            return null;
        }
        String emailPersona = rs.getString("emailPersona");
        String nombreBanco = rs.getString("nombreBanco");
        return new GatewayCuentaBancaria(idCuenta, emailPersona, nombreBanco);
    }

    public ArrayList<GatewayCuentaBancaria> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria");

        ArrayList<GatewayCuentaBancaria> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            int idCuenta = rs.getInt("id");
            String emailPersona = rs.getString("emailPersona");
            String nombreBanco = rs.getString("nombreBanco");
            lcb.add(new GatewayCuentaBancaria(idCuenta, emailPersona, nombreBanco));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayCuentaBancaria> findByEmailPersona(String emailPersona) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria WHERE emailPersona = '"+emailPersona+"'");

        ArrayList<GatewayCuentaBancaria> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            int idCuenta = rs.getInt("id");
            String nombreBanco = rs.getString("nombreBanco");
            lcb.add(new GatewayCuentaBancaria(idCuenta, emailPersona, nombreBanco));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayCuentaBancaria> findByCuentaBanco(String nombreBanco) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM cuentabancaria WHERE nombreBanco = '"+nombreBanco+"'");

        ArrayList<GatewayCuentaBancaria> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            int idCuenta = rs.getInt("id");
            String emailPersona = rs.getString("emailPersona");
            lcb.add(new GatewayCuentaBancaria(idCuenta, emailPersona, nombreBanco));
            rs.next();
        }
        return lcb;
    }

}
