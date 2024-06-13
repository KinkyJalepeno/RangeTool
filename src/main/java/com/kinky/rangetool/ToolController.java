package com.kinky.rangetool;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;

public class ToolController {

    String pathToFile;
    boolean isPathValid = false;
    int rangeStart = 0;
    WriteFileProcess write = new WriteFileProcess();


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

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {

            String text;
            while ((text = reader.readLine()) != null) {

                String tokens[] = text.split(",");

                int number = Integer.parseInt(tokens[0]);
                int uda = Integer.parseInt(tokens[1]);

                expandRange(number, uda);


            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void expandRange(int number, int uda) throws IOException {

        int numberLength = String.valueOf(number).length();

        if (numberLength == 6) {
            rangeStart = (number * 10000);


            processSixDigits(rangeStart, uda);

        } else if (numberLength == 7) {
            rangeStart = (number * 1000);


            processSevenDigits(rangeStart, uda);

        } else if (numberLength == 8) {
            rangeStart = (number * 100);


            processEightDigits(rangeStart, uda);

        } else if (numberLength == 9) {
            rangeStart = (number * 10);

            System.out.println(rangeStart);

            processNineDigits(rangeStart, uda);

        } else {
            writeToFile(number, uda);
        }
    }

    private void processNineDigits(int rangeStart, int uda) throws IOException {


        for (int i = rangeStart; i < (rangeStart + 10); i++){

            writeToFile(i,uda);
        }

    }

    private void processEightDigits(int rangeStart, int uda) throws IOException {

        for (int i = rangeStart; i < (rangeStart + 100); i++){

            writeToFile(i,uda);
        }

    }

    private void processSevenDigits(int rangeStart, int uda) throws IOException {

        for (int i = rangeStart; i < (rangeStart + 1000); i++){

            writeToFile(i,uda);
        }
    }

    private void processSixDigits(int rangeStart, int uda) throws IOException {

        for (int i = rangeStart; i < (rangeStart + 10000); i++){

            writeToFile(i,uda);
        }
    }


    void writeToFile(int number, int uda) throws IOException {

        String data = ("0" + number + "," + uda);

        write.writeToFile(data);


    }


}