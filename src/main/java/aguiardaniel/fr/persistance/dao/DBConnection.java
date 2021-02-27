package aguiardaniel.fr.persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URI = "jdbc:mysql://localhost:3306/web-library?serverTimezone=GMT";
    private static final String user = "root";
    private static final String pwd = "root";
    private static final Connection connection;

    static {
        connection = getConnection();
    }

    private DBConnection(){}

    public static Connection getInstance(){
        return connection;
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URI, user, pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
