package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Maquina implements Serializable {

    private Integer codMaquina;
    private String nombre;
}
