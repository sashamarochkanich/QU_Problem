package com.reader;

import com.data.Data;
import com.exceptions.IncorrectDataInFile;
import com.parser.Parser;

import java.io.*;
import java.text.ParseException;

public class Reader {


    public void readFromFile(String filePath) throws IOException, IncorrectDataInFile, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int countOfLinesInFile = Integer.parseInt(reader.readLine());
        if ((countOfLinesInFile > 100000)||(countOfLinesInFile <= 0)){
            System.out.println("ERR");
        }
        else {
            Parser parser = new Parser();
            parser.parseFromFile(reader);

        }

    }
}
