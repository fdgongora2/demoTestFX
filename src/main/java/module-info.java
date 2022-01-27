module com.example.demotestfx3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demotestfx3 to javafx.fxml;
    exports com.example.demotestfx3;
}