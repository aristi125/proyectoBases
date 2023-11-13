package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAvanza1;

    @FXML
    private Button btnAvanza2;

    @FXML
    private Button btnAvanza3;

    @FXML
    private Button btnInterme1;

    @FXML
    private Button btnInterme2;

    @FXML
    private Button btnInterme3;

    @FXML
    private Button btnInterme4;

    @FXML
    private Button btnSencilla1;

    @FXML
    private Button btnSencilla2;

    @FXML
    private Button btnSencilla3;
    private Stage stage;

    @FXML
    void evenActionAvanza1(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/clase-view.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            ClaseController controller = loader.getController();
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
    void evenActionAvanza2(ActionEvent event) {

    }

    @FXML
    void evenActionAvanza3(ActionEvent event) {

    }

    @FXML
    void evenActionInterme1(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/agenda-view.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            AgendaController controller = loader.getController();
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
    void evenActionInterme2(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/agendaC-view.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            AgendaCController controller = loader.getController();
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
    void evenActionInterme3(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/telefono-view.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            TelefonoController controller = loader.getController();
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
    void evenActionInterme4(ActionEvent event) {

    }

    @FXML
    void evenActionSencilla1(ActionEvent event) {

    }

    @FXML
    void evenActionSencilla2(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/Persona.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            PersonaController controller = loader.getController();
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
    void evenActionSencilla3(ActionEvent event) {
        try {

            // Obtener el stage actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cargar el FXML especificando el paquete base
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/grupoMuscular-view.fxml"));
            // loader.setController(PrincipalController.class);
            Parent root = loader.load();

            GrupoMuscularController controller = loader.getController();
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
    void initialize() {

        location = getClass().getResource("principal-view.fxml");
        assert btnAvanza1 != null : "fx:id=\"btnAvanza1\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnAvanza2 != null : "fx:id=\"btnAvanza2\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnAvanza3 != null : "fx:id=\"btnAvanza3\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnInterme1 != null : "fx:id=\"btnInterme1\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnInterme2 != null : "fx:id=\"btnInterme2\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnInterme3 != null : "fx:id=\"btnInterme3\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnInterme4 != null : "fx:id=\"btnInterme4\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnSencilla1 != null : "fx:id=\"btnSencilla1\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnSencilla2 != null : "fx:id=\"btnSencilla2\" was not injected: check your FXML file 'principal-view.fxml'.";
        assert btnSencilla3 != null : "fx:id=\"btnSencilla3\" was not injected: check your FXML file 'principal-view.fxml'.";

    }

    public void loadStage(Event event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectobases/principal-view.fxml"));
        loader.setController(PrincipalController.class);

        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);

        stage.show();

    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
}
