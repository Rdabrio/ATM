package persistencia.rowdata;

import java.sql.*;
import java.util.ArrayList;

public class FinderIngreso {
    private static FinderIngreso instance;
    private String url;
    private String user;
    private String passwd;

    private FinderIngreso() {
        this.url = "jdbc:mysql://localhost:3306/atmdb";
        this.user= "root";
        this.passwd= "";
    }

    public static FinderIngreso getInstance() {
        if (instance == null) instance = new FinderIngreso();
        return instance;
    }

    public GatewayIngreso find(String nombreUsuario, Date fechayhora) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso WHERE nombreUsuario='"+nombreUsuario+"' and fechayhora='"+fechayhora.toString()+"'");
        rs.first();
        String nombreU = rs.getString("nombreUsuario");
        Date fecha = rs.getDate("fechayhora");
        if (nombreU == null || fecha == null) {
            System.out.println("No hay ningun ingreso de ese usuario en la fecha");
            return null;
        }
        String concepto = rs.getString("concepto");
        float balance = rs.getFloat("balance");
        return new GatewayIngreso(nombreU, fecha, concepto, balance);
    }

    public ArrayList<GatewayIngreso> findAll() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso");

        ArrayList<GatewayIngreso> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            String concepto = rs.getString("concepto");
            float balance = rs.getFloat("balance");
            lcb.add(new GatewayIngreso(nombreU, fecha, concepto, balance));
            rs.next();
        }
        return lcb;
    }

    public ArrayList<GatewayIngreso> findByBalance(float balance) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, passwd);
        Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery("SELECT * FROM ingreso WHERE balance = '"+balance+"'");

        ArrayList<GatewayIngreso> lcb = new ArrayList<>();
        if(!rs.first()) return lcb;
        while (!rs.isAfterLast()) {
            String nombreU = rs.getString("nombreUsuario");
            Date fecha = rs.getDate("fechayhora");
            String concepto = rs.getString("concepto");
            lcb.add(new GatewayIngreso(nombreU, fecha, concepto, balance));
            rs.next();
        }
        return lcb;
    }
}
