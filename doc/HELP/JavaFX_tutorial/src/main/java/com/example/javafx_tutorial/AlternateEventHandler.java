package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AlternateEventHandler extends Application{

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
     * @method button.setOnAction() - sets an action on the object.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Event Handler");
        Button button = new Button();
        button.setText("Something");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("It is much easier this way.");
            }
        });
        Button button_with_lambda = new Button("Something else");
        button_with_lambda.setOnAction(actionEvent -> System.out.println("The easiest way ever ( use {} to write more in this )"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button_with_lambda);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
