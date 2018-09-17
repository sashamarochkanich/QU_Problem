package com.parser;

import com.constants.Constants;
import com.controller.QueryController;
import com.data.comands.C;
import com.data.comands.D;
import com.data.dataType.DateOfComand;
import com.data.dataType.Question;
import com.data.dataType.ResponseEnum;
import com.data.dataType.Service;
import com.exceptions.IncorrectDataInFile;
import com.validation.Validation;
import com.validation.ValidationForQuery;
import com.validation.ValidationForRecord;
import com.data.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {

    private java.util.Date Date;

    public void parseFromFile(BufferedReader reader) {

        Data data = new Data();
        QueryController queryController = new QueryController();
        String line;
        String[] splitedLine;

        try {
            while ((line = reader.readLine()) != null) {
                splitedLine = parseLine(line);
                if (ValidationForRecord.isTypeOfCommandCorrect(splitedLine[0])) {
                    if (splitedLine[0]=="C"){
                        C c = new C();
                        if (ValidationForRecord.isServiceCorrect(splitedLine[1])) {
                            c.setService(parseService(splitedLine[1]));
                        }
                        if (ValidationForRecord.isQuestionCorrect(splitedLine[2])){
                            c.setQuestionType(parseQuestion(splitedLine[2]));
                        }
                        if (ValidationForRecord.isResponseCorrect(splitedLine[3])){
                            c.setResponseType(parseResponse(splitedLine[3]));
                        }
                        if (ValidationForRecord.isDateCorrect(splitedLine[4])){
                            c.setDate(parseDate(splitedLine[4]));
                        }
                        if (ValidationForRecord.isTimeCorrect(splitedLine[5])){
                            c.setTime(parseTime(splitedLine[5]));
                        }
                        data.addRecord(c);
                    }
                    else {
                        D d = new D();
                        if (ValidationForQuery.isServiceCorrect(splitedLine[1])) {
                            d.setService(parseService(splitedLine[1]));
                        }
                        if (ValidationForQuery.isQuestionCorrect(splitedLine[2])){
                            d.setQuestionType(parseQuestion(splitedLine[2]));
                        }
                        if (ValidationForQuery.isResponseCorrect(splitedLine[3])){
                            d.setResponseType(parseResponse(splitedLine[3]));
                        }
                        if (ValidationForQuery.isDatePeriodCorrect(splitedLine[4])){
                            d.setDateOfComand(parseDatePeriod(splitedLine[4]));
                        }
                        queryController.executeQuery(d, data);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IncorrectDataInFile incorrectDataInFile) {
            incorrectDataInFile.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private String[] parseLine(String line){
        String[] splitedLine;
        splitedLine = line.split(Constants.LINE_SPLITER);
        return splitedLine;
    }

    private Service parseService(String line){
        Service service = new Service();
        String[] splitedLine;
        splitedLine = line.split(Constants.SERVICE_OR_QUESTION_SPLITER);
        service.setService(Integer.parseInt(splitedLine[0]),Integer.parseInt(splitedLine[1]));
        return service;
    }

    private Question parseQuestion(String line){

        Question question = new Question();
        String[] splitedLine;
        splitedLine = line.split(Constants.SERVICE_OR_QUESTION_SPLITER);
        question.setQuestion(Integer.parseInt(splitedLine[0]),Integer.parseInt(splitedLine[1]),Integer.parseInt(splitedLine[2])) ;
        return question;
    }

    private ResponseEnum parseResponse(String line){
        if (line=="P"){
            return ResponseEnum.P;
        }
        else return ResponseEnum.N;
    }

    private Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat(ValidationForRecord.DATE_REGEX).parse(date);
    }

    private int parseTime(String time) {
        return Integer.parseInt(time);
    }

    private DateOfComand parseDatePeriod(String datePeriod) throws ParseException {
        DateOfComand dateOfComand = new DateOfComand();
        if (datePeriod.length()>10){
            String[] splitedLine = datePeriod.split(Constants.DATE_SPLITER);
            dateOfComand.setOfComand(new SimpleDateFormat(ValidationForRecord.DATE_REGEX).parse(splitedLine[0]),new SimpleDateFormat(ValidationForRecord.DATE_REGEX).parse(splitedLine[1]));
        }
        else {
            dateOfComand.setOfComand(new SimpleDateFormat(ValidationForRecord.DATE_REGEX).parse(datePeriod));
        }
        return dateOfComand;
    }

}
