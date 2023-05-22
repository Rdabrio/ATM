import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 1. Cargue el controlador de acceso a datos
        Class.forName("com.mysql.jdbc.Driver");
        // 2. Conéctese a la "biblioteca" de datos
        String url = "jdbc:mysql://localhost:3306/atmdb";
        String user= "root";
        String passwd= "";
        Connection conn= DriverManager.getConnection(url,user,passwd);
        // 3. Construir comandos SQL
        Statement state=conn.createStatement();
        String s="insert into persona values('ruben.dabrio', 'Rubén Dabrio')";
        state.executeUpdate(s);
    }

}
