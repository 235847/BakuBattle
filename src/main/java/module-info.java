module com.example.bacard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bakubattle to javafx.fxml;
    exports com.example.bakubattle;
}