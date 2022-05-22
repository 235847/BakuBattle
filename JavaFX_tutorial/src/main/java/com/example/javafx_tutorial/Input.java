package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Input extends Application {

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
     * @throws Exception - exception.
     * @method in.getText() - extraction of the message that was passed by TextField.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Test");
        TextField in = new TextField();
        Button button = new Button("Click me");
        button.setOnAction(actionEvent -> isInt(in.getText()));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(in,button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @description Checking if the input value is integer.
     * @param text - input String.
     */
    private void isInt(String text){
        try{
            int x = Integer.parseInt(text);
            System.out.println("Success: "+x);
        }catch (NumberFormatException e){
            System.out.println("Failed: "+text);
        }
    }
}
