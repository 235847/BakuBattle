package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable {

    /* Player 1A attributes */
    @FXML
    private ImageView player1A_imageview;
    @FXML
    private  ProgressBar player1A_hp_bar;
    @FXML
    private ProgressBar player1A_xp_bar;
    @FXML
    private ImageView player1A_deck;

    /* Player 2A attributes */
    @FXML
    private ImageView player2A_imageview;
    @FXML
    private  ProgressBar player2A_hp_bar;
    @FXML
    private ProgressBar player2A_xp_bar;
    @FXML
    private ImageView player2A_deck;

    /* Player 1B attributes */
    @FXML
    private ImageView player1B_imageview;
    @FXML
    private  ProgressBar player1B_hp_bar;
    @FXML
    private ProgressBar player1B_xp_bar;
    @FXML
    private ImageView player1B_deck;

    /* Player 2A attributes */
    @FXML
    private ImageView player2B_imageview;
    @FXML
    private  ProgressBar player2B_hp_bar;
    @FXML
    private ProgressBar player2B_xp_bar;
    @FXML
    private ImageView player2B_deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}