package com.model.dataType;

import com.model.constants.Constants;

public class Question {
    private String questionTypeId;
    private String categoryId;
    private String subcategoryId;


    public void setQuestion(String questionTypeId, String categoryId, String subcategoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    public void setQuestion(String questionTypeId, String categoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = null;
    }

    public void setQuestion(String questionTypeId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = null;
        this.subcategoryId = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!questionTypeId.equals(question.questionTypeId)) {
            return false;
        }
        if (categoryId == null) return true;
        return categoryId.equals(question.categoryId) && subcategoryId == null ? true : subcategoryId.equals(question.subcategoryId);
    }

    @Override
    public int hashCode() {
        int result = questionTypeId.hashCode();
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (subcategoryId != null ? subcategoryId.hashCode() : 0);
        return result;
    }

    public boolean isQuestionEquals(Question record) {
        if (this.questionTypeId.equals(Constants.SERVICE_AND_QUESTION_SPECIAL_VALUE)){
            return true;
        }
        else if (this.equals(record)){
            return true;
        }
        return false;
    }

}


