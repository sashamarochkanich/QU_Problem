package com.data;

import com.data.comands.C;
import com.data.comands.D;

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
