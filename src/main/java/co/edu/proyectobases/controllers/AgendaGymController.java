package co.edu.proyectobases.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AgendaGymController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> CmHoraFin;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmClase;

    @FXML
    private TableColumn<?, ?> cmCliente;

    @FXML
    private TableColumn<?, ?> cmEntrenador;

    @FXML
    private TableColumn<?, ?> cmHoraInicio;

    @FXML
    private TableColumn<?, ?> cmIdAgendaGym;

    @FXML
    private TableColumn<?, ?> cmMaquinas;

    @FXML
    private TableView<?> tblAgendaGym;

    @FXML
    private TextField txtFiltrar;

    @FXML
    void evenActionBuscar(ActionEvent event) {

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert CmHoraFin != null : "fx:id=\"CmHoraFin\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmClase != null : "fx:id=\"cmClase\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmCliente != null : "fx:id=\"cmCliente\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmEntrenador != null : "fx:id=\"cmEntrenador\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmHoraInicio != null : "fx:id=\"cmHoraInicio\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmIdAgendaGym != null : "fx:id=\"cmIdAgendaGym\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert cmMaquinas != null : "fx:id=\"cmMaquinas\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert tblAgendaGym != null : "fx:id=\"tblAgendaGym\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'agendaGym.fxml'.";

    }

}

