package aguiardaniel.fr.persistance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URI = "jdbc:mysql://d3y0lbg7abxmbuoi.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/bshr1lv7614vsnex";
    private static final String user = "meanxpezg7634fio";
    private static final String pwd = "hqfwp60l8f96in4o";
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
