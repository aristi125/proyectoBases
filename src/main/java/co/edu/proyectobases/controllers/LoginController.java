package co.edu.proyectobases.controllers;

import java.io.IOException;
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

    /**
     * PARA CARGAR LA VENTANA DE VIENVENIDA
     *
     * @param event
     */
    private void loadStage(Event event) throws Exception {
        try{
            //OCULTAMOS LA VENTANA Y HABRIMOS LA OTRA VENTANA
            ((Node) (event.getSource())).getScene().getWindow().hide();

            //DATOS PARA HABRIR LA OTRA VENTANA
            /*System.out.println("Antes del problema");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("principal-view.fxml")));
            System.out.println("Despues del problema");
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Pagina Principal :3");
            newStage.setScene(scene);
            newStage.show();*/


             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/main/resources/co/edu/proyectobases/principal-view.fxml"));
             Parent root = fxmlLoader.load();
            System.out.println("Despues del problema");
            Scene scene = new Scene(root);
            System.out.println("Despues del problema 2");
            Stage newStage = new Stage();
            //  stage.setTitle("Hello!");
            newStage.setScene(scene);
            System.out.println("Despues del problema 3");
            newStage.show();
            System.out.println("Despues del problema 4");


            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });

        }catch (IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null , ex);
        }
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
}