package com.example.javafx_tutorial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    /**
     * @description Displaying the AlertBox.
     * @param title - title of the window.
     * @param message - simple text which is printed.
     * @method window.initModality() - forbidding to click sth outside this stage.
     * @method window.setMinWidth() - simply minimum width of the stage.
     * @method window.close() - closing the stage.
     * @method layout.setAlignment() - setting position of the VBox.
     * @method window.showAndWait() - works with initModality() and blocks any interaction outside the box until its closed.
     */
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        Button close = new Button("Close the window");
        close.setOnAction(actionEvent -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,200,150);
        window.setScene(scene);
        window.showAndWait();
    }
}
