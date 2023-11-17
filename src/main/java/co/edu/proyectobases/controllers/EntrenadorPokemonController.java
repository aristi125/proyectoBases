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
import co.edu.proyectobases.utils.ConexionBaseDatos;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EntrenadorPokemonController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmCantidadEspecialidad;

    @FXML
    private TableColumn<?, ?> cmNombreCompletp;

    @FXML
    private TableView<Map> tblEntrenadorPokemon;

    @FXML
    private TextField txtFiltrar;
    private Stage stage;


    final private String coNombreEntrenador = "cmNombreCompletp";
    final private String coCantidadEspecialidad = "cmCantidadEspecialidad";

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
        if (txtFiltrar.getText().isEmpty()) {
            llenarTabla();
        } else {
            tblEntrenadorPokemon.getItems().clear();

            ObservableList<Map> lista = buscarEntrenadorPorNombre(txtFiltrar.getText());


            this.cmNombreCompletp.setCellValueFactory(new MapValueFactory(coNombreEntrenador));
            this.cmCantidadEspecialidad.setCellValueFactory(new MapValueFactory(coCantidadEspecialidad));

            tblEntrenadorPokemon.setItems(lista);
        }
    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert cmCantidadEspecialidad != null : "fx:id=\"cmCantidadEspecialidad\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert cmNombreCompletp != null : "fx:id=\"cmNombreCompletp\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert tblEntrenadorPokemon != null : "fx:id=\"tblEntrenadorPokemon\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'EntrenadorPokemon-view.fxml'.";

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ObservableList<Map> buscarEntrenadorPorNombre(String nombre) {

        ObservableList<Map> entrenadoresList = FXCollections.observableArrayList();

        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();

            String sql = "SELECT * FROM (\n" +
                    "    SELECT\n" +
                    "        (p.primernombre || ' ' || p.primerapellido) AS nombre_entrenador,\n" +
                    "        (\n" +
                    "            SELECT COUNT(1)\n" +
                    "            FROM entrenador_especialidad ee\n" +
                    "            WHERE ee.entrenador_persona_cod = e.persona_cod\n" +
                    "        ) AS cantidad_especialidades\n" +
                    "    FROM persona p\n" +
                    "    JOIN entrenador e ON p.cod = e.persona_cod\n" +
                    "    WHERE EXISTS (\n" +
                    "        SELECT 1\n" +
                    "        FROM entrenador_especialidad ee\n" +
                    "        WHERE ee.entrenador_persona_cod = e.persona_cod\n" +
                    "    )\n" +
                    ") WHERE nombre_entrenador = ?";

            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombre);

            ResultSet resultSet = consulta.executeQuery();

            while (resultSet.next()) {

                Map<String, Object> coleccion = new HashMap<>();

                coleccion.put(coNombreEntrenador, resultSet.getString("nombre_entrenador"));
                coleccion.put(coCantidadEspecialidad, resultSet.getString("cantidad_especialidades"));

                entrenadoresList.add(coleccion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrenadoresList;
    }


    public ObservableList<Map> todosEntrenadores(){
        var sql = "SELECT\n" +
                "    (p.primernombre || ' ' || p.primerapellido) AS nombre_entrenador,\n" +
                "    (\n" +
                "        SELECT COUNT(1)\n" +
                "        FROM entrenador_especialidad ee\n" +
                "        WHERE ee.entrenador_persona_cod = e.persona_cod\n" +
                "    ) AS cantidad_especialidades\n" +
                "FROM persona p\n" +
                "JOIN entrenador e ON p.cod = e.persona_cod\n" +
                "WHERE EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM entrenador_especialidad ee\n" +
                "    WHERE ee.entrenador_persona_cod = e.persona_cod\n" +
                ")";

        ObservableList<Map> entrenadoresList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                Map<String, Object> coleccion = new HashMap<>();

                coleccion.put(coNombreEntrenador,resultSet.getString("nombre_entrenador"));
                coleccion.put(coCantidadEspecialidad,resultSet.getString("cantidad_especialidades"));

                entrenadoresList.add(coleccion);

            }

            //resultSet.close();
            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return entrenadoresList;
    }

    private void llenarTabla(){
        ObservableList<Map> lista = todosEntrenadores();

        this.cmCantidadEspecialidad.setCellValueFactory(new MapValueFactory(coCantidadEspecialidad));
        this.cmNombreCompletp.setCellValueFactory(new MapValueFactory(coNombreEntrenador));

        this.tblEntrenadorPokemon.setItems(lista);
    }

}
