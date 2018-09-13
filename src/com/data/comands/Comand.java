package com.data.comands;

import com.data.dataType.DateOfComand;
import com.data.dataType.Question;
import com.data.dataType.ResponseEnum;
import com.data.dataType.Service;

public abstract class Comand {
    private Service service;
    private Question questionType;
    private ResponseEnum responseType;
}
