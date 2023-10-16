package co.edu.proyectobases.model;

import java.time.LocalDateTime;

public class Agenda {
    private int codAgenda;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFinal;

    //======Gettes and Setter

    public int getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(int codAgenda) {
        this.codAgenda = codAgenda;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    // ==Constructores


    public Agenda() {
    }

    public Agenda(int codAgenda, LocalDateTime horaInicio, LocalDateTime horaFinal) {
        this.codAgenda = codAgenda;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    //===ToString


    @Override
    public String toString() {
        return "Agenda{" +
                "codAgenda=" + codAgenda +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                '}';
    }
}
