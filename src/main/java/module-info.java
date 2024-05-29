module com.kinky.rangetool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kinky.rangetool to javafx.fxml;
    exports com.kinky.rangetool;
}