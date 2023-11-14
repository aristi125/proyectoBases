package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.proyectobases.dao.AgendaDAO;
import co.edu.proyectobases.model.Agenda;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AgendaController implements Initializable {

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
    private TableView<Map> tblAgenda;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtId;
    private Stage stage;

    private final String coCodAgenda = "cmCodigoId";

    private final String coHoraInicio = "cmHoraInicio";
    private final String coHoraFin = "cmHoraFin";


    AgendaDAO agendaDAO = new AgendaDAO();
    @FXML
    void evenActionAgendar(ActionEvent event) throws SQLException {
        agendaDAO.agregarAgenda(Integer.parseInt(txtId.getText()), dateHoraInicio.getValue().toString(), dateHoraFinal.getValue().toString());

        tblAgenda.getItems().clear();
        llenarTabla();
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


        if(txtFiltrar.getText().isEmpty()){
            llenarTabla();
        }
        else {
            tblAgenda.getItems().clear();


            ObservableList<Map> lista = buscarAgendaPorCodigo(Integer.valueOf(txtFiltrar.getText()));

            this.cmCodigoId.setCellValueFactory(new MapValueFactory(coCodAgenda));
            this.cmHoraInicio.setCellValueFactory(new MapValueFactory(coHoraInicio));
            this.cmHoraFin.setCellValueFactory(new MapValueFactory(coHoraFin));

            this.tblAgenda.setItems(lista);
        }



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


    public ObservableList<Map> todasAgendas(){
        var sql = "SELECT * FROM agenda";

        ObservableList<Map> agendaList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                Agenda agenda = new Agenda();
                Map<String, Object> coleccion = new HashMap<>();

                agenda.setCodAgenda(resultSet.getInt("codAgenda"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                agenda.setHoraInicio(LocalDateTime.parse(resultSet.getString("horaInicio"), formatter));
                agenda.setHoraFinal(LocalDateTime.parse(resultSet.getString("horaFinalizacion"), formatter));

                //// Agregar al ObservableList



                coleccion.put(coCodAgenda,String.valueOf(agenda.getCodAgenda()));
                coleccion.put(coHoraInicio,agenda.getHoraInicio().toString());
                coleccion.put(coHoraFin,agenda.getHoraFinal().toString());
                agendaList.add(coleccion);


            }

            //resultSet.close();
            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return agendaList;
    }

    private void llenarTabla(){
        ObservableList<Map> lista = todasAgendas();


        this.cmCodigoId.setCellValueFactory(new MapValueFactory(coCodAgenda));
        this.cmHoraInicio.setCellValueFactory(new MapValueFactory(coHoraInicio));
        this.cmHoraFin.setCellValueFactory(new MapValueFactory(coHoraFin));

        this.tblAgenda.setItems(lista);
    }

    public ObservableList<Map> buscarAgendaPorCodigo(Integer codAgenda){

        ObservableList<Map> agendas = FXCollections.observableArrayList();

        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();

            String sql = "SELECT * FROM agenda WHERE codagenda = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, codAgenda);

            ResultSet resultSet = consulta.executeQuery();

            while(resultSet.next()){

                Map<String, Object> row = new HashMap<>();

                String fechaHoraInicio = resultSet.getString("horaInicio");
                String fechaHoraFin = resultSet.getString("horaFinalizacion");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                LocalDateTime horaInicio = LocalDateTime.parse(fechaHoraInicio, formatter);
                LocalDateTime horaFin = LocalDateTime.parse(fechaHoraFin, formatter);

                row.put("cmCodigoId", resultSet.getInt("codAgenda"));
                row.put("cmHoraInicio", horaInicio);
                row.put("cmHoraFin", horaFin);


                agendas.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendas;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
    }
}
