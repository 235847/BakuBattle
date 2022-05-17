package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PracticeBinding extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method y.bind(x.multiply()); - creates relation between two IntegerProperties.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Binding");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();
        y.bind(x.multiply(10));
        System.out.println("\nx: "+x.getValue());
        System.out.println("y: "+y.getValue());
        x.setValue(10);
        System.out.println("\nx: "+x.getValue());
        System.out.println("y: "+y.getValue());

        Button button = new Button("Submit");

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
