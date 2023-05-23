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
        String s="create table cuentaBancaria(" +
                "ID Integer," +
                "emailPersona varchar(20) unique not null," +
                "primary key(ID)," +
                "foreign key(emailPersona) references persona(email));";
        state.executeUpdate(s);
    }

}
