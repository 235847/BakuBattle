package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetTeamsController {

    /* Status attributes */
    @FXML
    private Button start_game_button;
    @FXML
    private Label waiting;
    @FXML
    private Label ready;

    /* TeamA handling attributes*/
    @FXML
    private Label player1A;
    @FXML
    private Label player2A;
    @FXML
    private TextField textfieldA;
    @FXML
    private Button send_teamA_button;

    /* TeamB handling attributes*/
    @FXML
    private Label player1B;
    @FXML
    private Label player2B;
    @FXML
    private Button send_teamB_button;
    @FXML
    private TextField textfieldB;

    /*Clearing nicknames attributes*/
    @FXML
    private ImageView TeamA_X1;
    @FXML
    private ImageView TeamA_X2;
    @FXML
    private ImageView TeamB_X1;
    @FXML
    private ImageView TeamB_X2;
    @FXML
    private Button X1_btn_TeamA;
    @FXML
    private Button X2_btn_TeamA;
    @FXML
    private Button X1_btn_TeamB;
    @FXML
    private Button X2_btn_TeamB;

    /* Initializing the teams. */
    private final Team teamA = new Team();
    private final Team teamB = new Team();


    /* Handling action of the sending buttons */
    public void actionSend(ActionEvent event){
        try{
            String text;
            if(event.getSource() == send_teamA_button){                         //checking the source of the event
                text = textfieldA.getText();                                    //getting the text from the TextField
                if(player1A.getOpacity() == 0){                                 //checking the status of the Labels
                    player1A.setOpacity(1);
                    player1A.setText(text);
                    TeamA_X1.setOpacity(1);
                    teamA.setPlayer1(new Player(text));                          //adding players
                }
                else{
                    player2A.setOpacity(1);
                    player2A.setText(text);
                    TeamA_X2.setOpacity(1);
                    teamA.setPlayer2(new Player(text));
                    send_teamA_button.setDisable(true);
                    if(send_teamB_button.isDisable()){                          //checking if its the last missing player
                        waiting.setOpacity(0);                                   //handling communication with the users
                        ready.setOpacity(1);
                        start_game_button.setDisable(false);                     //starting the game available
                        PassingClass.getInstance().setTeamA(teamA);             //passing teams to our PassingClass
                        PassingClass.getInstance().setTeamB(teamB);
                    }
                }
                textfieldA.clear();                                             //clearing the TextField
            }
            else{
                text = textfieldB.getText();
                if(player1B.getOpacity() == 0){
                    player1B.setOpacity(1);
                    player1B.setText(text);
                    TeamB_X1.setOpacity(1);
                    teamB.setPlayer1(new Player(text));
                }
                else {
                    player2B.setOpacity(1);
                    player2B.setText(text);
                    TeamB_X2.setOpacity(1);
                    teamB.setPlayer2(new Player(text));
                    send_teamB_button.setDisable(true);
                    if (send_teamA_button.isDisable()) {
                        waiting.setOpacity(0);
                        ready.setOpacity(1);
                        start_game_button.setDisable(false);
                        PassingClass.getInstance().setTeamA(teamA);
                        PassingClass.getInstance().setTeamB(teamB);
                    }
                }
                textfieldB.clear();
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(Error.ADDING_PLAYERS);
        }
    }

    public void deleteNickname(ActionEvent event){
        if(event.getSource()==X1_btn_TeamA){
            player1A.setOpacity(0);
            TeamA_X1.setOpacity(0);
            waiting.setOpacity(1);
            ready.setOpacity(0);
            send_teamA_button.setDisable(false);
            start_game_button.setDisable(true);
        }
        else if(event.getSource()==X2_btn_TeamA){
            player2A.setOpacity(0);
            TeamA_X2.setOpacity(0);
            waiting.setOpacity(1);
            ready.setOpacity(0);
            send_teamA_button.setDisable(false);
            start_game_button.setDisable(true);
        }
        else if(event.getSource()==X1_btn_TeamB){
            player1B.setOpacity(0);
            TeamB_X1.setOpacity(0);
            waiting.setOpacity(1);
            ready.setOpacity(0);
            send_teamB_button.setDisable(false);
            start_game_button.setDisable(true);
        }
        else if(event.getSource()==X2_btn_TeamB){
            player2B.setOpacity(0);
            TeamB_X2.setOpacity(0);
            waiting.setOpacity(1);
            ready.setOpacity(0);
            send_teamB_button.setDisable(false);
            start_game_button.setDisable(true);
        }
    }

    /* Moving on to the next scene */
    public void startingGame(@NotNull ActionEvent event){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("team_view.fxml")));     //loading the next fxml file
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();                                //extracting our stage
            window.setFullScreen(true);
            window.setScene(new Scene(root,1920, 1080));                                                //setting new scene
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_SCENE);
        }
    }

}
