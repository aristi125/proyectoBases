package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.model.Telefono;
import co.edu.proyectobases.utils.ConexionBaseDatos;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Map> tblTelefono;

    @FXML
    private TextField txtCodTelefono;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtMombre;

    @FXML
    private TextField txtTelefono;

    private Stage stage;

    private final String coCodTelefono = "cmCodigoTeleno";
    private final String coNombrePersona = "cmNombrePersona";
    private final String coNumeroTelefono = "cmTelefono";
    private final String coCodigoPersona = "cmCodigoPersona";



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

    public void setStage(Stage stage) {
        this.stage =  stage;
    }


    public ObservableList<Map> buscarTelefonosPorNombrePersona(Integer nombrePersona){

        ObservableList<Map> personas = FXCollections.observableArrayList();

        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();

            String sql = "SELECT \n" +
                    "    t.codtelefono,\n" +
                    "    t.numerotelefono,\n" +
                    "    t.persona_cod,\n" +
                    "    p.primernombre || ' ' || p.primerapellido AS nombre_persona\n" +
                    "FROM \n" +
                    "    telefono t\n" +
                    "JOIN \n" +
                    "    persona p ON t.persona_cod = p.cod\n" +
                    "JOIN \n" +
                    "    cliente c ON c.persona_cod = p.cod\n" +
                    "WHERE \n" +
                    "    p.primernombre = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, nombrePersona);

            ResultSet resultSet = consulta.executeQuery();

            while(resultSet.next()){

                Map<String, Object> row = new HashMap<>();


                row.put("codtelefono", resultSet.getInt("cod"));
                row.put("persona_cod", resultSet.getInt("persona_cod"));
                row.put("numerotelefono", resultSet.getInt("numero"));
                row.put("nombre_persona", resultSet.getString("nombre_persona"));


                personas.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;

    }


    //Se activa cuando se cree la tabla persona

    public ObservableList<Map> todosTelefonos(){


        var sql = "SELECT \n" +
                "    t.codtelefono,\n" +
                "    t.numerotelefono,\n" +
                "    t.persona_cod,\n" +
                "    p.primernombre || ' ' || p.primerapellido AS nombre_persona\n" +
                "FROM \n" +
                "    telefono t\n" +
                "JOIN \n" +
                "    persona p ON t.persona_cod = p.cod";

        ObservableList<Map> telefonosList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                Persona persona = new Persona();
                Telefono telefono = new Telefono();
                Map<String, Object> coleccion = new HashMap<>();

                telefono.setCodTelefono(resultSet.getInt("cod"));
                telefono.setNumeroTelefono(resultSet.getInt("numero"));
                telefono.setFk_cod_persona(resultSet.getInt("persona_cod"));

                persona.setCod(resultSet.getInt("persona_cod"));
                persona.setPrimerNombre(resultSet.getString("nombre_persona"));

                //// Agregar al ObservableList

                coleccion.put(coCodTelefono, String.valueOf(telefono.getCodTelefono()));
                coleccion.put(coNumeroTelefono, String.valueOf(telefono.getNumeroTelefono()));
                coleccion.put(coCodigoPersona, String.valueOf(telefono.getFk_cod_persona()));
                coleccion.put(coNombrePersona, String.valueOf(persona.getPrimerNombre()));

                telefonosList.add(coleccion);

            }

            //resultSet.close();
            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return telefonosList;
    }


}
