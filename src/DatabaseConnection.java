import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/dataku"; //nama url database
            String user = "root"; //nama user database
            String pass = ""; //nama password database
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Berhasil Koneksi");
        } catch (Exception e) {
            System.err.println("connection gagal " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        connection = getConnection();
    }
}
