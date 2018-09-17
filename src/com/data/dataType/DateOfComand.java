package com.data.dataType;

import com.constants.Constants;

import java.util.Date;

public class DateOfComand {
    private Date dateFrom;
    private Date dateTo;

    public void setOfComand(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public void setOfComand(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public boolean isDatePeriodEquals(Date record) {
        if (this.dateTo == null){
            if (this.dateFrom.equals(record)) return true;
        }
        else if (this.dateFrom.before(record) && this.dateTo.after(record)){
            return true;
        }
        return false;
    }
}
