package co.edu.proyectobases.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class PersonaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DateFechaNaci;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmBarrio;

    @FXML
    private TableColumn<?, ?> cmCalle;

    @FXML
    private TableColumn<?, ?> cmCarrera;

    @FXML
    private TableColumn<?, ?> cmCasa;

    @FXML
    private TableColumn<?, ?> cmCodigo;

    @FXML
    private TableColumn<?, ?> cmFechaNaci;

    @FXML
    private TableColumn<?, ?> cmPrimeApe;

    @FXML
    private TableColumn<?, ?> cmPrimerNom;

    @FXML
    private TableColumn<?, ?> cmSegundoApe;

    @FXML
    private TableColumn<?, ?> cmSegundoNom;

    @FXML
    private TableView<?> tblPersona;

    @FXML
    private TextField txtBarrio;

    @FXML
    private TextField txtCalle;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtCasa;

    @FXML
    private TextField txtCodigoPersona;

    @FXML
    private TextField txtPrimerApe;

    @FXML
    private TextField txtPrimerNom;

    @FXML
    private TextField txtSegundoApe;

    @FXML
    private TextField txtSegundoNom;

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
        assert DateFechaNaci != null : "fx:id=\"DateFechaNaci\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmBarrio != null : "fx:id=\"cmBarrio\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCalle != null : "fx:id=\"cmCalle\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCarrera != null : "fx:id=\"cmCarrera\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCasa != null : "fx:id=\"cmCasa\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCodigo != null : "fx:id=\"cmCodigo\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmFechaNaci != null : "fx:id=\"cmFechaNaci\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmPrimeApe != null : "fx:id=\"cmPrimeApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmPrimerNom != null : "fx:id=\"cmPrimerNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmSegundoApe != null : "fx:id=\"cmSegundoApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmSegundoNom != null : "fx:id=\"cmSegundoNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert tblPersona != null : "fx:id=\"tblPersona\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtBarrio != null : "fx:id=\"txtBarrio\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCalle != null : "fx:id=\"txtCalle\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCarrera != null : "fx:id=\"txtCarrera\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCasa != null : "fx:id=\"txtCasa\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCodigoPersona != null : "fx:id=\"txtCodigoPersona\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtPrimerApe != null : "fx:id=\"txtPrimerApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtPrimerNom != null : "fx:id=\"txtPrimerNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtSegundoApe != null : "fx:id=\"txtSegundoApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtSegundoNom != null : "fx:id=\"txtSegundoNom\" was not injected: check your FXML file 'Persona.fxml'.";

    }

}
