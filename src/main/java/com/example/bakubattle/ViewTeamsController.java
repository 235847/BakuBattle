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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewTeamsController implements Initializable {


    /* Temporary measure */
    @FXML
    private Button arena_start;

    /* Player 1A attributes */
    @FXML
    private Label player1A_name;
    @FXML
    private ImageView player1A_blue_select_image;
    @FXML
    private Button player1A_select_button;
    @FXML
    private Label player1A_selected;

    /* Player 2A attributes */
    @FXML
    private Label player2A_name;
    @FXML
    private ImageView player2A_blue_select_image;
    @FXML
    private Button player2A_select_button;
    @FXML
    private Label player2A_selected;

    /* Player 1B attributes */
    @FXML
    private Label player1B_name;
    @FXML
    private ImageView player1B_red_select_image;
    @FXML
    private Button player1B_select_button;
    @FXML
    private Label player1B_selected;

    /* Player 2B attributes */
    @FXML
    private Label player2B_name;
    @FXML
    private ImageView player2B_red_select_image;
    @FXML
    private Button player2B_select_button;
    @FXML
    private Label player2B_selected;

    @FXML
    private ImageView playBTN;


    /* Updating the scene by the data from previous Controller */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            /* Printing the names of the players. */
            player1A_name.setText(PassingClass.getInstance().getTeamA().getPlayer1().getName());
            player2A_name.setText(PassingClass.getInstance().getTeamA().getPlayer2().getName());
            player1B_name.setText(PassingClass.getInstance().getTeamB().getPlayer1().getName());
            player2B_name.setText(PassingClass.getInstance().getTeamB().getPlayer2().getName());

            /* Checking if player's selected their bakugans. */
            if(PassingClass.getInstance().getTeamA().getPlayer1().getBakugan() != null){
                player1A_selected.setOpacity(1);
                player1A_blue_select_image.setOpacity(0);
                player1A_select_button.setOpacity(0);
            }
            if(PassingClass.getInstance().getTeamA().getPlayer2().getBakugan() != null){
                player2A_selected.setOpacity(1);
                player2A_blue_select_image.setOpacity(0);
                player2A_select_button.setOpacity(0);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer1().getBakugan() != null){
                player1B_selected.setOpacity(1);
                player1B_red_select_image.setOpacity(0);
                player1B_select_button.setOpacity(0);
            }
            if(PassingClass.getInstance().getTeamB().getPlayer2().getBakugan() != null){
                player2B_selected.setOpacity(1);
                player2B_red_select_image.setOpacity(0);
                player2B_select_button.setOpacity(0);
            }

            /* If everyone has chosen his bakugan, there will be allowed to enter the arena. */
            if(player1A_selected.getOpacity() == 1 && player2A_selected.getOpacity() == 1 && player1B_selected.getOpacity() == 1 && player2B_selected.getOpacity() == 1){
                playBTN.setOpacity(1);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.UPDATING_SCENE);;
        }
    }

    /* Moving on to the Domain selection scene. */
    public void showDomains(@NotNull ActionEvent event) throws Exception{
        try{
            /* PassingClass's PASSER knows who is in the champ select right now */
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
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.WHO_IS_IN_CHAMP_SELECT);
        }

        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("domain_select.fxml")));
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setFullScreen(true);
            window.setScene(new Scene(root,1920, 1080));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_SCENE);
        }
    }


    /* Moving on to the Arena scene */
    public void switchScene(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Arena.fxml")));     //loading the next fxml file
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();                                //extracting our stage
            window.setFullScreen(true);
            window.setScene(new Scene(root,1920, 1080));                                                //setting new scene
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.LOADING_SCENE);
        }
    }
}
