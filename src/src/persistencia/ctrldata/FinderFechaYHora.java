package persistencia.ctrldata;

import java.sql.*;
import java.util.ArrayList;

public class FinderFechaYHora {
    private static FinderFechaYHora instance;
    private String url;
    private String user;
    private String passwd;

    private FinderFechaYHora() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderFechaYHora getInstance() {
        if (instance == null) instance = new FinderFechaYHora();
        return instance;
    }

    public GatewayFechaYHora find(Date fechaYHora) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM fechayhora WHERE fechaYHora='"+fechaYHora.toString()+"'");
        rs.first();
        Date fechahora = rs.getDate("fechaYHora");
        return new GatewayFechaYHora(fechaYHora);
    }

    public ArrayList<GatewayFechaYHora> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM fechayhora");

        ArrayList<GatewayFechaYHora> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            Date fechahora = rs.getDate("fechaYHora");
            lcb.add(new GatewayFechaYHora(fechahora));
            rs.next();
        }
        return lcb;
    }

}
