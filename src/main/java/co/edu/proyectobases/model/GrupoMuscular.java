package co.edu.proyectobases.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoMuscular implements Serializable {

    private int codGrupoMuscular;
    private String nombre;
    private Maquina maquina;
}