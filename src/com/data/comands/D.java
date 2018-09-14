package com.data.comands;

import com.data.dataType.DateOfComand;

public class D extends Command {

    private DateOfComand dateOfComand;

    public void setDateOfComand(DateOfComand dateOfComand) {
        this.dateOfComand = dateOfComand;
    }

    public boolean isRecordSuitable(C record) {
        if(isServicesEquals(record))
    }

    private boolean isServicesEquals(C record) {
        if (this.getService().equals(record.getService())){
            return true;
        }
        return false;
    }
}
