package co.edu.proyectobases;

import co.edu.proyectobases.controllers.AgendaController;
import co.edu.proyectobases.controllers.LoginController;
import co.edu.proyectobases.controllers.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Principal extends Application {

    //PARA LA BD
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Obtener el controlador del FXMLLoader
        Object controller = loader.getController();

        if (controller instanceof LoginController) {
            ((LoginController)controller).setStage(primaryStage);
        } else if (controller instanceof PrincipalController) {
            ((PrincipalController)controller).setStage(primaryStage);
        }

        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}
