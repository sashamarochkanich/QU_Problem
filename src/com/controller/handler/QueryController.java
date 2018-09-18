package com.controller.handler;

import com.model.constants.Constants;
import com.model.Data;
import com.model.comands.C;
import com.model.comands.D;
import com.controller.writer.Writer;

import java.util.ArrayList;

public class QueryController {

    public void executeQuery(D d, Data data){
        ArrayList<C> listOfRecords = data.getListOfRecors();
        int totalTimeOfSuitableRecords = 0;
        int countOfSuitableRecords = 0;
        double avarageTime;
        int recordTime;
        for (C record: listOfRecords){
            recordTime = d.timeOfSuitableRecords(record);
            if (recordTime != 0) {
                totalTimeOfSuitableRecords += recordTime;
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
