package co.edu.proyectobases.model;

import java.io.Serializable;
import java.util.List;

public class AgendaGym extends Agenda implements Serializable {

    private List<MaquinaAgendaGym> listDetalleMaquinaGym;

    private List<Clase> listClase;

    private List<Cliente> listCliente;

    private List<Entrenador> listEntrenador;

}
