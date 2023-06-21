package persistencia.rowdata;

import java.sql.*;
import java.util.ArrayList;

public class FinderPersona {
    private static FinderPersona instance;
    private String url;
    private String user;
    private String passwd;

    private FinderPersona() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderPersona getInstance() {
        if (instance == null) instance = new FinderPersona();
        return instance;
    }

    public GatewayPersona find(String email) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona WHERE email='"+email+"'");
        rs.first();
        String emailU = rs.getString("email");
        if (emailU == null) {
            System.out.println("No hay ningun ingreso de ese usuario en la fecha");
            return null;
        }
        String nombre = rs.getString("nombre");
        return new GatewayPersona(emailU, nombre);
    }

    public ArrayList<GatewayPersona> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona");

        ArrayList<GatewayPersona> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String email = rs.getString("email");
            String nombre = rs.getString("nombre");
            lcb.add(new GatewayPersona(email, nombre));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayPersona> findByNombre(String nombre) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM persona WHERE nombre = '"+nombre+"'");

        ArrayList<GatewayPersona> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String email = rs.getString("email");
            lcb.add(new GatewayPersona(email, nombre));
            rs.next();
        }
        return lcb;
    }
}
