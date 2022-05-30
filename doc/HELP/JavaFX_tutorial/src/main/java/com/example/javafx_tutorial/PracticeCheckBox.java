package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeCheckBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method box2.setSelected(true) - selects the CheckBox by default.
     * @method box1.isSelected() - checks if the CheckBox is selected.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Shop");
        CheckBox box1 = new CheckBox("Burger");
        CheckBox box2 = new CheckBox("Pizza");
        box2.setSelected(true);
        Button button = new Button("Place the order");
        button.setOnAction(actionEvent -> {
            String message = "Users order:\n";
            if(box1.isSelected()){
                message += "Burger\n";
            }
            if(box2.isSelected()){
                message += "Pizza\n";
            }
            System.out.println(message);
        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(box1,box2,button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
