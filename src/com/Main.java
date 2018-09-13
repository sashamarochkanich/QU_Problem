package com;


import com.reader.Reader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Scanner in = new Scanner(System.in);
        reader.readFromFile(in.next());
    }

}
