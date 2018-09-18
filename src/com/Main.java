package com;


import com.model.exceptions.IncorrectDataInFile;
import com.controller.reader.Reader;

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
            e.printStackTrace();
        } catch (IncorrectDataInFile incorrectDataInFile) {
            incorrectDataInFile.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
