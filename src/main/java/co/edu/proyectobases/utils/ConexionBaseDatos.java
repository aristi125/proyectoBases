package co.edu.proyectobases.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// Class.forName("oracle.jdbc.driver.OracleDriver");

public class ConexionBaseDatos {
    // URL, usuario y contraseña de conexión a la base de datos Oracle
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "ADMIN_GYM";
    private static String password = "root123";
    //private static Connection connection;

    private static ConexionBaseDatos instancia;
    private Connection connection;

    private ConexionBaseDatos() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConexionBaseDatos getInstance() {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }

}

