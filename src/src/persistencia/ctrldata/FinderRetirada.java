package persistencia.ctrldata;

import java.sql.*;
import java.util.ArrayList;

public class FinderRetirada {
    private static FinderRetirada instance;
    private String url;
    private String user;
    private String passwd;

    private FinderRetirada() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderRetirada getInstance() {
        if (instance == null) instance = new FinderRetirada();
        return instance;
    }

    public GatewayRetirada find(String nombreUsuario, Date fechayhora) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada WHERE nombreUsuario='"+nombreUsuario+"' and fechayhora='"+fechayhora.toString()+"'");
        rs.first();
        String nombreU = rs.getString("nombreUsuario");
        Date fecha = rs.getDate("fechayhora");
        if (nombreU == null || fecha == null) {
            System.out.println("No hay ningun ingreso de ese usuario en la fecha");
            return null;
        }
        float cantidad = rs.getFloat("cantidad");
        return new GatewayRetirada(nombreU, fecha, cantidad);
    }

    public ArrayList<GatewayRetirada> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada");

        ArrayList<GatewayRetirada> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            float cantidad = rs.getFloat("cantidad");
            lcb.add(new GatewayRetirada(nombreU, fecha, cantidad));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayRetirada> findByCantidad(float cantidad) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM retirada WHERE cantidad = '"+cantidad+"'");

        ArrayList<GatewayRetirada> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            lcb.add(new GatewayRetirada(nombreU, fecha, cantidad));
            rs.next();
        }
        return lcb;
    }
}
