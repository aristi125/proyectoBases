package co.edu.proyectobases.model;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Persona implements Serializable{

    //@Id
    private int cod;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String carrera;
    private String calle;
    private String barrio;
    private String casa;

   // @OneToMany (mappedBy = "persona")
    private List<Telefono> listaTelefonos;




}
