package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    private final static int ROUND_DAMAGE = 100;
    private static int rounds_counter = 0;
    private Team teamA = new Team();
    private Team teamB = new Team();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}