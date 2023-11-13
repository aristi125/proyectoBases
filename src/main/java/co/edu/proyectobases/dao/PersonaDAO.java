package co.edu.proyectobases.dao;

import co.edu.proyectobases.model.Persona;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

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
    public static void close(Connection connection, PreparedStatement pst) {
        try {
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void agregar(Integer cod,String primernombre,String segundonombre,String primerapellido,String segundoapellido,Date fecha,String Carrera, String calle,String barrio,String casa){

        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        int state = -1;

        try {


            // Se utiliza DriverManager para obtener la conexión
            connection = getConnection();

            if (connection != null) {
                String sql = "INSERT INTO persona (cod, primernombre, segundonombre, primerapellido, segundoapellido, fechanacimiento, carrera, calle, barrio, casa)\n" +
                        "VALUES\n" +
                        "    ("+cod+", '"+primernombre+"', '"+segundonombre+"', '"+primerapellido+"', '"+segundoapellido+"', '"+fecha+"', '"+Carrera+"', '"+calle+"', '"+barrio+"', '"+casa+"')";

                pst = connection.prepareStatement(sql);
                //pst.setString(1, usuario);
                //pst.setString(2, contrasena);

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

    }
    public ArrayList<Persona> consultarTodos() {
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            connection = getConnection();

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
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return personas;
    }

    public boolean eliminarPersona(int cod) {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = getConnection();
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
            close(connection, pst);
        }
        return false;
    }

    public ArrayList<Persona> buscarPersonasPorPrimerNombre(String primerNombre) {
        Connection connection = null;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            connection = getConnection();

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
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return personas;
    }
}
