package com.kinky.rangetool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileProcess {


    void writeToFile(String dataToWrite) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Expanded Range.csv", true))) {

            writer.write(dataToWrite + "\n");

        }


    }


}
