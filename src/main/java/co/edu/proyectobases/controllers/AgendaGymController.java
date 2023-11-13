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

public class AgendaGymController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> CmHoraFin;

    @FXML
    private Button btnAtras;

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

    private Stage stage;

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
        assert CmHoraFin != null : "fx:id=\"CmHoraFin\" was not injected: check your FXML file 'agendaGym.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'agendaGym.fxml'.";
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
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
}


