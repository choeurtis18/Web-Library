package aguiardaniel.fr.persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URI = "jdbc:mysql://localhost:3306/web-library?serverTimezone=GMT";
    private static final String user = "danny";
    private static final String pwd = "$Azertyuiop25$";

    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance(){
        if(connection == null)
            connection = getConnection();
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
