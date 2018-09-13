package com.reader;

import com.data.Data;
import com.parser.Parser;

import java.io.*;

public class Reader {

    public Reader() {
    }

    public void readFromFile(String filePath) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int countOfLinesInFile = Integer.parseInt(reader.readLine());
        if ((countOfLinesInFile > 100000)||(countOfLinesInFile <= 0)){
            System.out.println("ERR");
        }
        else {
            g
            Parser parser = new Parser();
            parser.parseFromFile(reader);
        }
        Data data = new Data();

    }
}
