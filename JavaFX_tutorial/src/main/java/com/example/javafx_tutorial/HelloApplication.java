package com.example.javafx_tutorial;

import javafx.application.Application; //functionality of javafx application
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    /**
     * @description Main method that launches our application.
     * @param args - specified input.
     * @method launch() - launches the application
     */
    public static void main(String[] args) { launch(args);}

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws IOException - exception.
     * @method stage.setTitle() - sets tittle of the stage.
     * @method button.setText() - sets String inside button.
     * @method layout.getChildren.add() - StackPane is one of many others layouts that basically sets object in certain way by using the following method.
     * @method stage.setScene() - decides what scene is used on the stage.
     * @method stage.show() - prints our stage.
     * @method
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Title");
        Button button = new Button();
        button.setText("Something");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}