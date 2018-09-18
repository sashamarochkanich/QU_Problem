package com.model.comands;

import com.model.dataType.DateOfComand;

public class D extends Command {

    private DateOfComand dateOfComand;

    public void setDateOfComand(DateOfComand dateOfComand) {
        this.dateOfComand = dateOfComand;
    }

    public DateOfComand getDateOfComand() {
        return dateOfComand;
    }

    public int timeOfSuitableRecords(C record) {
        if(isRecordSuitable(record)){
            return record.getTime();
        }
        return 0;
    }

    private boolean isRecordSuitable(C record) {
        if ((this.getService().isServiceEquals(record.getService()))&&(this.getQuestionType().isQuestionEquals(record.getQuestionType()))&&(this.getResponseType().isResponseEquals(record.getResponseType()))&&(this.getDateOfComand().isDatePeriodEquals(record.getDate()))){
            return true;
        }
        return false;
    }

}
