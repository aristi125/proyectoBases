package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AgendaCController {

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
    private TableColumn<?, ?> cmCodigoCliente;

    @FXML
    private TableColumn<?, ?> cmCosigoAgenda;

    @FXML
    private TableColumn<?, ?> cmHoraFin;

    @FXML
    private TableColumn<?, ?> cmHoraInicio;

    @FXML
    private TableColumn<?, ?> cmNombreCliente;

    @FXML
    private TableView<?> tblAgendaC;

    @FXML
    private TextField txtCodigoAgenda;

    @FXML
    private TextField txtCodigoCliente;

    @FXML
    private TextField txtFiltrar;

    private Stage stage;

    @FXML
    void evenActionAgregar(ActionEvent event) {

    }

    @FXML
    void evenActionAtras(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/principal-view.fxml"));

            Parent root = loader.load();

            PrincipalController controller = loader.getController();
            controller.setStage(stage);
            // Crear la scene
            Scene scene = new Scene(root);

            // Setear la scene en el stage actual
            currentStage.setScene(scene);

            currentStage.show();

            // Manejar el cierre
            currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });

        } catch (IOException ex) {
            Logger logger = Logger.getLogger(LoginController.class.getName());
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void evenActionBuscar(ActionEvent event) {

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert cmCodigoCliente != null : "fx:id=\"cmCodigoCliente\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert cmCosigoAgenda != null : "fx:id=\"cmCosigoAgenda\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert cmHoraFin != null : "fx:id=\"cmHoraFin\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert cmHoraInicio != null : "fx:id=\"cmHoraInicio\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert cmNombreCliente != null : "fx:id=\"cmNombreCliente\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert txtCodigoAgenda != null : "fx:id=\"txtCodigoAgenda\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert txtCodigoCliente != null : "fx:id=\"txtCodigoCliente\" was not injected: check your FXML file 'agendaC-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'agendaC-view.fxml'.";

    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
}
