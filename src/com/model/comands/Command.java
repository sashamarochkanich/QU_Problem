package com.model.comands;

import com.model.dataType.Question;
import com.model.dataType.ResponseEnum;
import com.model.dataType.Service;

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
