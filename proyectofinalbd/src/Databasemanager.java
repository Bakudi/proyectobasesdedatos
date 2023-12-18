import java.sql.*;

public class Databasemanager {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/midb?user=postgres&password=Animelove.25";
        return DriverManager.getConnection(url);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println("Conectado a la base de datos postgresql!");
        conn.close();
    }
}


