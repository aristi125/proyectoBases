package co.edu.proyectobases.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.edu.proyectobases.dao.PersonaDAO;
import co.edu.proyectobases.model.Persona;
import co.edu.proyectobases.utils.ConexionBaseDatos;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javafx.util.Callback;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PersonaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DateFechaNaci;

    @FXML
    private Button btn;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<?, ?> cmBarrio;

    @FXML
    private TableColumn<?, ?> cmCalle;

    @FXML
    private TableColumn<?, ?> cmCarrera;

    @FXML
    private TableColumn<?, ?> cmCasa;

    @FXML
    private TableColumn<?, ?> cmCodigo;

    @FXML
    private TableColumn<?, ?> cmFechaNaci;

    @FXML
    private TableColumn<?, ?> cmPrimeApe;

    @FXML
    private TableColumn<?, ?> cmPrimerNom;

    @FXML
    private TableColumn<?, ?> cmSegundoApe;

    @FXML
    private TableColumn<?, ?> cmSegundoNom;

    @FXML
    private TableView<Map> tblPersona;

    @FXML
    private TextField txtBarrio;

    @FXML
    private TextField txtCalle;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtCasa;

    @FXML
    private TextField txtCodigoPersona;

    @FXML
    private TextField txtFiltrar;

    @FXML
    private TextField txtPrimerApe;

    @FXML
    private TextField txtPrimerNom;

    @FXML
    private TextField txtSegundoApe;

    @FXML
    private TextField txtSegundoNom;

    private Stage stage;
    private  ObservableList<Persona> personasView;
    Connection conn = ConexionBaseDatos.getInstance().getConnection();


    private final String coCodigo = "cmCodigo";
    private final String coPrimerNom = "cmPrimerNom";
    private final String coSegundoNom = "cmSegundoNom";
    private final String coPrimerApellido = "cmPrimerApe";
    private final String coSegundoApellido = "cmSegundoApe";
    private final String coFechaNaci = "cmFechaNaci";
    private final String coBarrio = "cmBarrio";
    private final String coCalle = "cmCalle";
    private final String coCasa = "cmCasa";
    private final String coCarrera = "cmCarrera";


    PersonaDAO personaDAO = new PersonaDAO();

    @FXML
    void evenActioEliminar(ActionEvent event) {


        if(!txtCodigoPersona.getText().isEmpty()){
            personaDAO.eliminarPersona(Integer.parseInt(txtCodigoPersona.getText()));

            tblPersona.getItems().clear();
            llenarTabla();
        }

    }

    @FXML
    void evenActionAgregar(ActionEvent event) throws ParseException, SQLException {

        try {

                System.out.println("Boton Agregar presionado");

                personaDAO.agregar(
                        Integer.parseInt(txtCodigoPersona.getText()),
                        txtPrimerNom.getText(),
                        txtSegundoNom.getText(),
                        txtPrimerApe.getText(),
                        txtSegundoApe.getText(),
                        DateFechaNaci.getValue().toString(),
                        txtCalle.getText(),
                        txtCasa.getText(),
                        txtCarrera.getText(),
                        txtBarrio.getText()
                );

                System.out.println("Persona agregada correctamente");

                tblPersona.getItems().clear();
                llenarTabla();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al agregar persona: " + e.getMessage());
        }

    }

    @FXML
    void evenActionAtras(ActionEvent event) throws SQLException {
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
            tblPersona.getItems().clear();

            ObservableList<Map> lista = buscarPersonasPorPrimerNombre(txtFiltrar.getText());

            this.cmCodigo.setCellValueFactory(new MapValueFactory("cod"));
            this.cmPrimerNom.setCellValueFactory(new MapValueFactory("primerNombre"));
            this.cmSegundoNom.setCellValueFactory(new MapValueFactory("segundoNombre"));
            this.cmPrimeApe.setCellValueFactory(new MapValueFactory("primerApellido"));
            this.cmSegundoApe.setCellValueFactory(new MapValueFactory("segundoApellido"));
            this.cmFechaNaci.setCellValueFactory(new MapValueFactory("fechaNacimiento"));
            this.cmCarrera.setCellValueFactory(new MapValueFactory("carrera"));
            this.cmCalle.setCellValueFactory(new MapValueFactory("calle"));
            this.cmBarrio.setCellValueFactory(new MapValueFactory("barrio"));
            this.cmCasa.setCellValueFactory(new MapValueFactory("casa"));
            tblPersona.setItems(lista);
        }
    }


    public ObservableList<Map> buscarPersonasPorPrimerNombre(String primerNombre){

        ObservableList<Map> personas = FXCollections.observableArrayList();

        try {
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();

            String sql = "SELECT * FROM persona WHERE primerNombre = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, primerNombre);

            ResultSet resultSet = consulta.executeQuery();

            while(resultSet.next()){

                Map<String, Object> row = new HashMap<>();

                row.put("cod", resultSet.getInt("cod"));
                row.put("primerNombre", resultSet.getString("primerNombre"));
                row.put("segundoNombre", resultSet.getString("segundoNombre"));
                row.put("primerApellido", resultSet.getString("primerApellido"));
                row.put("segundoApellido", resultSet.getString("segundoApellido"));
                row.put("fechaNacimiento", resultSet.getDate("fechaNacimiento"));
                row.put("calle", resultSet.getString("calle"));
                row.put("casa", resultSet.getString("casa"));
                row.put("carrera", resultSet.getString("carrera"));
                row.put("barrio", resultSet.getString("barrio"));
                // agregar otros campos...

                personas.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;

    }

    @FXML
    void evenKey(KeyEvent event) {

    }

    public ObservableList<Persona> personaView(){
        ObservableList<Persona> personas = FXCollections.observableArrayList();
        personas.addAll(personaDAO.consultarTodos());
        return personas;
    }

    @FXML
    void initialize() {
        assert DateFechaNaci != null : "fx:id=\"DateFechaNaci\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'Persona.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmBarrio != null : "fx:id=\"cmBarrio\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCalle != null : "fx:id=\"cmCalle\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCarrera != null : "fx:id=\"cmCarrera\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCasa != null : "fx:id=\"cmCasa\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmCodigo != null : "fx:id=\"cmCodigo\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmFechaNaci != null : "fx:id=\"cmFechaNaci\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmPrimeApe != null : "fx:id=\"cmPrimeApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmPrimerNom != null : "fx:id=\"cmPrimerNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmSegundoApe != null : "fx:id=\"cmSegundoApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert cmSegundoNom != null : "fx:id=\"cmSegundoNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert tblPersona != null : "fx:id=\"tblPersona\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtBarrio != null : "fx:id=\"txtBarrio\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCalle != null : "fx:id=\"txtCalle\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCarrera != null : "fx:id=\"txtCarrera\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCasa != null : "fx:id=\"txtCasa\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtCodigoPersona != null : "fx:id=\"txtCodigoPersona\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtFiltrar != null : "fx:id=\"txtFiltrar\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtPrimerApe != null : "fx:id=\"txtPrimerApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtPrimerNom != null : "fx:id=\"txtPrimerNom\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtSegundoApe != null : "fx:id=\"txtSegundoApe\" was not injected: check your FXML file 'Persona.fxml'.";
        assert txtSegundoNom != null : "fx:id=\"txtSegundoNom\" was not injected: check your FXML file 'Persona.fxml'.";

           // personasView = FXCollections.observableArrayList();


    }

    public void setStage(Stage stage) {
        this.stage =  stage;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
        //stop();
    }

    public ObservableList<Map> todasPersona(){
        var sql = "SELECT * FROM persona";

        ObservableList<Map> personasList = FXCollections.observableArrayList();
        try{
            Connection conexion = ConexionBaseDatos.getInstance().getConnection();
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultSet = consulta.executeQuery();
            while (resultSet.next()){

                Persona persona = new Persona();
                Map<String, Object> coleccion = new HashMap<>();
                persona.setCod(Integer.parseInt(resultSet.getString("cod")));
                persona.setPrimerNombre(resultSet.getString("primerNombre"));
                persona.setSegundoNombre(resultSet.getString("segundoNombre"));
                persona.setPrimerApellido(resultSet.getString("primerApellido"));
                persona.setSegundoApellido(resultSet.getString("segundoApellido"));

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                persona.setFechaNacimiento(formato.parse(resultSet.getString("fechaNacimiento")));

                persona.setCarrera(resultSet.getString("carrera"));
                persona.setCalle(resultSet.getString("calle"));
                persona.setBarrio(resultSet.getString("barrio"));

                //// Agregar al ObservableList

                coleccion.put(coCodigo,String.valueOf(persona.getCod()));
                coleccion.put(coPrimerNom,persona.getPrimerNombre());
                coleccion.put(coSegundoNom,persona.getSegundoNombre());
                coleccion.put(coPrimerApellido,persona.getPrimerApellido());
                coleccion.put(coSegundoApellido,persona.getSegundoApellido());
                coleccion.put(coFechaNaci,persona.getFechaNacimiento());
                coleccion.put(coCarrera,persona.getCarrera());
                coleccion.put(coCalle,persona.getCalle());
                coleccion.put(coBarrio,persona.getBarrio());
                coleccion.put(coCasa,persona.getCasa());

                personasList.add(coleccion);

            }

            //resultSet.close();
            consulta.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return personasList;
    }

    private void llenarTabla(){
        ObservableList<Map> lista = todasPersona();


        this.cmCodigo.setCellValueFactory(new MapValueFactory(coCodigo));
        this.cmPrimerNom.setCellValueFactory(new MapValueFactory(coPrimerNom));
        this.cmSegundoNom.setCellValueFactory(new MapValueFactory(coSegundoNom));
        this.cmPrimeApe.setCellValueFactory(new MapValueFactory(coPrimerApellido));
        this.cmSegundoApe.setCellValueFactory(new MapValueFactory(coSegundoApellido));
        this.cmFechaNaci.setCellValueFactory(new MapValueFactory(coFechaNaci));
        this.cmCarrera.setCellValueFactory(new MapValueFactory(coCarrera));
        this.cmCalle.setCellValueFactory(new MapValueFactory(coCalle));
        this.cmBarrio.setCellValueFactory(new MapValueFactory(coBarrio));
        this.cmCasa.setCellValueFactory(new MapValueFactory(coCasa));

        this.tblPersona.setItems(lista);
    }

    public void stop() {
        try {
            ConexionBaseDatos.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
