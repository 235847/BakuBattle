package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LogWindow extends Application {
    Stage window;

    /**
     * @description Main method that launches our application.
     * @param args - specified input.
     * @method launch() - launches the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method window.setTitle() - sets tittle of the stage.
     * @method grid.setPadding(new Insets()) - sets padding around the GridPane from the scene.
     * @method grid.setVgap() - divides GridPane vertically.
     * @method grid.setHgap() - divides GridPane horizontally.
     * @method grid.setConstraints() - assigns co-ordinates to the object.
     * @method pass.setPromptText() - prints the suggestion to TextField.
     * @method grid.getChildren().addAll() - adds objects to the GridPane.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Sign in");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label username = new Label("Username:");
        GridPane.setConstraints(username, 0 ,0);

        TextField login = new TextField("Bucky");
        GridPane.setConstraints(login, 1 ,0);

        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0 ,1);

        TextField pass = new TextField("");
        pass.setPromptText("password");
        GridPane.setConstraints(pass, 1 ,1);

        Button log = new Button("Log in");
        GridPane.setConstraints(log, 1 ,2);
//        That also does not work
//        log.setStyle("-fx-background-color: #383838");
//        log.setStyle("-fx-border-radius: 4");

        grid.getChildren().addAll(username,login,password,pass,log);

        Scene scene = new Scene(grid,300,200);
        //That should add css but it doesn't work beacuse of the location.
        //scene.getStylesheets().add("D:\\studia\\2 rok\\Komunikacja człowiek-komputer\\BakuBattle\\BakuBattle\\JavaFX_tutorial\\src\\main\\java\\com\\example\\javafx_tutorial\\Viper.css");
        window.setScene(scene);
        window.show();
    }
}
