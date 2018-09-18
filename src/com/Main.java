package com;


import com.model.constants.Constants;
import com.model.exceptions.IncorrectDataInFile;
import com.controller.reader.Reader;
import com.controller.writer.Writer;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Scanner in = new Scanner(System.in);
        try {
            reader.readFromFile(in.next());
        } catch (IOException e) {
            Writer.write(Constants.PROBLEM_FILE);
        }
    }

}
