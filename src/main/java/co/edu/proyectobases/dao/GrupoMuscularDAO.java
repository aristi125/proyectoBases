package co.edu.proyectobases.dao;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.utils.ConexionBaseDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class GrupoMuscularDAO {

    private Connection connection;

    public GrupoMuscularDAO() {
        connection = ConexionBaseDatos.getInstance().getConnection();
    }

    public void agregarGrupoMuscular(Integer codGrupoMuscular, String nombre, Integer codMaquina, Integer codRutina) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("INSERT INTO grupomuscular (codgrupomuscular, nombre, maquina_codmaquina, rutina_codrutina) VALUES (?, ?, ?, ?)");


        pst.setInt(1, codGrupoMuscular);
        pst.setString(2, nombre);
        pst.setString(3, codMaquina.toString());
        pst.setString(4, codRutina.toString());

        pst.executeUpdate();
    }

    public boolean eliminarPersona(int cod) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = ConexionBaseDatos.getInstance().getConnection();
            String sql = "DELETE FROM grupomuscular WHERE codgrupomuscular = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cod);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar grupoMuscular: " + e.getMessage());
        }
        return false;
    }


}
