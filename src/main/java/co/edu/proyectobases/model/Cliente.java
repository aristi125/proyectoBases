package co.edu.proyectobases.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente extends Persona{

    private Integer fk_cod_persona;
    private Integer fk_cod_agendaGym;

}