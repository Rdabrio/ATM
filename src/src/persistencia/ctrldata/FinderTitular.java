package persistencia.ctrldata;

import java.sql.*;
import java.util.ArrayList;

public class FinderTitular {
    private static FinderTitular instance;
    private String url;
    private String user;
    private String passwd;

    private FinderTitular() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderTitular getInstance() {
        if (instance == null) instance = new FinderTitular();
        return instance;
    }

    public GatewayTitular find(String emailPersona, int idCuenta) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM titular WHERE emailPersona='"+emailPersona+"' and idCuenta='"+idCuenta+"'");
        rs.first();
        String email = rs.getString("emailPersona");
        int id = rs.getInt("idCuenta");
        if (email == null || id == 0) {
            System.out.println("No hay ningun titular");
            return null;
        }
        String nombre = rs.getString("nombreUsuario");
        String contrasena = rs.getString("contrasena");
        float balance = rs.getFloat("balance");
        int iban = rs.getInt("iban");
        return new GatewayTitular(email, id, nombre, contrasena, balance, iban);
    }

    public ArrayList<GatewayTitular> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM titular");

        ArrayList<GatewayTitular> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            int id = rs.getInt("idCuenta");
            String email = rs.getString("emailPersona");
            String nombre = rs.getString("nombreUsuario");
            String contrasena = rs.getString("contrasena");
            float balance = rs.getFloat("balance");
            int iban = rs.getInt("iban");
            lcb.add(new GatewayTitular(email, id, nombre, contrasena, balance, iban));
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
