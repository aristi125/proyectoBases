package co.edu.proyectobases.dao;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PersonaDAO {


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
/**
    public void agregar(Integer cod,String primernombre,String segundonombre,String primerapellido,String segundoapellido) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int state = -1;

        try {


            // Se utiliza DriverManager para obtener la conexión
            connection = getConnection();

            if (connection != null) {
                String sql = "SELECT * FROM administrador WHERE usuario = ? AND contrasena = ?";

                pst = connection.prepareStatement(sql);
                pst.setString(1, usuario);
                pst.setString(2, contrasena);

                rs = pst.executeQuery();

                if (rs.next()) {
                    state = 1;
                } else {
                    state = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos por la siguiente razón:\n" + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
        return state;
    }
 */
}
