package co.edu.proyectobases.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaquinaAgendaC implements Serializable {

    private Integer fk_cod_agendaCliente;

    private Integer fk_cod_maquina;
}
