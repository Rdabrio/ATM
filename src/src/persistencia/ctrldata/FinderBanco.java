package persistencia.ctrldata;

import java.sql.*;
import java.util.ArrayList;

public class FinderBanco {
    private static FinderBanco instance;
    private String url;
    private String user;
    private String passwd;

    private FinderBanco() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderBanco getInstance() {
        if (instance == null) instance = new FinderBanco();
        return instance;
    }

    public GatewayBanco find(String nombre) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM banco WHERE nombre='"+nombre+"'");
        rs.first();
        String nombreBanco = rs.getString(1);
        if (nombreBanco == null) System.out.println("No hay ningun banco con ese nombre");
        return new GatewayBanco(nombre);
    }

    public ArrayList<GatewayBanco> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM banco");

        ArrayList<GatewayBanco> lgb = new ArrayList<>();
        if(!rs.first()) return lgb;
        while (!rs.isAfterLast()) {
            String nombreBanco = rs.getString(1);
            lgb.add(new GatewayBanco(nombreBanco));
            rs.next();
        }
        return lgb;
    }
}
