package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    static Connection conn = null;
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/drinkweb";
    private final String USER = "root";
    private final String PASS = "123456";

    private DBConnection() {
        try {
            Class.forName(jdbc);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi driver");
        } catch (SQLException e) {
            System.out.println("Loi ket noi");
        }
    }

    public Connection getDBConnection() {
        return conn;
    }

    public static synchronized DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getDBConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
}
