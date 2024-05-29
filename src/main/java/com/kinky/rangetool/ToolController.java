package com.kinky.rangetool;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ToolController {

    @FXML
    private TextField status;


    @FXML
    void browseToFile() {

        status.setText("You pressed browse to file");

    }

    @FXML
    void processFile() {

        status.setText("You pressed process file");

    }

}