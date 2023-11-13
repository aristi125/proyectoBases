package co.edu.proyectobases.model;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Clase implements Serializable {

    private Integer codClase;
    private Integer fk_cod_agendaGym;
    private String nombre;
    private String tipo;

}