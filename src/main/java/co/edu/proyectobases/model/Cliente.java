package co.edu.proyectobases.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente extends Persona{

    private List<Agenda> listAgendaCliente;
    private AgendaGym agendaGym;

}