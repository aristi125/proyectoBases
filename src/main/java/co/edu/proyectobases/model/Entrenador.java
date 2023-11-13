package co.edu.proyectobases.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Entrenador extends Persona{

    private Integer fk_cod_agendaGym;

    private Especialidad especialidad;

}
