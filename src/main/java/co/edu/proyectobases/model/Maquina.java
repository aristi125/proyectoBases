package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Maquina implements Serializable {

    private int codMaquina;
    private String nombre;

    private List<MaquinaAgendaC> detalleMaquinaCliente;

    private List<GrupoMuscular> listGrupoMuscular;

    private List<MaquinaAgendaGym> listDetalleMaquinaGym;
}
