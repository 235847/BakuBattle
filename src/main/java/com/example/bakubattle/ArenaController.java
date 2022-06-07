package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.runtime.SwitchBootstraps;
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

    /* Stategy attributes */
    @FXML
    private Label enter_label;
    @FXML
    private Button first_card_button;
    @FXML
    private Button second_card_button;
    @FXML
    private Button third_card_button;
    @FXML
    private ImageView first_card_imageview;
    @FXML
    private ImageView second_card_imageview;
    @FXML
    private ImageView third_card_imageview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        URL player1A_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer1().getDomain().getName()+".png");
        URL player2A_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamA().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamA().getPlayer2().getDomain().getName()+".png");
        URL player1B_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer1().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer1().getDomain().getName()+".png");
        URL player2B_setImage = getClass().getResource("arena/bakugan/"+PassingClass.getInstance().getTeamB().getPlayer2().getBakugan().getName()+"_"+PassingClass.getInstance().getTeamB().getPlayer2().getDomain().getName()+".png");
        player1A_imageview.setImage(new Image(String.valueOf(player1A_setImage)));
        player2A_imageview.setImage(new Image(String.valueOf(player2A_setImage)));
        player1B_imageview.setImage(new Image(String.valueOf(player1B_setImage)));
        player2B_imageview.setImage(new Image(String.valueOf(player2B_setImage)));
        enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer1().getName()+"):");
    }

    public void selectAbility(ActionEvent event){
        if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer1().getName()+"):")){
            enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):");
            if(event.getSource() == first_card_button){
                PassingClass.getInstance().getTeamA().getPlayer1().getForbidden_card().activate();
            }
            else if(event.getSource() == second_card_button){
                PassingClass.getInstance().getTeamA().getPlayer1().getOpen_card().activate();
            }
            else{
                PassingClass.getInstance().getTeamA().getPlayer1().getDomain().activate();
            }
        }
        else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamA().getPlayer2().getName()+"):")){
            enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):");
            if(event.getSource() == first_card_button){
                PassingClass.getInstance().getTeamA().getPlayer2().getForbidden_card().activate();
            }
            else if(event.getSource() == second_card_button){
                PassingClass.getInstance().getTeamA().getPlayer2().getOpen_card().activate();
            }
            else{
                PassingClass.getInstance().getTeamA().getPlayer2().getDomain().activate();
            }
        }
        else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer1().getName()+"):")){
            enter_label.setText("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):");
            if(event.getSource() == first_card_button){
                PassingClass.getInstance().getTeamB().getPlayer1().getForbidden_card().activate();
            }
            else if(event.getSource() == second_card_button){
                PassingClass.getInstance().getTeamB().getPlayer1().getOpen_card().activate();
            }
            else{
                PassingClass.getInstance().getTeamB().getPlayer1().getDomain().activate();
            }
        }
        else if(enter_label.getText().equals("Let's choose strategy for this game ("+PassingClass.getInstance().getTeamB().getPlayer2().getName()+"):")){
            enter_label.setText("Let's move "+PassingClass.getInstance().getTeamA().getPlayer1().getName()+":");
            if(event.getSource() == first_card_button){
                PassingClass.getInstance().getTeamB().getPlayer2().getForbidden_card().activate();
            }
            else if(event.getSource() == second_card_button){
                PassingClass.getInstance().getTeamB().getPlayer2().getOpen_card().activate();
            }
            else{
                PassingClass.getInstance().getTeamB().getPlayer2().getDomain().activate();
            }
        }
        else if(enter_label.getText().equals("Let's move "+PassingClass.getInstance().getTeamA().getPlayer1().getName()+":")){

        }
    }
}