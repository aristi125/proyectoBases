package co.edu.proyectobases.model;

import java.io.Serializable;
import java.util.List;

public class AgendaC extends Agenda implements Serializable {

    private Cliente cliente;

    private List<MaquinaAgendaC> listDetalleMaquinaCliente;
}

