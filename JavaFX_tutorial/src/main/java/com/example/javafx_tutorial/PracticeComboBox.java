package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeComboBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method box.getItems().addAll() - adding a string to our ComboBox<String>.
     * @method box.setPromptText() - prints suggestion.
     * @method box.setEditable(true) - you can type your own choice.
     * @method box.getValue() - getting checked value that in our case is String from ComboBox<String>.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Test");
        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll("Patryk", "Wilhelm", "Mateusz");
        box.setPromptText("Nickname");
        box.setEditable(true);
        box.setOnAction(actionEvent -> System.out.println("Nickname: "+box.getValue()));
        Button button = new Button("Submit");
        button.setOnAction(actionEvent -> System.out.println(box.getValue()));
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(box,button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
