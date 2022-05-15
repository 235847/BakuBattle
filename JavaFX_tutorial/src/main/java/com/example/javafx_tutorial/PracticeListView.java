package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeListView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE) - setting ListView<String> as multi-checkable list.
     * @method [colors = list.getSelectionModel().getSelectedItems()] - in every type of list we can look up items we chose by transferring to ObservableList<String>.
     * @method for(String m: colors) - going through the ObservableList<String>.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("test");

        ListView<String> list = new ListView<>();
        list.getItems().addAll("Blue", "Yellow", "Orange", "Red");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Submit");
        button.setOnAction(actionEvent -> {
            ObservableList<String> colors;
            colors = list.getSelectionModel().getSelectedItems();
            String message = "";
            for(String m: colors){
                message += m+ "\n";
            }
            System.out.println(message);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(list,button);

        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }
}
