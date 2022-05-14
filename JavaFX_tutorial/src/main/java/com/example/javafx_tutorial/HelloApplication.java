package com.example.javafx_tutorial;

import javafx.application.Application; //functionality of javafx application
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    Button button;

    /**
     * @description Main method that launches our application.
     * @param args - specified input.
     * @method launch() - launches the application
     */
    public static void main(String[] args) { launch(args);}

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws IOException - exception.
     * @method stage.setTitle() - sets tittle of the stage.
     * @method button.setText() - sets String inside button.
     * @method layout.getChildren.add() - StackPane is one of many others layouts that basically sets object in certain way by using the following method.
     * @method stage.setScene() - decides what scene is used on the stage.
     * @method stage.show() - prints our stage.
     * @method button.setOnAction() - sets an action on the object.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Title");
        properClosing(stage);
        button = new Button();
        button.setText("Something");
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @description Whenever object of this class is called for action, this method responds and handle the action.
     * @param actionEvent - action that has been passed.
     * @method actionEvent.getSource() - gets source of the event.
     * @method AlertBox.display() - launching AlertBox.
     * @method Confirmation.display() - launching ConfirmBox.
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button){
            System.out.println(ConfirmBox.display("test", "Does it work?"));
            AlertBox.display("test", "it works");
        }
    }

    /**
     * @description That is a proper closing method.
     * @param stage - window of the application.
     * @method windowEvent.consume() - pretty much "Thanks Java, I will take it from here and handle that action".
     */
    private void properClosing(Stage stage){
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            if(ConfirmBox.display("title", "Sure you want to leave?")){
                stage.close();
            }
        });
    }
}