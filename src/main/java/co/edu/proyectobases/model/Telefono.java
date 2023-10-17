package co.edu.proyectobases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Telefono implements Serializable {

    @Id
    private String codTelefono;
    private String telefono;

    @ManyToOne
    private Persona persona;

}
