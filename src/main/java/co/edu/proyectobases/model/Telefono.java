package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Telefono implements Serializable {

    private String codTelefono;
    private String telefono;
    private Persona persona;

}
