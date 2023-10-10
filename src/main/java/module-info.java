module co.edu.proyectobases {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens co.edu.proyectobases to javafx.fxml;
    exports co.edu.proyectobases;
    exports co.edu.proyectobases.controllers;
    opens co.edu.proyectobases.controllers to javafx.fxml;
}