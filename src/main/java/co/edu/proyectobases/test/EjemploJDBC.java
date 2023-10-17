package co.edu.proyectobases;

import co.edu.proyectobases.model.Producto1;
import co.edu.proyectobases.repository.ProductoRepositorioImpl;
import co.edu.proyectobases.repository.Repositorio;
import co.edu.proyectobases.utils.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

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
            Repositorio<Producto1> repositorio = new ProductoRepositorioImpl();

            System.out.println("=========LISTAR===========");
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

            System.out.println("=========LISTAR POR ID===========");
            System.out.println(repositorio.listarPorId(2L));
            System.out.println("=========CREAR PRODUCTO===========");
            Producto1 producto = new Producto1();
            producto.setNombre("Iphone X");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            repositorio.guardar(producto);

            System.out.println("Guardado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
