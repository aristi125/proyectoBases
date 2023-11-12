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

public class ClaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmCodClase;

    @FXML
    private TableColumn<?, ?> cmNombreClase;

    @FXML
    private TableColumn<?, ?> cmNombreCliente;

    @FXML
    private TableColumn<?, ?> cmNombreEntrenador;

    @FXML
    private TableColumn<?, ?> cmRutina;

    @FXML
    private TableView<?> tblClase;

    @FXML
    private TextField txtCodClase;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtNombreClase;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreEntrenador;

    @FXML
    void evenActionAgregar(ActionEvent event) {

    }

    @FXML
    void evenActionAtras(ActionEvent event) {

    }

    @FXML
    void evenActionBuscar(ActionEvent event) {

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmCodClase != null : "fx:id=\"cmCodClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmNombreClase != null : "fx:id=\"cmNombreClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmNombreCliente != null : "fx:id=\"cmNombreCliente\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmNombreEntrenador != null : "fx:id=\"cmNombreEntrenador\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmRutina != null : "fx:id=\"cmRutina\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert tblClase != null : "fx:id=\"tblClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtCodClase != null : "fx:id=\"txtCodClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtNombreClase != null : "fx:id=\"txtNombreClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtNombreCliente != null : "fx:id=\"txtNombreCliente\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtNombreEntrenador != null : "fx:id=\"txtNombreEntrenador\" was not injected: check your FXML file 'clase-view.fxml'.";

    }

}
