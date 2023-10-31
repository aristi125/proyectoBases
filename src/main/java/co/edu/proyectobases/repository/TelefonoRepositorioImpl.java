package co.edu.proyectobases.repository;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.model.Telefono;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefonoRepositorioImpl implements Repositorio<Telefono> {

    //METODO QUE DEVUELVE LA CONECCION AL A BD
    //metodo para obtener la coneccion
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    //=====================================================

    //METODOS SOBRE ESCRITOS
    @Override
    public List<Telefono> listar() {
        List<Telefono> telefono = new ArrayList<>();

        //creamos la sentencia
        try (Statement stmt = getConnection().createStatement();
             ResultSet reslut = stmt.executeQuery("SELECT * FROM telefono")){
            //iteramos el resultSet o el cursor y lo guardamos en la lista productos
            while (reslut.next()){
                Telefono p = cearProducto(reslut);
                //los pasamos a la lista
                telefono.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return telefono;
    }


    @Override
    public Telefono listarPorId(Integer id) {
        //devolver un tipo producto con un WHERE
        Telefono telefono = null;
        try(PreparedStatement pstmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id=?");) {
            pstmt.setInt(1,id);
            ResultSet result = pstmt.executeQuery();

            //solo busca a un producto en especifico
            if (result.next()){
                telefono = cearProducto(result);
            }
            result.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return telefono;
    }

    @Override
    public void guardar(Telefono telefono) {

    }

    @Override
    public void eliminar(Integer id) {

    }
    //===============================================================

    //METODOS CREADOS
    private static Telefono cearProducto(ResultSet reslut) throws SQLException {
        Telefono p = new Telefono();
       /* p.setCod(reslut.getInt("cod"));
        p.setCalle(reslut.getString("calle"));
        p.setBarrio(reslut.getString("barrio"));
        p.setCasa(reslut.getString("casa"));
        p.setPrimerNombre(reslut.getString("primerNombre"));
        p.setSegundoNombre(reslut.getString("segundoNombre"));
        p.setPrimerApellido(reslut.getString("primerApellido"));
        p.setSegundoApellido(reslut.getString("segundoApellido"));
        p.setDiaNacimiento(reslut.getDate("diaNacimiento"));
        p.setMesNacimiento(reslut.getDate("mesNacimiento"));
        p.setAnioNacimiento(reslut.getDate("anioNacimiento"));
        p.setCarrera(reslut.getString("carrera"));
        return p;
        */
        return null;
    }
    //=====================================
}
