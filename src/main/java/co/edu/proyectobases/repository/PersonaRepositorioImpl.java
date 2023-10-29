package co.edu.proyectobases.repository;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorioImpl implements Repositorio<Persona> {
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    //=====================================================

    //METODOS SOBRE ESCRITOS
    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();

        //creamos la sentencia
        try (Statement stmt = getConnection().createStatement();
             ResultSet reslut = stmt.executeQuery("SELECT * FROM persona")){
            //iteramos el resultSet o el cursor y lo guardamos en la lista productos
            while (reslut.next()){
                Persona p = crearProducto(reslut);
                //los pasamos a la lista
                personas.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personas;
    }


    @Override
    public Persona listarPorId(Integer id) {
        //devolver un tipo producto con un WHERE
        Persona persona = null;
        try(PreparedStatement pstmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id=?");) {
            pstmt.setInt(1,id);
            ResultSet result = pstmt.executeQuery();

            //solo busca a un producto en especifico
            if (result.next()){
                persona = crearProducto(result);
            }
            result.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persona;
    }

    @Override
    public void guardar(Persona persona) {

    }

    @Override
    public void eliminar(Integer id) {

    }
    //===============================================================

    //METODOS CREADOS
    private static Persona crearProducto(ResultSet reslut) throws SQLException {
        Persona p = new Persona();
        p.setCod(reslut.getInt("id"));
        p.setPrimerNombre(reslut.getString("primerNombre"));
        p.setSegundoNombre(reslut.getString("segundoNombre"));
        p.setPrimerApellido(reslut.getString("primerApellido"));
        p.setSegundoApellido(reslut.getString("segundoApellido"));
        p.setFechaNacimiento(reslut.getDate("fechaNacimiento"));
        p.setCarrera(reslut.getString("carrera"));
        p.setCalle(reslut.getString("calle"));
        p.setBarrio(reslut.getString("barrio"));
        p.setCasa(reslut.getString("casa"));
        return p;
    }
}
