import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // 2. Conéctese a la "biblioteca" de datos
        String url = "jdbc:mysql://localhost:3306/atmdb";
        String user= "root";
        String passwd= "";
        Connection con= DriverManager.getConnection(url,user,passwd);
        // 3. Construir comandos SQL
        Statement state=con.createStatement();
        String s="insert into persona values('ruben.dabrio', 'ruben')";
        state.executeUpdate(s);
    }

}
