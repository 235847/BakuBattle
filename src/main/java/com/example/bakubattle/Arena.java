package com.example.bakubattle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Arena extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            stage.setTitle("Arena");        //title setup
            FXMLLoader fxmlLoader = new FXMLLoader(Arena.class.getResource("set_team.fxml"));       //loading the fxml.
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);                 //placing fxml file on the scene.
            stage.setFullScreen(true);                                                    //stage is fullscreen
            stage.setScene(scene);
            stage.show();                               //show the stage
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(Error.CREATING_SCENE);
        }
    }

    public static void main(String[] args) {
        launch();       //launching our game
    }
}