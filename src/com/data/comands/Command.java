package com.data.comands;

import com.data.dataType.DateOfComand;
import com.data.dataType.Question;
import com.data.dataType.ResponseEnum;
import com.data.dataType.Service;

public abstract class Command {

    private Service service;
    private Question questionType;
    private ResponseEnum responseType;

    public Service getService() {
        return service;
    }

    public Question getQuestionType() {
        return questionType;
    }

    public ResponseEnum getResponseType() {
        return responseType;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setQuestionType(Question questionType) {
        this.questionType = questionType;
    }

    public void setResponseType(ResponseEnum responseType) {
        this.responseType = responseType;
    }
}
