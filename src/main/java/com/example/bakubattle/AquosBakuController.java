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

public class AquosBakuController extends Baku implements Initializable {

    /* ---------- Aquos attributes----------*/
    @FXML
    private ImageView aquos_baku_view;
    @FXML
    private Button aquos_left_switch_button;
    @FXML
    private Button aquos_right_switch_button;
    @FXML
    private Button aquos_choice_of_bakugan;
    @FXML
    private Label aquos_name_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getNamesOfBakugans();
        setBakuganSelect(names_of_bakugans.get(actual_bakugan));
    }

    @Override
    public void getNamesOfBakugans(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM bakubattle WHERE bakubattle.bakuID < 7");     //passing our query through the statement
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

    @Override
    public void setBakuganSelect(String name){
        aquos_name_label.setText(name);
        URL url = getClass().getResource("arena/bakugan/"+name+"_Aquos_Details.jpg");     //path
        aquos_baku_view.setImage(new Image(String.valueOf(url)));
    }
}
