package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeTreeView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method root.setExpanded(true) - means we have everything expanded on our tree by default.
     * @method tree.setShowRoot(false) - we don't want to unveil root everytime we do sth on its branches.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("test");

        TreeItem<String> root = new TreeItem<>("root");
        root.setExpanded(true);
        TreeItem<String> mateusz = makeBranch("Mateusz",root);
        makeBranch("lol1",mateusz);
        makeBranch("lol2",mateusz);
        makeBranch("lol3",mateusz);
        TreeItem<String> patryk = makeBranch("Patryk",root);
        makeBranch("l",patryk);
        makeBranch("lo",patryk);
        makeBranch("lol",patryk);
        TreeView<String> tree = new TreeView<>(root);
        tree.setShowRoot(true);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(tree);

        Scene scene = new Scene(layout,300,250);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @description Creating a new branch in a TreeView.
     * @param title - title of the branch or leaf.
     * @param parent - TreeItem<String> thats above him.
     * @return TreeItem<String> - returns a newly created branch or leaf.
     */
    private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
