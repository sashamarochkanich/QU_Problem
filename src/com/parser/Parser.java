package com.parser;

import java.io.BufferedReader;
import java.io.IOException;

public class Parser {

    public void parseFromFile(BufferedReader reader) throws IOException {
        String line;
        String[] lines;
        line = reader.readLine();
        lines = line.split(" ");
        System.out.println(lines[1]);
        System.out.println(lines[0]);
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
