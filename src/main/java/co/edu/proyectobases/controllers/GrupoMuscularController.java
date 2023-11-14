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

import co.edu.proyectobases.model.GrupoMuscular;
import co.edu.proyectobases.model.Persona;
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

    private Stage stage;

    private final String coCodigo = "cmCodigo";
    private final String coMaquina = "cmMaquina";
    private final String coNombre = "cmNombre";
    private final String coRutina = "cmRutina";

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
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }


    public ObservableList<Map> todosGruposMusculares(){
        var sql = "SELECT * FROM grupomuscular";

        ObservableList<Map> gruposmuscularesList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                GrupoMuscular grupoMuscular = new GrupoMuscular();
                Map<String, Object> coleccion = new HashMap<>();

                grupoMuscular.setCodGrupoMuscular(Integer.parseInt(resultSet.getString("codgrupomuscular")));
                grupoMuscular.setNombre(resultSet.getString("nombre"));
                grupoMuscular.setFk_cod_maquina(Integer.valueOf(resultSet.getString("maquina_codmaquina")));
                grupoMuscular.setFk_cod_rutina(Integer.valueOf(resultSet.getString("rutina_codrutina")));

                //// Agregar al ObservableList



                coleccion.put(coCodigo,String.valueOf(grupoMuscular.getCodGrupoMuscular()));
                coleccion.put(coNombre,grupoMuscular.getNombre());
                coleccion.put(coMaquina,grupoMuscular.getFk_cod_maquina());
                coleccion.put(coRutina,grupoMuscular.getFk_cod_rutina());

                gruposmuscularesList.add(coleccion);

            }

            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return gruposmuscularesList;
    }

    public ObservableList<Map> buscarGruposMuscularesPorCodigo(Integer codgrupomuscular){

        ObservableList<Map> gruposmusculares = FXCollections.observableArrayList();

        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();

            String sql = "SELECT * FROM grupomuscular WHERE codgrupomuscular = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, codgrupomuscular.toString());

            ResultSet resultSet = consulta.executeQuery();

            while(resultSet.next()){

                Map<String, Object> row = new HashMap<>();

                row.put("cod", resultSet.getInt("codgrupomuscular"));
                row.put("nombre", resultSet.getString("nombre"));
                row.put("maquina_codmaquina", resultSet.getInt("maquina_codmaquina"));
                row.put("rutina_codrutina", resultSet.getInt("rutina_codrutina"));

                gruposmusculares.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gruposmusculares;

    }
}
