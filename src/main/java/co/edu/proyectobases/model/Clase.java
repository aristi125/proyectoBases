package co.edu.proyectobases.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clase {
    private int codClase;
    private String nombre;

    //=======Constructores


    public Clase(int codClase, String nombre) {
        this.codClase = codClase;
        this.nombre = nombre;
    }


    public Clase() {
    }


    //========== ToSting

    @Override
    public String toString() {
        return "Clase{" +
                "codClase=" + codClase +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
