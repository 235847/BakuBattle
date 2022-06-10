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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AquosBakuController implements Initializable {

    /* ---------- Aquos attributes----------*/
    @FXML
    private ImageView aquos_baku_view;
    @FXML
    private Button aquos_left_switch_button;
    @FXML
    private Button aquos_right_switch_button;
    @FXML
    private Button aquos_actual_bakugan_of_bakugan;
    @FXML
    private Label aquos_name_label;

    private static final ArrayList<String> names_of_bakugans = new ArrayList<>(6);
    private static int actual_bakugan = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getNamesOfBakugans();
        setBakuganSelect(names_of_bakugans.get(actual_bakugan));
    }

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
            case "player1A" -> PassingClass.getInstance().getTeamA().getPlayer1().setBakugan(new Bakugan(actual_bakugan+1));
            case "player2A" -> PassingClass.getInstance().getTeamA().getPlayer2().setBakugan(new Bakugan(actual_bakugan+1));
            case "player1B" -> PassingClass.getInstance().getTeamB().getPlayer1().setBakugan(new Bakugan(actual_bakugan+1));
            default -> PassingClass.getInstance().getTeamB().getPlayer2().setBakugan(new Bakugan(actual_bakugan+1));
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("team_view.fxml")));
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root,1920, 1080));
    }

    private void getNamesOfBakugans(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bakubattle WHERE bakubattle.bakuID < 7");     //passing our query through the statement
            while (rs.next()){
//                System.out.println(rs.getString("name"));
                names_of_bakugans.add(rs.getString("name"));
            }
            statement.close();                                  //closing the conversation with database.
            connection.close();
        }catch (Exception e){
            System.out.println("Error: loading from database\n");
            e.printStackTrace();
        }
    }

    private void setBakuganSelect(String name){
        aquos_name_label.setText(name);
        URL url = getClass().getResource("arena/bakugan/"+name+"_Aquos_Scene.png");     //path
        aquos_baku_view.setImage(new Image(String.valueOf(url)));
    }
}
