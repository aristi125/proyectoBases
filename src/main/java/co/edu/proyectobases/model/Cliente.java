package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Cliente extends Persona{

    @ManyToOne
    private TiendaGym tiendaGym;

    @OneToMany(mappedBy = "cliente")
    private List<Producto> listProductos;

    @OneToMany (mappedBy = "cliente")
    private List<Agenda> listAgendaCliente;

    @ManyToOne
    private AgendaGym agendaGym;

}
