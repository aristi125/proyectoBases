package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.proyectobases.model.GrupoMuscular;
import co.edu.proyectobases.model.Maquina;
import co.edu.proyectobases.model.Rutina;
import co.edu.proyectobases.utils.ConexionBaseDatos;
import jakarta.persistence.criteria.CriteriaBuilder;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GrupoMuscularController implements Initializable {

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
    private Button btnEliminar;

    @FXML
    private TableColumn<?, ?> cmCodMaquina;

    @FXML
    private TableColumn<?, ?> cmCodRutina;

    @FXML
    private TableColumn<?, ?> cmCodigoMusculo;

    @FXML
    private TableColumn<?, ?> cmNombreMaquina;

    @FXML
    private TableColumn<?, ?> cmNombreMusculo;

    @FXML
    private TableColumn<?, ?> cmNombreRutina;

    @FXML
    private TableView<Map> tblGrupoMuscular;

    @FXML
    private ComboBox<String> comb;

    @FXML
    private TextField txtCodMaquina;
    @FXML
    private TextField txtCodRutina;

    @FXML
    private TextField txtCodigoMusculo;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtMaquina;

    @FXML
    private TextField txtMusculo;

    @FXML
    private TextField txtRutina;


    private Stage stage;

    private final String coCodigo = "cmCodigo";
    private final String coMaquina = "cmMaquina";
    private final String coNombre = "cmNombre";
    private final String coRutina = "cmRutina";
    private final String coNombreRutina = "cmNombreRutina";
    private final String coNombreMaquina = "cmNombreMaquina";

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


        if (txtFiltrar.getText().isEmpty()) {
            llenarTabla();
        }
        else if (!comb.getSelectionModel().getSelectedItem().toString().equals("")) {
            System.out.println("Entro a la condicion");
            if (comb.getSelectionModel().getSelectedItem().toString().equals("Maquina")) {
                tblGrupoMuscular.getItems().clear();
                ObservableList<Map> lista = buscarPorNombreMaquina(txtFiltrar.getText());

                this.cmCodigoMusculo.setCellValueFactory(new MapValueFactory("codgrupomuscular"));
                this.cmNombreMusculo.setCellValueFactory(new MapValueFactory("nombre_grupomuscular"));
                this.cmCodMaquina.setCellValueFactory(new MapValueFactory("maquina_codmaquina"));
                this.cmCodRutina.setCellValueFactory(new MapValueFactory("rutina_codrutina"));
                this.cmNombreRutina.setCellValueFactory(new MapValueFactory("nombre_rutina"));
                this.cmNombreMaquina.setCellValueFactory(new MapValueFactory("nombre_maquina"));

                tblGrupoMuscular.setItems(lista);



            } else if (comb.getSelectionModel().getSelectedItem().toString().equals("Musculo")) {
                System.out.println("Se selecciono musculo");
                tblGrupoMuscular.getItems().clear();
                ObservableList<Map> lista = buscarPorNombreMuscular(txtFiltrar.getText());

                this.cmCodigoMusculo.setCellValueFactory(new MapValueFactory("codgrupomuscular"));
                this.cmNombreMusculo.setCellValueFactory(new MapValueFactory("nombre_grupomuscular"));
                this.cmCodMaquina.setCellValueFactory(new MapValueFactory("maquina_codmaquina"));
                this.cmCodRutina.setCellValueFactory(new MapValueFactory("rutina_codrutina"));
                this.cmNombreRutina.setCellValueFactory(new MapValueFactory("nombre_rutina"));
                this.cmNombreMaquina.setCellValueFactory(new MapValueFactory("nombre_maquina"));

                tblGrupoMuscular.setItems(lista);
                System.out.println(lista);

            } else if (comb.getSelectionModel().getSelectedItem().toString().equals("Rutina")) {
                tblGrupoMuscular.getItems().clear();
                ObservableList<Map> lista = buscarPorNombreRutina(txtFiltrar.getText());

                this.cmCodigoMusculo.setCellValueFactory(new MapValueFactory("codgrupomuscular"));
                this.cmNombreMusculo.setCellValueFactory(new MapValueFactory("nombre_grupomuscular"));
                this.cmCodMaquina.setCellValueFactory(new MapValueFactory("maquina_codmaquina"));
                this.cmCodRutina.setCellValueFactory(new MapValueFactory("rutina_codrutina"));
                this.cmNombreRutina.setCellValueFactory(new MapValueFactory("nombre_rutina"));
                this.cmNombreMaquina.setCellValueFactory(new MapValueFactory("nombre_maquina"));

                tblGrupoMuscular.setItems(lista);
            }
        }

        }







    @FXML
    void evenActionEliminar(ActionEvent event) {

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    @FXML
    void selectComb(ActionEvent event) {
        String combo = comb.getSelectionModel().getSelectedItem().toString();



    }

    @FXML
    void initialize() {
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmCodMaquina != null : "fx:id=\"cmCodMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmCodRutina != null : "fx:id=\"cmCodRutina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmCodigoMusculo != null : "fx:id=\"cmCodigoMusculo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmNombreMaquina != null : "fx:id=\"cmNombreMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmNombreMusculo != null : "fx:id=\"cmNombreMusculo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert cmNombreRutina != null : "fx:id=\"cmNombreRutina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert comb != null : "fx:id=\"comb\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert tblGrupoMuscular != null : "fx:id=\"tblGrupoMuscular\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtCodMaquina != null : "fx:id=\"txtCodMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtCodRutina != null : "fx:id=\"txtCodRutina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtCodigoMusculo != null : "fx:id=\"txtCodigoMusculo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtMaquina != null : "fx:id=\"txtMaquina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtMusculo != null : "fx:id=\"txtMusculo\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";
        assert txtRutina != null : "fx:id=\"txtRutina\" was not injected: check your FXML file 'grupoMuscular-view.fxml'.";

    }
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }


    public ObservableList<Map> todosGruposMusculares() {
        var sql = "SELECT " +
                "    gm.codgrupomuscular, " +
                "    gm.nombre AS nombre_grupomuscular, " +
                "    gm.maquina_codmaquina, " +
                "    m.nombre AS nombre_maquina, " +
                "    gm.rutina_codrutina, " +
                "    r.nombre AS nombre_rutina " +
                "FROM " +
                "    grupomuscular gm " +
                "JOIN " +
                "    maquina m ON gm.maquina_codmaquina = m.codmaquina " +
                "JOIN " +
                "    rutina r ON gm.rutina_codrutina = r.codrutina";

        ObservableList<Map> gruposmuscularesList = FXCollections.observableArrayList();
        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()) {
                GrupoMuscular grupoMuscular = new GrupoMuscular();
                Maquina maquina = new Maquina();
                Rutina rutina = new Rutina();

                Map<String, Object> coleccion = new HashMap<>();

                grupoMuscular.setCodGrupoMuscular(resultSet.getInt("codgrupomuscular"));
                grupoMuscular.setNombre(resultSet.getString("nombre_grupomuscular"));
                grupoMuscular.setFk_cod_maquina(resultSet.getInt("maquina_codmaquina"));
                grupoMuscular.setFk_cod_rutina(resultSet.getInt("rutina_codrutina"));

                maquina.setCodMaquina(resultSet.getInt("maquina_codmaquina"));
                maquina.setNombre(resultSet.getString("nombre_maquina"));

                rutina.setCodRutina(resultSet.getInt("rutina_codrutina"));
                rutina.setNombre(resultSet.getString("nombre_rutina"));

                //// Agregar al ObservableList

                coleccion.put(coCodigo, String.valueOf(grupoMuscular.getCodGrupoMuscular()));
                coleccion.put(coNombre, grupoMuscular.getNombre());
                coleccion.put(coMaquina, maquina.getCodMaquina()); // Cambié a obtener el nombre de la máquina
                coleccion.put(coRutina, rutina.getCodRutina()); // Cambié a obtener el nombre de la ruti
                coleccion.put(coNombreRutina,rutina.getNombre());
                coleccion.put(coNombreMaquina, maquina.getNombre());


                gruposmuscularesList.add(coleccion);
            }

            consulta.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gruposmuscularesList;
    }

    private void llenarTabla(){
        ObservableList<Map> lista = todosGruposMusculares();

        this.cmCodigoMusculo.setCellValueFactory(new MapValueFactory(coCodigo));
        this.cmNombreMusculo.setCellValueFactory(new MapValueFactory(coNombre));
        this.cmCodMaquina.setCellValueFactory(new MapValueFactory(coMaquina));
        this.cmCodRutina.setCellValueFactory(new MapValueFactory(coRutina));
        this.cmNombreRutina.setCellValueFactory(new MapValueFactory(coNombreRutina));
        this.cmNombreMaquina.setCellValueFactory(new MapValueFactory(coNombreMaquina));


        this.tblGrupoMuscular.setItems(lista);
    }

    private void llenarCombo(){
        ObservableList<String> lista = FXCollections.observableArrayList("Musculo","Maquina", "Rutina");
        comb.setItems(lista);
    }


    public ObservableList<Map> buscarPorNombreMuscular(String nombreMuscular) {
        var sql = "SELECT " +
                "    gm.codgrupomuscular, " +
                "    gm.nombre AS nombre_grupomuscular, " +
                "    gm.maquina_codmaquina, " +
                "    m.nombre AS nombre_maquina, " +
                "    gm.rutina_codrutina, " +
                "    r.nombre AS nombre_rutina " +
                "FROM " +
                "    grupomuscular gm " +
                "JOIN " +
                "    maquina m ON gm.maquina_codmaquina = m.codmaquina " +
                "JOIN " +
                "    rutina r ON gm.rutina_codrutina = r.codrutina " +
                "WHERE " +
                "    gm.nombre = ?";

        ObservableList<Map> gruposmuscularesList = FXCollections.observableArrayList();
        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // Configurar el parámetro en la consulta
            consulta.setString(1, nombreMuscular);

            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()) {

                Map<String, Object> row = new HashMap<>();

                row.put("codgrupomuscular",resultSet.getInt("codgrupomuscular"));
                row.put("nombre_grupomuscular",resultSet.getString("nombre_grupomuscular"));
                row.put("maquina_codmaquina",resultSet.getInt("maquina_codmaquina"));
                row.put("rutina_codrutina",resultSet.getInt("rutina_codrutina"));
                row.put("nombre_maquina",resultSet.getString("nombre_maquina"));
                row.put("nombre_rutina",resultSet.getString("nombre_rutina"));

                gruposmuscularesList.add(row);
            }

            consulta.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gruposmuscularesList;
    }


    public ObservableList<Map> buscarPorNombreRutina(String nombreRutina) {
        var sql = "SELECT " +
                "    gm.codgrupomuscular, " +
                "    gm.nombre AS nombre_grupomuscular, " +
                "    gm.maquina_codmaquina, " +
                "    m.nombre AS nombre_maquina, " +
                "    gm.rutina_codrutina, " +
                "    r.nombre AS nombre_rutina " +
                "FROM " +
                "    grupomuscular gm " +
                "JOIN " +
                "    maquina m ON gm.maquina_codmaquina = m.codmaquina " +
                "JOIN " +
                "    rutina r ON gm.rutina_codrutina = r.codrutina " +
                "WHERE " +
                "    r.nombre = ?";

        ObservableList<Map> gruposmuscularesList = FXCollections.observableArrayList();
        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // Configurar el parámetro en la consulta
            consulta.setString(1, nombreRutina);

            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();

                row.put("codgrupomuscular",resultSet.getInt("codgrupomuscular"));
                row.put("nombre_grupomuscular",resultSet.getString("nombre_grupomuscular"));
                row.put("maquina_codmaquina",resultSet.getInt("maquina_codmaquina"));
                row.put("rutina_codrutina",resultSet.getInt("rutina_codrutina"));
                row.put("nombre_maquina",resultSet.getString("nombre_maquina"));
                row.put("nombre_rutina",resultSet.getString("nombre_rutina"));

                gruposmuscularesList.add(row);
            }

            consulta.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gruposmuscularesList;
    }


    public ObservableList<Map> buscarPorNombreMaquina(String nombreMaquina) {
        var sql = "SELECT " +
                "    gm.codgrupomuscular, " +
                "    gm.nombre AS nombre_grupomuscular, " +
                "    gm.maquina_codmaquina, " +
                "    m.nombre AS nombre_maquina, " +
                "    gm.rutina_codrutina, " +
                "    r.nombre AS nombre_rutina " +
                "FROM " +
                "    grupomuscular gm " +
                "JOIN " +
                "    maquina m ON gm.maquina_codmaquina = m.codmaquina " +
                "JOIN " +
                "    rutina r ON gm.rutina_codrutina = r.codrutina " +
                "WHERE " +
                "    m.nombre = ?";

        ObservableList<Map> gruposmuscularesList = FXCollections.observableArrayList();
        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);

            // Configurar el parámetro en la consulta
            consulta.setString(1, nombreMaquina);

            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();

                row.put("codgrupomuscular",resultSet.getInt("codgrupomuscular"));
                row.put("nombre_grupomuscular",resultSet.getString("nombre_grupomuscular"));
                row.put("maquina_codmaquina",resultSet.getInt("maquina_codmaquina"));
                row.put("rutina_codrutina",resultSet.getInt("rutina_codrutina"));
                row.put("nombre_maquina",resultSet.getString("nombre_maquina"));
                row.put("nombre_rutina",resultSet.getString("nombre_rutina"));

                gruposmuscularesList.add(row);
            }

            consulta.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gruposmuscularesList;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
        llenarCombo();
    }
}
