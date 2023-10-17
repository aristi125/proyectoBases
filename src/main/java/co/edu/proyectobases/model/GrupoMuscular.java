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
public class GrupoMuscular implements Serializable {

    @Id
    private int codGrupoMuscular;
    private String nombre;

    @ManyToOne
    private Maquina maquina;
}
