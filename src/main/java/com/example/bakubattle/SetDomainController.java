package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class SetDomainController {

    /* Domain's attributes */
    @FXML
    private Button pyrus_button;
    @FXML
    private Button ventus_button;
    @FXML
    private Button aquos_button;
    @FXML
    private Button darkus_button;
    @FXML
    private Button haos_button;
    @FXML
    private Button subterra_button;


    /* Setting the domain for the players and going to the champ select*/
    public void setDomain(ActionEvent actionEvent){
        Parent root = null;
        try{
            /* Choosing his domain and preparing to jump to the next scene*/
            int i;
            if(actionEvent.getSource() == pyrus_button){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Serpenteze.fxml")));
                i = 0;
            }
            else if(actionEvent.getSource() == ventus_button){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Serpillious.fxml")));
                i = 1;
            }
            else if(actionEvent.getSource() == aquos_button){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("aquos.fxml")));
                i = 2;
            }
            else if(actionEvent.getSource() == darkus_button){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Nillious.fxml")));
                i = 3;
            }
            else if(actionEvent.getSource() == haos_button){
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sairus.fxml")));
                i = 4;
            }
            else{
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Auxillataur.fxml")));
                i = 5;
            }

            /* Binding the domain with the player */
            switch (PassingClass.getInstance().getWho_select()) {
                case "player1A" -> PassingClass.getInstance().getTeamA().getPlayer1().setDomain(new Domain(Domain.NAMES[i]));
                case "player2A" -> PassingClass.getInstance().getTeamA().getPlayer2().setDomain(new Domain(Domain.NAMES[i]));
                case "player1B" -> PassingClass.getInstance().getTeamB().getPlayer1().setDomain(new Domain(Domain.NAMES[i]));
                default -> PassingClass.getInstance().getTeamB().getPlayer2().setDomain(new Domain(Domain.NAMES[i]));
            }

            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setFullScreen(true);
            window.setScene(new Scene(root,1920, 1080));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(Error.DOMAIN_SELECT + "\n"+ Error.LOADING_SCENE);
        }
    }
}
