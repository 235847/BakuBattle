package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeBinding extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method l2.textProperty().bind(input.textProperty()) - creates relation between Label and TextField value.
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

        TextField input = new TextField();
        input.setMaxWidth(200);
        Label l1 = new Label("Welcome to the site ");
        Label l2 = new Label();

        HBox bottomText = new HBox(l1,l2);
        bottomText.setAlignment(Pos.CENTER);

        l2.textProperty().bind(input.textProperty());

        VBox layout = new VBox(10, input,bottomText);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
