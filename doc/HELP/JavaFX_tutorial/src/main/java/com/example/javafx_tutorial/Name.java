package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Name extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method  mateusz.firstNameProperty().addListener(()->{}) - adds listener method to StringProperty.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Test");

        Person mateusz = new Person();
        mateusz.firstNameProperty().addListener((v,oldValue,newValue) -> {
            System.out.println("Name changed: "+newValue);
            System.out.println("firstNameProperty(): "+mateusz.firstNameProperty());
            System.out.println("getFirstName(): "+mateusz.getFirstName());
        });

        Button button = new Button("Submit");
        button.setOnAction(actionEvent -> mateusz.setFirstName("Porky"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout,300, 250);
        window.setScene(scene);
        window.show();
    }
}
