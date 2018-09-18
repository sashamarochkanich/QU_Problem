package com.reader;

import com.constants.Constants;
import com.data.Data;
import com.exceptions.IncorrectDataInFile;
import com.parser.Parser;
import com.writer.Writer;


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
