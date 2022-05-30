module com.newproj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.newproj to javafx.fxml;
    exports com.newproj;
}