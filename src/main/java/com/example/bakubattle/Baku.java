package com.example.bakubattle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

abstract class Baku {

    protected static final ArrayList<String> names_of_bakugans = new ArrayList<>(6);
    protected static int actual_bakugan = 0;
    protected static int offset = 1;

    public abstract void getNamesOfBakugans();
    public abstract void setBakuganSelect(String name);


    public void goLeft(ActionEvent event) {
        if(actual_bakugan >= 1 && actual_bakugan <= 5){
            actual_bakugan--;
        }
        else if(actual_bakugan == 0){
            actual_bakugan = 5;
        }
        setBakuganSelect(names_of_bakugans.get(actual_bakugan));
    }

    public void goRight(ActionEvent event) {
        if(actual_bakugan >= 0 && actual_bakugan <= 4){
            actual_bakugan++;
        }
        else if(actual_bakugan == 5){
            actual_bakugan = 0;
        }
        setBakuganSelect(names_of_bakugans.get(actual_bakugan));
    }

    public void selected(ActionEvent event) throws Exception{
        switch (PassingClass.getInstance().getWho_select()) {
            case "player1A" -> PassingClass.getInstance().getTeamA().getPlayer1().setBakugan(new Bakugan(actual_bakugan+offset));
            case "player2A" -> PassingClass.getInstance().getTeamA().getPlayer2().setBakugan(new Bakugan(actual_bakugan+offset));
            case "player1B" -> PassingClass.getInstance().getTeamB().getPlayer1().setBakugan(new Bakugan(actual_bakugan+offset));
            default -> PassingClass.getInstance().getTeamB().getPlayer2().setBakugan(new Bakugan(actual_bakugan+offset));
        }
        names_of_bakugans.removeAll(names_of_bakugans);
        actual_bakugan = 0;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("team_view.fxml")));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root,1920, 1080));
    }
}
