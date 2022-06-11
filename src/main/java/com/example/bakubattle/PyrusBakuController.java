package com.example.bakubattle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PyrusBakuController extends Baku implements Initializable {

    /* ---------- Pyrus attributes----------*/
    @FXML
    private ImageView pyrus_baku_view;
    @FXML
    private Button pyrus_left_switch_button;
    @FXML
    private Button pyrus_right_switch_button;
    @FXML
    private Button pyrus_choice_of_bakugan;
    @FXML
    private Label pyrus_name_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getNamesOfBakugans();
        offset = 19;
        setBakuganSelect(names_of_bakugans.get(actual_bakugan));
    }

    @Override
    public void getNamesOfBakugans(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakugan","root","");        //connecting with local database
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM bakubattle WHERE bakubattle.bakuID BETWEEN 19 AND 24");     //passing our query through the statement
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
        pyrus_name_label.setText(name);
        URL url = getClass().getResource("arena/bakugan/"+name+"_Pyrus_Details.jpg");     //path
        pyrus_baku_view.setImage(new Image(String.valueOf(url)));
    }
}
