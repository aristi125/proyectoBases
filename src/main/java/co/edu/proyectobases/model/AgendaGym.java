package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class AgendaGym extends Agenda implements Serializable {


    @OneToMany (mappedBy = "agendaGym")
    private List<DetalleMaquinaAgendaGym> listDetalleMaquinaGym;

    @OneToMany (mappedBy = "agendaGym")
    private List<Clase> listClase;

    @OneToMany (mappedBy = "agendaGym")
    private List<Cliente> listCliente;

    @OneToMany (mappedBy = "agendaGym")
    private List<Entrenador> listEntrenador;

}
