package com.data.comands;

import java.util.Date;

public class C extends Command {
    private Date date;
    private int time;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
