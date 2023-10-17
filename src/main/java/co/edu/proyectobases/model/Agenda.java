package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agenda implements Serializable {

    @Id
    private int codAgenda;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;



}
