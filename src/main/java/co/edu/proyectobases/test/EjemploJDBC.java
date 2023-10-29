package co.edu.proyectobases.test;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.model.Producto1;
import co.edu.proyectobases.repository.PersonaRepositorioImpl;
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
            Repositorio<Persona> repositorio = new PersonaRepositorioImpl();

            System.out.println("=========LISTAR===========");
            repositorio.listar().forEach(p -> System.out.println(p.getPrimerNombre()));

            System.out.println("=========LISTAR POR ID===========");
            System.out.println(repositorio.listarPorId(1));
            System.out.println("=========CREAR PRODUCTO===========");
            Persona persona = new Persona();
            persona.setPrimerNombre("Juan");
            persona.setSegundoNombre("Perez");
            persona.setPrimerApellido("Perez");
            persona.setSegundoApellido("Perez");
            persona.setFechaNacimiento(new Date());
            persona.setCarrera("Ingenieria");
            persona.setCalle("Calle 1");
            persona.setBarrio("Barrio 1");
            persona.setCasa("Casa 1");
            repositorio.guardar(persona);

            System.out.println("Guardado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
