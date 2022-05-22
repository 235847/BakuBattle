package com.example.javafx_tutorial;

import javafx.application.Application; //functionality of javafx application
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchScenes extends Application{
    Stage window;
    Scene scene1, scene2;

    /**
     * @description Main method that launches our application.
     * @param args - specified input.
     * @method launch() - launches the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws IOException - exception.
     * @method stage.setTitle() - sets tittle of the stage.
     * @method layout2.getChildren.addAll() - StackPane is one of many others layouts that basically sets object in certain way by using the following method.
     * @method layout1.getChildren.addAll() - this method adds numerous object to the Vbox in this case.
     * @method stage.setScene() - decides what scene is used on the stage.
     * @method stage.show() - prints our stage.
     * @method button.setOnAction() - sets an action on the object.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Test");

        Label label1 = new Label("First Scene");
        Button button1 = new Button("Go to scene2");
        button1.setOnAction(actionEvent -> window.setScene(scene2));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1, 300, 250);

        Button button2 = new Button("Go to scene1");
        button2.setOnAction(actionEvent -> window.setScene(scene1));
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2, 300, 250);

        window.setScene(scene1);
        window.show();
    }
}
