package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleMaquinaAgendaGym {

    @ManyToOne
    private Maquina maquina;

    @ManyToOne
    private AgendaGym agendaGym;
}
