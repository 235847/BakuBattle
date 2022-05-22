module com.example.javafx_tutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_tutorial to javafx.fxml;
    exports com.example.javafx_tutorial;
}