module com.example.bacard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;


    opens com.example.bakubattle to javafx.fxml;
    exports com.example.bakubattle;
}