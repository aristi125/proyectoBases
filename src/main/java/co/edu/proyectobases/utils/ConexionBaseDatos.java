package co.edu.proyectobases.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class.forName("oracle.jdbc.driver.OracleDriver");

public class ConexionBaseDatos {
    // Carga el controlador JDBC de Oracle


    // URL, usuario y contraseña de conexión a la base de datos Oracle
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "ADMIN_GYM";
    private static String password = "root123";
    private static Connection connection;

    // Método para establecer la conexión
    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

}

