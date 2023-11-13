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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AgendaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntAtras;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnbuscar;

    @FXML
    private TableColumn<?, ?> cmCodigoId;

    @FXML
    private TableColumn<?, ?> cmHoraFin;

    @FXML
    private TableColumn<?, ?> cmHoraInicio;

    @FXML
    private TableColumn<?, ?> cmNombre;

    @FXML
    private DatePicker dateHoraFinal;

    @FXML
    private DatePicker dateHoraInicio;

    @FXML
    private TableView<?> tblAgenda;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtId;
    private Stage stage;

    @FXML
    void evenActionAgendar(ActionEvent event) {

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
        assert bntAtras != null : "fx:id=\"bntAtras\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert btnbuscar != null : "fx:id=\"btnbuscar\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert cmCodigoId != null : "fx:id=\"cmCodigoId\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert cmHoraFin != null : "fx:id=\"cmHoraFin\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert cmHoraInicio != null : "fx:id=\"cmHoraInicio\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert cmNombre != null : "fx:id=\"cmNombre\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert dateHoraFinal != null : "fx:id=\"dateHoraFinal\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert dateHoraInicio != null : "fx:id=\"dateHoraInicio\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert tblAgenda != null : "fx:id=\"tblAgenda\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'agenda-view.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'agenda-view.fxml'.";

    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

}
