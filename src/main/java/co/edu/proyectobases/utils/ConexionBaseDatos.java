package co.edu.proyectobases.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    // FUNCIONA COMO UN SINGLETON
    private static String url = "jdbc:oracle:thin:@localhost:1521:SID"; // Cambia "SID" por el nombre de servicio o SID de tu base de datos Oracle
    private static String username = "ADMIN_GYM"; // Cambia por tu nombre de usuario Oracle
    private static String password = "root123"; // Cambia por tu contraseña Oracle
    private static Connection connection;

    // METODO PARA ESTABLECER LA CONEXION
    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}

