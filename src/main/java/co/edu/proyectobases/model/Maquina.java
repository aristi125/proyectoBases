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
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Maquina implements Serializable {

    @Id
    private int codMaquina;
    private String nombre;

    @OneToMany (mappedBy = "maquina")
    private List<DetalleMaquinaAgendaCliente> detalleMaquinaCliente;

    @OneToMany (mappedBy = "maquina")
    private List<GrupoMuscular> listGrupoMuscular;

    @OneToMany (mappedBy = "maquina")
    private List<DetalleMaquinaAgendaGym> listDetalleMaquinaGym;
}
