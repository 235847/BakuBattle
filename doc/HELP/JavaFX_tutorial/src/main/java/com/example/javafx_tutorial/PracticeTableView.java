package com.example.javafx_tutorial;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeTableView extends Application {

    Stage window;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @description Called by launch from Application supreme class.
     * @param stage - window of the application.
     * @throws Exception - exception.
     * @method name.setCellValueFactory(new PropertyValueFactory<>("name")) - we're putting 'name' field from passed objects of class Products.
     */
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Test");

        TableColumn<Product, String> name = new TableColumn<>("Name");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> price = new TableColumn<>("Price");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantity = new TableColumn<>("Quantity");
        quantity.setMinWidth(100);
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableView<Product> table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().add(name);
        table.getColumns().add(price);
        table.getColumns().add(quantity);

        TextField name_input = new TextField();
        name_input.setPromptText("Name");
        name_input.setMinWidth(100);

        TextField price_input = new TextField();
        price_input.setPromptText("Price");

        TextField quantity_input = new TextField();
        quantity_input.setPromptText("Quantity");

        Button add = new Button("Add");
        add.setOnAction(actionEvent -> {
            Product product = new Product();
            product.setName(name_input.getText());
            product.setPrice(Double.parseDouble(price_input.getText()));
            product.setQuantity(Integer.parseInt(quantity_input.getText()));
            table.getItems().add(product);
            name_input.clear();
            price_input.clear();
            quantity_input.clear();
        });
        Button delete = new Button("Delete");
        delete.setOnAction(actionEvent -> {
            ObservableList<Product> all_products, selected_product;
            all_products = table.getItems();
            selected_product = table.getSelectionModel().getSelectedItems();
            selected_product.forEach(all_products::remove);
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(name_input,price_input,quantity_input,add,delete);

        VBox layout = new VBox();
        layout.getChildren().addAll(table, hBox);
        scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    /**
     * @description Basically we're putting our products into ObservableList.
     * @return ObservableList<Product> with products in it.
     */
    private ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop",2999.99, 1));
        products.add(new Product("IPhone",2499.99, 1));
        products.add(new Product("Apple",0.59, 3));
        products.add(new Product("Pencil",1, 4));
        return products;
    }
}
