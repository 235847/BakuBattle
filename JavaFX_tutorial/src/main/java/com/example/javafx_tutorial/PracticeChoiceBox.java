package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeChoiceBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method box.getItems().add() - adding a string to our ChoiceBox<String>.
     * @method box.setValue() - setting default value.
     * @method box.getValue() - getting checked value that in our case is String from ChoiceBox<String>.
     * @method box.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> System.out.println(newValue)) - generally that transforms our ChoiceBox by action to ChoiceBox by listening.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Grocery store");
        ChoiceBox<String> box = new ChoiceBox<>();
        box.getItems().add("Apples");
        box.getItems().addAll("Bacon", "Ham", "Bananas");
        box.setValue("Bananas");
        box.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> System.out.println(newValue));
        Button button = new Button("Buy");
        button.setOnAction(actionEvent -> {
            System.out.println(box.getValue());
        });
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(box,button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
