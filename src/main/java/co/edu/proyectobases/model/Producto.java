package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto implements Serializable {
    @Id
    private int codProducto;
    private String nombre;
    private int cantidad;
    private double precio;
    private String talla;
    private String color;
    private String gramos;
    private int calorias;

    @ManyToOne
    private TiendaGym tiendaGym;

    @ManyToOne
    private Cliente cliente;


}
