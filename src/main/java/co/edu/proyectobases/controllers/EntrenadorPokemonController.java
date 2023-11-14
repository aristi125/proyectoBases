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

public class EntrenadorPokemonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmCantidadEspecialidad;

    @FXML
    private TableColumn<?, ?> cmNombreCompletp;

    @FXML
    private TableView<?> tblEntrenadorPokemon;

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
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert cmCantidadEspecialidad != null : "fx:id=\"cmCantidadEspecialidad\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert cmNombreCompletp != null : "fx:id=\"cmNombreCompletp\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert tblEntrenadorPokemon != null : "fx:id=\"tblEntrenadorPokemon\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";

    }

}
