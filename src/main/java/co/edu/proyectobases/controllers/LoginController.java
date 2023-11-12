package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController {
    private Stage stage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtUsuario;

    //EVENTO DE LOS TEXT
    @FXML
    void evenKey(KeyEvent event) {
        Object evt = event.getSource();

        if (evt.equals(txtUsuario)) {
            if (event.getCharacter().equals(" ")){
                event.consume();//detenemos el evento si el campo es vacio
            }
        } else if (evt.equals(txtContrasena)) {
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }
    }

    //EVENTO DEL BUTTON

    /**
     * LE VAMOS A QUEMAR EL USUARIO Y LA CONTRASEÑA
     * PARA QUE PUEDA ACCEDER
     * @param event
     */
    @FXML
    void evenaction(ActionEvent event) throws Exception {
        Object evt = event.getSource();

        if (evt.equals(btnIngresar)){

            if (!txtUsuario.getText().isEmpty() && !txtContrasena.getText().isEmpty()){
                String usuario = "root";
                String contrasena = "123";

                if(txtUsuario.getText().equals(usuario) && txtContrasena.getText().equals(contrasena)){

                   /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("principal-view.fxml"));
                    System.out.println("entro 1");
                    Parent root = fxmlLoader.load();
                    System.out.println("entro 2");
                    PrincipalController controller = fxmlLoader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    //controller.init();
                    stage.show();
                    stage.close();*/

                    //LLAMAMOS AL METODO LOADSTAGE PARA CARGAR OTRA VENTANA
                    loadStage(event);
                    JOptionPane.showMessageDialog(null, "Ingreso correctamente");
                }
            }

        }else {
            JOptionPane.showMessageDialog(null, "Error la iniciaar sesion, datos incorrectos",
                    "ADVETENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    void initialize() {
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'login-view.fxml'.";
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'login-view.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'login-view.fxml'.";

    }

private void loadStage(Event event) {

    try {

        // Obtener el stage actual
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cargar el FXML especificando el paquete base
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("co/edu/proyectobases/principal-view.fxml"));
        loader.setController(PrincipalController.class);
        Parent root = loader.load();

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
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}