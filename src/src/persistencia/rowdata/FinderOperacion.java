package persistencia.rowdata;

import java.sql.*;
import java.util.ArrayList;

public class FinderOperacion {
    private static FinderOperacion instance;
    private String url;
    private String user;
    private String passwd;

    private FinderOperacion() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderOperacion getInstance() {
        if (instance == null) instance = new FinderOperacion();
        return instance;
    }

    public GatewayOperacion find(String nombreUsuario, Date fechayhora) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM operacion WHERE nombreUsuario='"+nombreUsuario+"' and fechayhora='"+fechayhora.toString()+"'");
        rs.first();
        String nombreU = rs.getString("nombreUsuario");
        Date fecha = rs.getDate("fechayhora");
        if (nombreU == null || fecha == null) {
            System.out.println("No hay ningun ingreso de ese usuario en la fecha");
            return null;
        }
        String tipo = rs.getString("tipo");
        float cantidad = rs.getFloat("cantidad");
        return new GatewayOperacion(nombreU, fecha, tipo, cantidad);
    }

    public ArrayList<GatewayOperacion> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM operacion");

        ArrayList<GatewayOperacion> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            String tipo = rs.getString("tipo");
            float cantidad = rs.getFloat("cantidad");
            lcb.add(new GatewayOperacion(nombreU, fecha, tipo, cantidad));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayOperacion> findByCantidad(float cantidad) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso WHERE cantidad = '"+cantidad+"'");

        ArrayList<GatewayOperacion> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            String tipo = rs.getString("tipo");
            lcb.add(new GatewayOperacion(nombreU, fecha, tipo, cantidad));
            rs.next();
        }
        return lcb;
    }
}
