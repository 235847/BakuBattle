package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
     * @method paste.setDisable(true) - unable MenuItem.
     * @method editMenu.getItems().add(new SeparatorMenuItem()) - adds separator.
     * @method easy.setToggleGroup(difficultyToggle) - add RadioMenuItem into ToggleGroup that allows you to switch your check.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Menu");

        Menu fileMenu =  new Menu("File");
        fileMenu.getItems().add(new MenuItem("New"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Open"));

        Menu editMenu =  new Menu("Edit");
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new SeparatorMenuItem());
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(actionEvent -> System.out.println("Pasted"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        Menu helpMenu =  new Menu("Help");
        CheckMenuItem update =  new CheckMenuItem("Check for updates...");
        update.setOnAction(actionEvent -> {
            if(update.isSelected()){
                System.out.println("Checking...");
            }
            else{
                System.out.println("Checked");
            }
        });
        CheckMenuItem feedback =  new CheckMenuItem("Submit Feedback...");
        feedback.setSelected(true);
        helpMenu.getItems().addAll(update,feedback);

        Menu diff = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("easy");
        RadioMenuItem medium = new RadioMenuItem("medium");
        RadioMenuItem hard = new RadioMenuItem("hard");
        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);
        diff.getItems().addAll(easy, medium, hard);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu,diff);

        layout = new BorderPane();
        layout.setTop(menuBar);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }
}
