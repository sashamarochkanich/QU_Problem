package com.controller.reader;

import com.model.constants.Constants;
import com.model.exceptions.IncorrectDataInFile;
import com.controller.parser.Parser;
import com.controller.writer.Writer;


import java.io.*;
import java.text.ParseException;

public class Reader {


    public void readFromFile(String filePath) throws IOException, IncorrectDataInFile, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int countOfLinesInFile = Integer.parseInt(reader.readLine());
        if ((countOfLinesInFile > 100000)||(countOfLinesInFile <= 0)){
            Writer.write(Constants.INCORRECT_NUMBERS_OF_LINE);
            System.exit(0);
        }
        else {
            Parser parser = new Parser();
            parser.parseFromFile(reader);
        }

    }
}
