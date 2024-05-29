package com.kinky.rangetool;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class ToolController {

    private Window Stage;
    String pathToFile;
    boolean isPathValid = false;

    @FXML
    private TextField status;



    @FXML
    void browseToFile() {

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(Stage);

        pathToFile = file.getAbsolutePath();
        status.setText(pathToFile);
        isPathValid = true;
    }



    @FXML
    void processFile() {

        if (!isPathValid){

            status.setText("Select a file first !");

        }else{

            status.setText("You pressed process");
        }

    }

}