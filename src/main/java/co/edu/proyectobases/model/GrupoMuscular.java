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

    private Integer codGrupoMuscular;
    private String nombre;
    private Integer fk_cod_maquina;
    private Integer fk_cod_rutina;
}