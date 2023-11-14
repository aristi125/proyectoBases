package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Telefono implements Serializable {

    private Integer codTelefono;
    private Long numeroTelefono;
    private Integer fk_cod_persona;

}
