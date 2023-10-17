package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class DetalleMaquinaAgendaCliente implements Serializable {

    @ManyToOne
    private AgendaCliente agendaCliente;

    @ManyToOne
    private Maquina maquina;
}
