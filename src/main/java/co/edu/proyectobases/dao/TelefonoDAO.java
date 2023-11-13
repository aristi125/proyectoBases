package co.edu.proyectobases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TelefonoDAO {


    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            synchronized (Connection.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADMIN_GYM", "root123");
                }
            }
        }
        return connection;
    }


}
