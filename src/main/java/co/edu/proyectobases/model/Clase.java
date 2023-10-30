package co.edu.proyectobases.model;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Clase implements Serializable {

    private int codClase;
    private String nombre;

    private AgendaGym agendaGym;

}