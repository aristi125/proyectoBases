package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class TiendaGym implements Serializable {
    @Id
    private int codTienda;
    private String nombre;

    @OneToMany (mappedBy = "tiendaGym")
    private List<Vendedor> listaVendedor;

    @OneToMany(mappedBy = "tiendaGym")
    private List<Cliente> listCliente;

    @OneToMany (mappedBy = "tiendaGym")
    private List<Producto> listProductos;

}
