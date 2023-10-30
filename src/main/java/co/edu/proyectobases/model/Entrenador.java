package co.edu.proyectobases.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Entrenador extends Persona{

    private AgendaGym agendaGym;

    private Especialidad especialidad;

}
