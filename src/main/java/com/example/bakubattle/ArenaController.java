package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class ArenaController{


    /***************************** Player selection attributes *****************************/

    /* Status attributes */
    @FXML
    private Button start_game_button;
    @FXML
    private Label waiting;
    @FXML
    private Label ready;

    /* Team handling attributes*/
    @FXML
    private Button send_teamA_button;
    @FXML
    private Button send_teamB_button;
    @FXML
    private Label player1A;
    @FXML
    private Label player2A;
    @FXML
    private Label player1B;
    @FXML
    private Label player2B;
    @FXML
    private TextField textfieldA;
    @FXML
    private TextField textfieldB;
    /***************************** Player selection attributes ends *****************************/

//    private final static int ROUND_DAMAGE = 100;
//    private static int rounds_counter = 0;
    private final Team teamA = new Team();
    private final Team teamB = new Team();


    /***************************** Player selection methods *****************************/
    @FXML
    public void startingGame() throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("team_view.fxml")));
        Stage window = (Stage) start_game_button.getScene().getWindow();
        window.setScene(new Scene(root,1920, 1080));
    }

    @FXML
    public void actionSendA(){
        String text = textfieldA.getText();
        if(player1A.getOpacity() == 0){
            player1A.setOpacity(1);
            player1A.setText(text);
            teamA.setPlayer1(new Player(text));
        }
        else{
            player2A.setOpacity(1);
            player2A.setText(text);
            teamA.setPlayer2(new Player(text));
            send_teamA_button.setDisable(true);
            if(send_teamB_button.isDisable()){
                waiting.setOpacity(0);
                ready.setOpacity(1);
                start_game_button.setDisable(false);
            }
        }
        textfieldA.clear();
    }

    @FXML
    public void actionSendB(){
        String text = textfieldB.getText();
        if(player1B.getOpacity() == 0){
            player1B.setOpacity(1);
            player1B.setText(text);
            teamB.setPlayer1(new Player(text));
        }
        else{
            player2B.setOpacity(1);
            player2B.setText(text);
            teamB.setPlayer2(new Player(text));
            send_teamB_button.setDisable(true);
            if(send_teamA_button.isDisable()){
                waiting.setOpacity(0);
                ready.setOpacity(1);
                start_game_button.setDisable(false);
            }
        }
        textfieldB.clear();
    }

    /***************************** Player selection methods ends *****************************/
}