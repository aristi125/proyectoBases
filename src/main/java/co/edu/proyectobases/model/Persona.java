package co.edu.proyectobases.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class Persona implements Serializable{

    //@Id
    private int cod;
    //@OneToMany
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date diaNacimiento;
    private Date mesNacimiento;
    private Date anioNacimiento;
    private String carrera;
    private String calle;
    private String barrio;
    private String casa;

    //======== Constructores


    public Persona() {
    }

    public Persona(int cod, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date diaNacimiento, Date mesNacimiento, Date anioNacimiento, String carrera, String calle, String barrio, String casa) {
        this.cod = cod;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.carrera = carrera;
        this.calle = calle;
        this.barrio = barrio;
        this.casa = casa;
    }

    // ============ToString


    @Override
    public String   toString() {
        return "Persona{" +
                "cod=" + cod +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", diaNacimiento=" + diaNacimiento +
                ", mesNacimiento=" + mesNacimiento +
                ", anioNacimiento=" + anioNacimiento +
                ", carrera='" + carrera + '\'' +
                ", calle='" + calle + '\'' +
                ", barrio='" + barrio + '\'' +
                ", casa='" + casa + '\'' +
                '}';
    }
}
