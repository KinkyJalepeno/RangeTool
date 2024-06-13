package com.kinky.rangetool;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;

public class ToolController {

    String pathToFile;
    boolean isPathValid = false;
    int rangeStart = 0;


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

                String tokens[] = text.split("[,]");

                int number = Integer.parseInt(tokens[0]);
                int uda = Integer.parseInt(tokens[1]);

                expandRange(number, uda);


            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void expandRange(int number, int uda) {

        int numberLength = String.valueOf(number).length();

        if (numberLength == 6) {
            rangeStart = (number * 10000);


            writeSixDigitNumber(rangeStart, uda);

        } else if (numberLength == 7) {
            rangeStart = (number * 1000);


            writeSevenDigitNumber(rangeStart, uda);

        } else if (numberLength == 8) {
            rangeStart = (number * 100);


            writeEightDigitNumber(rangeStart, uda);

        } else if (numberLength == 9) {
            rangeStart = (number * 10);


            writeNineDigitNumber(rangeStart, uda);

        } else {
            writeSingleNumber(number, uda);

        }
    }

    private void writeSingleNumber(int rangeStart, int uda) {

        System.out.println("This is single number: " + rangeStart + " " + uda);
    }

    private void writeNineDigitNumber(int rangeStart, int uda) {

        System.out.println("This is nine digit number: " + rangeStart + " " + uda);
    }

    private void writeEightDigitNumber(int rangeStart, int uda) {

        System.out.println("This is eight digit number: " + rangeStart + " " + uda);
    }

    private void writeSevenDigitNumber(int rangeStart, int uda) {

        System.out.println("This is seven digit number: " + rangeStart + " " + uda);
    }

    private void writeSixDigitNumber(int rangeStart, int uda) {

        System.out.println("This is six digit number: " + rangeStart + " " + uda);


    }


}