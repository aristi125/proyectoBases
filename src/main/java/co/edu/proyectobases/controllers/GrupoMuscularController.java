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

public class GrupoMuscularController {

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
    private TableColumn<?, ?> cmCodigo;

    @FXML
    private TableColumn<?, ?> cmMaquina;

    @FXML
    private TableColumn<?, ?> cmNombre;

    @FXML
    private TableView<?> tblGrupoMuscular;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtMaquina;

    @FXML
    private TextField txtNombreMaquina;

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
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmCodigo != null : "fx:id=\"cmCodigo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmMaquina != null : "fx:id=\"cmMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmNombre != null : "fx:id=\"cmNombre\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert tblGrupoMuscular != null : "fx:id=\"tblGrupoMuscular\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtMaquina != null : "fx:id=\"txtMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtNombreMaquina != null : "fx:id=\"txtNombreMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";

    }

}
