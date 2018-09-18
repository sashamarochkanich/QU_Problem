package com.model;

import com.model.comands.C;

import java.util.ArrayList;

public class Data {
    private ArrayList<C> listOfRecords = new ArrayList<>();

    public void addRecord(C record){
        listOfRecords.add(record);
    }

    public ArrayList<C> getListOfRecors(){
        return listOfRecords;
    }

}
