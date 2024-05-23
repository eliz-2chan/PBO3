import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    public static Connection getConnection() {
        try {
//            Register Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            Database URL
            String url = "jdbc:mysql://localhost:3306/dataku";
//            Database Username
            String user = "root";
//            Database Password
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Success");
        } catch (Exception e) {
            System.err.println("Connection Failed " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        connection = getConnection();
    }
}
