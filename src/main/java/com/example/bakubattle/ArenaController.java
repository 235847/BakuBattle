package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController implements Initializable{

    @FXML
    private Button send1;
    @FXML
    private Button send2;
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
    @FXML
    private Label waiting;
    @FXML
    private Label ready;

//    private final static int ROUND_DAMAGE = 100;
//    private static int rounds_counter = 0;
    private final Team teamA = new Team();
    private final Team teamB = new Team();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void setSend1(){
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
            send1.setDisable(true);
            if(send2.isDisable()){
                waiting.setOpacity(0);
                ready.setOpacity(1);
            }
        }
    }

    @FXML
    public void setSend2(){
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
            send2.setDisable(true);
            if(send1.isDisable()){
                waiting.setOpacity(0);
                ready.setOpacity(1);
            }
        }
    }
}