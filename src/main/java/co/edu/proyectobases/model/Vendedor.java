package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;
@Entity
public class Vendedor extends Persona{

    @ManyToOne
    private TiendaGym tiendaGym;


}
