package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Objects;

public class BakuController {

    @FXML
    private Button apophix_button;
    @FXML
    private Button auxillataur_button;
    @FXML
    private Button sairus_button;
    @FXML
    private Button nillious_button;
    @FXML
    private Button serpenteze_button;
    @FXML
    private Button serpillious_button;



    public void setBakugan(ActionEvent actionEvent) throws Exception{
        int choice;
        if(actionEvent.getSource() == apophix_button){
            choice = 1;
        }
        else if(actionEvent.getSource() == auxillataur_button){
            choice = 25;
        }
        else if(actionEvent.getSource() == sairus_button){
            choice = 18;
        }
        else if(actionEvent.getSource() == nillious_button){
            choice = 10;
        }
        else if(actionEvent.getSource() == serpenteze_button){
            choice = 22;
        }
        else{
            choice = 32;
        }

        switch (PassingClass.getInstance().getWho_select()) {
            case "player1A" -> PassingClass.getInstance().getTeamA().getPlayer1().setBakugan(new Bakugan(choice));
            case "player2A" -> PassingClass.getInstance().getTeamA().getPlayer2().setBakugan(new Bakugan(choice));
            case "player1B" -> PassingClass.getInstance().getTeamB().getPlayer1().setBakugan(new Bakugan(choice));
            default -> PassingClass.getInstance().getTeamB().getPlayer2().setBakugan(new Bakugan(choice));
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("team_view.fxml")));
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root,1920, 1080));
    }
}
