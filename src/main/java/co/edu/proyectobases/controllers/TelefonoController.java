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

public class TelefonoController {

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
    private TableColumn<?, ?> cmCodigoTele;

    @FXML
    private TableColumn<?, ?> cmNombrePerso;

    @FXML
    private TableColumn<?, ?> cmTelefono;

    @FXML
    private TableView<?> tblTelefono;

    @FXML
    private TextField txtCodTelefono;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtMombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void evenActionAgregar(ActionEvent event) {

    }

    @FXML
    void evenActionBuscar(ActionEvent event) {

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert cmCodigoTele != null : "fx:id=\"cmCodigoTele\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert cmNombrePerso != null : "fx:id=\"cmNombrePerso\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert cmTelefono != null : "fx:id=\"cmTelefono\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert tblTelefono != null : "fx:id=\"tblTelefono\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert txtCodTelefono != null : "fx:id=\"txtCodTelefono\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert txtMombre != null : "fx:id=\"txtMombre\" was not injected: check your FXML file 'telefono-view.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'telefono-view.fxml'.";

    }

}
