package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    static Connection conn = null;
    private final String jdbc = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://ec2-34-207-12-160.compute-1.amazonaws.com/dc9vdfiiv3hpim";
    private final String USER = "vfzghykihojckn";
    private final String PASS = "b9b3fe576dd357b3e681b44508f2f531ec6ce9b2e09d32a45a6743e9416578ff";

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
