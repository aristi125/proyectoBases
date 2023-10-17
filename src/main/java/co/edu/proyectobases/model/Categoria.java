package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Categoria implements Serializable {

    @Id
    private int codCategoria;
    private String nombre;

    @OneToMany (mappedBy = "tiendaGym")
    private List<Producto> lisProductos;

    @ManyToOne
    private Categoria categoria;
    @OneToMany (mappedBy = "Categoria")
    private List<Categoria> listCategoria;
}
