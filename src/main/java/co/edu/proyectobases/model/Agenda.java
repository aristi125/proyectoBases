package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Agenda implements Serializable {

    private int codAgenda;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;

}
