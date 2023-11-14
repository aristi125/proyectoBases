package co.edu.proyectobases.dao;

import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelefonoDAO {


    private Connection connection;

    public TelefonoDAO() {
        connection = ConexionBaseDatos.getInstance().getConnection();
    }

    public void agregarTelefono(Integer codTelefono, Integer numeroTelefono, Integer persona_cod) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("INSERT INTO telefono (codtelefono, numerotelefono, persona_cod) VALUES (?, ?, ?)");

        pst.setInt(1, codTelefono);
        pst.setInt(2, numeroTelefono);
        pst.setInt(3, persona_cod);

        pst.executeUpdate();
    }

    public boolean eliminarPersona(int codTelefono) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = ConexionBaseDatos.getInstance().getConnection();
            String sql = "DELETE FROM telefono WHERE codtelefono = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, codTelefono);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar telefono: " + e.getMessage());
        }
        return false;
    }
}
