package co.edu.proyectobases.repository;

import java.util.List;

public interface Repositorio<T> {
    //LISTAMOS TODOS LOS DATOS
    List<T> listar();

    //buscar por la llave primaria
    T listarPorId(Integer id);

    //GUARDA LOS DATOS y MODIFICAR LOS DATOS
    void guardar(T t);

    //ELIMINAR LOS DATOS
    void eliminar(Integer id);

}
