package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PracticeMenu extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method fileMenu.getItems().add(new MenuItem()) - this method adds MenuItem into dropdown Menu.
     * @method menuBar.getMenus().addAll() - setting defined Menu's into MenuBar.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Menu");

        Menu fileMenu =  new Menu("File");
        fileMenu.getItems().add(new MenuItem("New"));
        fileMenu.getItems().add(new MenuItem("Open"));
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }
}
