package co.edu.proyectobases.dao;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdministradorDAO {

    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user;
    String password;

    public AdministradorDAO() {

    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdministradorDAO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public int login(String usuario, String contrasena) {

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int state = -1;

        try {


            // Se utiliza DriverManager para obtener la conexión
            connection = DriverManager.getConnection(url, user, password);

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
}