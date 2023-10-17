package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class AgendaCliente extends Agenda implements Serializable {

    @ManyToOne
    private Cliente cliente;

    @OneToMany (mappedBy = "agendaCliente")
    private List<DetalleMaquinaAgendaCliente> listDetalleMaquinaCliente;
}
