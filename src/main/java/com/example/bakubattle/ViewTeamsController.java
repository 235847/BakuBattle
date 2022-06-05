package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewTeamsController implements Initializable {

    /* Player 1A attributes */
    @FXML
    private Label player1A_name;
    @FXML
    private ImageView player1A_blue_select_image;
    @FXML
    private Button player1A_select_button;

    /* Player 2A attributes */
    @FXML
    private Label player2A_name;
    @FXML
    private ImageView player2A_blue_select_image;
    @FXML
    private Button player2A_select_button;

    /* Player 1B attributes */
    @FXML
    private Label player1B_name;
    @FXML
    private ImageView player1B_red_select_image;
    @FXML
    private Button player1B_select_button;

    /* Player 2B attributes */
    @FXML
    private Label player2B_name;
    @FXML
    private ImageView player2B_red_select_image;
    @FXML
    private Button player2B_select_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1A_name.setText(PassingClass.getInstance().getTeamA().getPlayer1().getName());
        player2A_name.setText(PassingClass.getInstance().getTeamA().getPlayer2().getName());
        player1B_name.setText(PassingClass.getInstance().getTeamB().getPlayer1().getName());
        player2B_name.setText(PassingClass.getInstance().getTeamB().getPlayer2().getName());
        if()
    }

    public void showDomains(@NotNull ActionEvent event) throws Exception{
        if(event.getSource() == player1A_select_button){
            PassingClass.getInstance().setWho_select("player1A");
        }
        else if(event.getSource() == player2A_select_button){
            PassingClass.getInstance().setWho_select("player2A");
        }
        else if(event.getSource() == player1B_select_button){
            PassingClass.getInstance().setWho_select("player1B");
        }
        else{
            PassingClass.getInstance().setWho_select("player2B");
        }

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("domain_select.fxml")));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root,1920, 1080));
    }
}
