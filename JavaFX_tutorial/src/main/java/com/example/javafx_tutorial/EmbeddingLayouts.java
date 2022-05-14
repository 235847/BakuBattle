package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbeddingLayouts extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Test");
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            if(ConfirmBox.display("Quit", "Sure you wanna quite?")){
                stage.close();
            }
        });

        HBox top_menu = new HBox();
        Button b1 = new Button("File");
        Button b2 = new Button("Edit");
        Button b3 = new Button("View");
        top_menu.getChildren().addAll(b1,b2,b3);

        VBox left_menu = new VBox();
        Button a1 = new Button("F");
        Button a2 = new Button("E");
        Button a3 = new Button("V");
        left_menu.getChildren().addAll(a1,a2,a3);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top_menu);
        borderPane.setLeft(left_menu);

        Scene scene = new Scene(borderPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}
