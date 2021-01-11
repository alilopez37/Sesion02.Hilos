package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.model.Coordenada;
import main.model.Pelota;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    private Circle circle;

    @FXML
    private AnchorPane canvas;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnIniciar;

    @FXML
    void btnIniciarONMouseClicked(MouseEvent event) {
        Pelota pelota = new Pelota();
        pelota.addObserver(this);

        Thread hilo = new Thread(pelota);
        hilo.setDaemon(true);
        hilo.start();

    }

    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    public void initialize(){
        circle = new Circle(300,200,10, Color.RED);
        canvas.getChildren().add(circle);
    }

    @Override
    public void update(Observable o, Object arg) {
        Coordenada punto = (Coordenada)arg;

        circle.setCenterX(punto.x);
        circle.setCenterY(punto.y);
    }
}
