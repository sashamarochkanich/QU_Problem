package com.data;

import com.data.comands.C;

import java.util.ArrayList;

public class Data {
    private ArrayList<C> listOfRecords;

    public void addRecord(C record){
        listOfRecords.add(record);
    }
}
