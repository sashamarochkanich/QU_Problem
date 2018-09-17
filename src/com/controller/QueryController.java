package com.controller;

import com.constants.Constants;
import com.data.Data;
import com.data.comands.C;
import com.data.comands.D;
import com.writer.Writer;

import java.util.ArrayList;

public class QueryController {

    public void executeQuery(D d, Data data){
        ArrayList<C> listOfRecords = data.getListOfRecors();
        int totalTimeOfSuitableRecords = 0;
        int countOfSuitableRecords = 0;
        double avarageTime;
        for (C record: listOfRecords){
            if (d.timeOfSuitableRecords(record) != 0) {
                totalTimeOfSuitableRecords += d.timeOfSuitableRecords(record);
                countOfSuitableRecords++;
            }
        }
        if (countOfSuitableRecords != 0){
            avarageTime = totalTimeOfSuitableRecords / countOfSuitableRecords;
            Writer.write(String.valueOf(avarageTime));
        }
        else Writer.write(Constants.NO_AVERAGE_TIME);
    }
}
