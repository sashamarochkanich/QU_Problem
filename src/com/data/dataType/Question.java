package com.data.dataType;

public class Question {
    private int questionTypeId;
    private int categoryId;
    private int subcategoryId;


    public void setQuestion(int questionTypeId, int categoryId, int subcategoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }
}


