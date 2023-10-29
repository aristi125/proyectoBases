package co.edu.proyectobases.model;

import java.util.Date;

public class Producto1 {
    private Integer cod;
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

    //CONSTRUCTORES


    public Producto1() {
    }

    public Producto1(Integer cod, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date diaNacimiento, Date mesNacimiento, Date anioNacimiento, String carrera, String calle, String barrio, String casa) {
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


//===========================

    //GETTERS AND SETTERS

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setDiaNacimiento(Date diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public Date getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(Date mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public Date getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Date anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }


    //METODOS TOSTRING

    @Override
    public String toString() {
        return "Producto1{" +
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


    //==========================
}
