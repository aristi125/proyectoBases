package co.edu.proyectobases;

import co.edu.proyectobases.model.Producto;
import co.edu.proyectobases.repository.ProductoRepositorioImpl;
import co.edu.proyectobases.repository.Repositorio;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.*;

public class EjemploJDBC {
    //static Connection conn = null;
    //para listar lo de la BD
    //debuleve un cursor que esta dentro del resulset
   // static Statement stmt = null;
    //static ResultSet result = null;
    public static void main(String[] args) {

        //SE ENCARGA DE ADMINISTRAR LAS CONECCIONES
        //Y LOS DIRVES QUE TENEMOS DISPONIBLES
        try (Connection conn = ConexionBaseDatos.getInstance();){
            //vamos a crear la instancia del repositorio
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));
            System.out.println("====================");
            System.out.println(repositorio.listarPorId(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            cerrarConecion();
//        }

    }

    /**
     * SIRVE PARA CERRAR LA BD
      */
//    public static void cerrarConecion(){
//        try {
//            if ((result != null) && (stmt != null) && (conn != null )) {
//                result.close();
//                stmt.close();
//                conn.close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
