//package com.example.bakubattle;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//
//import java.util.Objects;
//
//public class ArenaController{
//
//    /* **************************** Domain selection attributes **************************** */
//
//    @FXML
//    public ImageView domain_imageview;
//
//    /* **************************** Domain selection attributes ends **************************** */
//
////    private final static int ROUND_DAMAGE = 100;
////    private static int rounds_counter = 0;
//    private final Team teamA = new Team();
//    private final Team teamB = new Team();
//
//    /* **************************** Team view methods **************************** */
//
//    public void setDomain(ActionEvent event) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("domain_select.fxml"));
//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        window.setScene(new Scene(root,1920, 1080));
//    }
//
//    /* **************************** Team view methods ends **************************** */
//}