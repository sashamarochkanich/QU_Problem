package com.controller;

import com.data.Data;
import com.data.comands.C;
import com.data.comands.D;

import java.util.ArrayList;

public class QueryController {

    public void executeQuery(D d, Data data){
        ArrayList<C> listOfRecords = data.getListOfRecors();
        for (C record: listOfRecords){

        }
    }
}
