package com.kinky.rangetool;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class ToolController {

    String pathToFile;
    boolean isPathValid = false;

    @FXML
    private TextField status;


    @FXML
    void browseToFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Select a CSV");


        pathToFile = file.getAbsolutePath();
        status.setText(pathToFile);
        isPathValid = true;
    }


    @FXML
    void processFile() {

        if (!isPathValid) {

            status.setText("Select a file first !");

        } else {

            processLine();
        }

    }

    void processLine() {


        status.setText("Read Line Method");

    }


    void writeSingleNumber() {


    }


    void writeRangeNumbers() {


    }


}