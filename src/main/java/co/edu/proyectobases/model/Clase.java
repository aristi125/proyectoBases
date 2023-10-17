package co.edu.proyectobases.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clase implements Serializable {
    @Id
    private int codClase;
    private String nombre;

    @ManyToOne
    private AgendaGym agendaGym;

}
