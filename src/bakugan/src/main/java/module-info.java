module com.example.bakugan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bakugan to javafx.fxml;
    exports com.example.bakugan;
}