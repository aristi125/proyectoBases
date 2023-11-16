package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class ClaseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmCantidadClase;

    @FXML
    private TableColumn<?, ?> cmNombreCliente;

    @FXML
    private TableView<Map> tblClase;

    @FXML
    private TextField txtFiltrar;
    private Stage stage;

    private final String coCantidadClase = "cmNombreClase";
    private final String coNombreCliente = "cmNombreCliente";

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
        if(txtFiltrar.getText().isEmpty()){
            llenarTabla();
        } else {
            tblClase.getItems().clear();

            ObservableList<Map> lista = buscarClasePorCliente(txtFiltrar.getText());

            this.cmNombreCliente.setCellValueFactory(new MapValueFactory(coNombreCliente));
            this.cmCantidadClase.setCellValueFactory(new MapValueFactory(coCantidadClase));

            tblClase.setItems(lista);
        }
    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmCantidadClase != null : "fx:id=\"cmNombreClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert cmNombreCliente != null : "fx:id=\"cmNombreCliente\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert tblClase != null : "fx:id=\"tblClase\" was not injected: check your FXML file 'clase-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'clase-view.fxml'.";

    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
    }

    public ObservableList<Map> buscarClasePorCliente(String nombre){
        ObservableList<Map> clasesList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            String sql = "SELECT\n" +
                    "(p.primernombre || ' ' || p.primerapellido)AS nombre_cliente,\n" +
                    "(\n" +
                    "        SELECT COUNT(DISTINCT rc.clase_codclase)" +
                    "FROM rutinaclase rc\n" +
                    "WHERE rc.rutina_codrutina IN (\n" +
                    "SELECT DISTINCT r.codrutina\n"+
                    "FROM rutina r\n" +
                    "WHERE r.nombre IS NOT NULL\n" +
                    ")\n" +
                    "AND rc.clase_codclase IN (\n" +
                    "SELECT DISTINCT cl.codclase\n" +
                    "FROM clase cl\n" +
                    "WHERE cl.nombre IS NOT NULL\n" +
                    ")\n" +
                    "AND rc.clase_codclase = (\n" +
                    "SELECT MAX(rcl.clase_codclase)\n" +
                    "FROM rutinaclase rcl\n" +
                    "WHERE rcl.rutina_codrutina = rc.rutina_codrutina\n" +
                    ")\n" +
                    ") AS clases_asistidas\n" +
                    "FROM cliente c\n" +
                    "JOIN persona p ON c.persona_cod = p.cod\n" +
                    "WHERE p.primernombre || ' ' || p.primerapellido = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombre);

            ResultSet resultSet = consulta.executeQuery();

            while (resultSet.next()) {

                Map<String, Object> coleccion = new HashMap<>();

                coleccion.put(coNombreCliente,resultSet.getString("nombre_cliente"));
                coleccion.put(coCantidadClase,resultSet.getString("clases_asistidas"));

                clasesList.add(coleccion);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return clasesList;
    }

    private ObservableList<Map> todasClases() {

        var sql = "SELECT\n" +
        "(p.primernombre || ' ' || p.primerapellido)AS nombre_cliente," +
        "(\n" +
        "        SELECT COUNT(DISTINCT rc.clase_codclase)\n" +
        "FROM rutinaclase rc\n" +
        "WHERE rc.rutina_codrutina IN (\n" +
                "SELECT DISTINCT r.codrutina\n"+
        "FROM rutina r\n" +
        "WHERE r.nombre IS NOT NULL\n" +
        ")\n" +
        "AND rc.clase_codclase IN (\n" +
                "SELECT DISTINCT cl.codclase\n" +
        "FROM clase cl\n" +
        "WHERE cl.nombre IS NOT NULL\n" +
        ")\n" +
        "AND rc.clase_codclase = (\n" +
                "SELECT MAX(rcl.clase_codclase)\n" +
        "FROM rutinaclase rcl\n" +
        "WHERE rcl.rutina_codrutina = rc.rutina_codrutina\n" +
        ")\n" +
    ") AS clases_asistidas\n" +
        "FROM cliente c\n" +
        "JOIN persona p ON c.persona_cod = p.cod";

        ObservableList<Map> clasesList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                Map<String, Object> coleccion = new HashMap<>();

                coleccion.put(coNombreCliente,resultSet.getString("nombre_cliente"));
                coleccion.put(coCantidadClase,resultSet.getString("clases_asistidas"));

                clasesList.add(coleccion);

            }

            //resultSet.close();
            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return clasesList;

    }

    private void llenarTabla(){
        ObservableList<Map> lista = todasClases();

        this.cmNombreCliente.setCellValueFactory(new MapValueFactory(coNombreCliente));
        this.cmCantidadClase.setCellValueFactory(new MapValueFactory(coCantidadClase));

        this.tblClase.setItems(lista);

    }
}
