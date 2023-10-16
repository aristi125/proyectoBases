package co.edu.proyectobases.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //FUNCIONA COMO UNSINGLETON
     private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
     private static String username = "root";
     private static String password = "michael125";
     private static Connection connection;

     //METODO PARA ESTABLECER LA CONEXION
    public static Connection getInstance() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
