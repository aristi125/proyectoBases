package co.edu.proyectobases.dao;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO {


    private Connection connection;

    public PersonaDAO() {
        connection = ConexionBaseDatos.getInstance().getConnection();
    }


    public void agregar(Integer cod, String primernombre, String segundonombre, String primerapellido, String segundoapellido, String fecha, String Carrera, String calle, String barrio, String casa) throws SQLException {

             PreparedStatement pst = connection.prepareStatement("INSERT INTO persona (cod, primernombre, segundonombre, primerapellido, segundoapellido, fechanacimiento, carrera, calle, barrio, casa) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)");


            pst.setInt(1, cod);
            pst.setString(2, primernombre);
            pst.setString(3, segundonombre);
            pst.setString(4, primerapellido);
            pst.setString(5, segundoapellido);
            pst.setString(6, fecha);
            pst.setString(7, Carrera);
            pst.setString(8, calle);
            pst.setString(9, barrio);
            pst.setString(10, casa);

            pst.executeUpdate();
            //connection.commit();
        //} catch (SQLException e) {
            // Lanzar la excepción para que pueda ser manejada en el nivel superior
          //  throw new SQLException("Error al agregar persona", e);
        }
        // connection.close(); // No es necesario cerrar la conexión explícitamente aquí





    public ArrayList<Persona> consultarTodos() {
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            connection = ConexionBaseDatos.getInstance().getConnection();

            if (connection != null) {
                String sql = "SELECT * FROM persona";
                pst = connection.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Persona persona = new Persona();
                    persona.setCod(rs.getInt("cod"));
                    persona.setPrimerNombre(rs.getString("primernombre"));
                    persona.setSegundoNombre(rs.getString("segundonombre"));
                    persona.setPrimerApellido(rs.getString("primerapellido"));
                    persona.setSegundoApellido(rs.getString("segundoapellido"));
                    persona.setFechaNacimiento(rs.getDate("fechanacimiento"));
                    persona.setCarrera(rs.getString("carrera"));
                    persona.setCalle(rs.getString("calle"));
                    persona.setBarrio(rs.getString("barrio"));
                    persona.setCasa(rs.getString("casa"));

                    personas.add(persona);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos por la siguiente razón:\n" + e.getMessage());
        } finally {
            if (connection != null) {
                //connection.close();
            }
        }

        return personas;
    }

    public boolean eliminarPersona(int cod) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = ConexionBaseDatos.getInstance().getConnection();
            String sql = "DELETE FROM persona WHERE cod = ?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cod);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
        } finally {
            //close(connection, pst);
        }
        return false;
    }

    public ArrayList<Persona> buscarPersonasPorPrimerNombre(String primerNombre) {
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            connection = ConexionBaseDatos.getInstance().getConnection();

            if (connection != null) {
                String sql = "SELECT * FROM persona WHERE primernombre = ?";
                pst = connection.prepareStatement(sql);
                pst.setString(1, primerNombre);
                rs = pst.executeQuery();

                while (rs.next()) {
                    Persona persona = new Persona();
                    persona.setCod(rs.getInt("cod"));
                    persona.setPrimerNombre(rs.getString("primernombre"));
                    persona.setSegundoNombre(rs.getString("segundonombre"));
                    persona.setPrimerApellido(rs.getString("primerapellido"));
                    persona.setSegundoApellido(rs.getString("segundoapellido"));
                    persona.setFechaNacimiento(rs.getDate("fechanacimiento"));
                    persona.setCarrera(rs.getString("carrera"));
                    persona.setCalle(rs.getString("calle"));
                    persona.setBarrio(rs.getString("barrio"));
                    persona.setCasa(rs.getString("casa"));

                    personas.add(persona);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos por la siguiente razón:\n" + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    //connection.close();
                }
            } finally {

            }
        }

        return personas;
    }
}
