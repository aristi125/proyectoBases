package co.edu.proyectobases.dao;

import co.edu.proyectobases.model.Agenda;
import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.utils.ConexionBaseDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AgendaDAO {

    private Connection connection;

    public AgendaDAO() {
        connection = ConexionBaseDatos.getInstance().getConnection();
    }


    public void agregarAgenda(Integer codAgenda, String horaInicio, String horaFinalizacion) throws SQLException {

        PreparedStatement pst = connection.prepareStatement("INSERT INTO agenda (CODAGENDA, HORAINICIO, HORAFINALIZACION) VALUES (?,TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))");


        pst.setInt(1, codAgenda);
        pst.setString(2, horaInicio);
        pst.setString(3, horaFinalizacion);

        pst.executeUpdate();
    }

    public boolean eliminarAgenda(int codAgenda) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = ConexionBaseDatos.getInstance().getConnection();
            String sql = "DELETE FROM agenda WHERE cod = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, codAgenda);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar agenda: " + e.getMessage());
        }
        return false;
    }


}
