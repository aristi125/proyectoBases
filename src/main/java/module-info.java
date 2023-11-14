module co.edu.proyectobases {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    requires java.sql;
    requires lombok;
    requires jakarta.persistence;
    requires java.desktop;
    requires com.oracle.database.jdbc;

    opens co.edu.proyectobases.controllers to javafx.fxml;
    opens co.edu.proyectobases to javafx.fxml;

    exports co.edu.proyectobases.model;
    //exports co.edu.proyectobases.test;
    exports co.edu.proyectobases.repository;
    exports co.edu.proyectobases.utils;
    exports co.edu.proyectobases;
    exports co.edu.proyectobases.controllers;
}