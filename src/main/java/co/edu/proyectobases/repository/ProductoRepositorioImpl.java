package co.edu.proyectobases.repository;

import co.edu.proyectobases.model.Producto1;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto1> {

    //METODO QUE DEVUELVE LA CONECCION AL A BD
    //metodo para obtener la coneccion
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    //=====================================================

    //METODOS SOBRE ESCRITOS
    @Override
    public List<Producto1> listar() {
        List<Producto1> productos = new ArrayList<>();

        //creamos la sentencia
        try (Statement stmt = getConnection().createStatement();
             ResultSet reslut = stmt.executeQuery("SELECT * FROM productos")){
            //iteramos el resultSet o el cursor y lo guardamos en la lista productos
            while (reslut.next()){
                Producto1 p = cearProducto(reslut);
                //los pasamos a la lista
                productos.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }


    @Override
    public Producto1 listarPorId(Integer id) {
        //devolver un tipo producto con un WHERE
        Producto1 producto = null;
        try(PreparedStatement pstmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id=?");) {
            pstmt.setInt(1,id);
            ResultSet result = pstmt.executeQuery();

            //solo busca a un producto en especifico
            if (result.next()){
                producto = cearProducto(result);
            }
            result.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }

    @Override
    public void guardar(Producto1 producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }
    //===============================================================

    //METODOS CREADOS
    private static Producto1 cearProducto(ResultSet reslut) throws SQLException {
        Producto1 p = new Producto1();
        p.setId(reslut.getInt("id"));
        p.setNombre(reslut.getString("nombre"));
        p.setPrecio(reslut.getInt("precio"));
        p.setFechaRegistro(reslut.getDate("fecha_registro"));
        return p;
    }
    //=====================================
}
