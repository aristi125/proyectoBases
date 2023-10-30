package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaquinaAgendaC implements Serializable {

    private AgendaC agendaCliente;

    private Maquina maquina;
}
