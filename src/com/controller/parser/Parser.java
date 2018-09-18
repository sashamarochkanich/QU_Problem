package com.controller.parser;

import com.controller.writer.Writer;
import com.model.constants.Constants;
import com.controller.handler.QueryController;
import com.model.comands.C;
import com.model.comands.D;
import com.model.dataType.DateOfComand;
import com.model.dataType.Question;
import com.model.dataType.ResponseEnum;
import com.model.dataType.Service;
import com.model.exceptions.IncorrectDataInFile;
import com.controller.validation.ValidationForQuery;
import com.controller.validation.ValidationForRecord;
import com.model.Data;

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
                    if ("C".equals(splitedLine[0])){
                        C c = new C();
                        ValidationForRecord.isRecordValidate(splitedLine);
                        c.setService(parseService(splitedLine[1]));
                        c.setQuestionType(parseQuestion(splitedLine[2]));
                        c.setResponseType(parseResponse(splitedLine[3]));
                        c.setDate(parseDate(splitedLine[4]));
                        c.setTime(parseTime(splitedLine[5]));
                        data.addRecord(c);

                    }
                    else {
                        D d = new D();
                        ValidationForQuery.isQueryValidate(splitedLine);
                        d.setService(parseService(splitedLine[1]));
                        d.setQuestionType(parseQuestion(splitedLine[2]));
                        d.setResponseType(parseResponse(splitedLine[3]));
                        d.setDateOfComand(parseDatePeriod(splitedLine[4]));
                        queryController.executeQuery(d, data);
                    }
                }
            }
        } catch (IOException e) {
            Writer.write(Constants.PROBLEM_FILE);
        } catch (IncorrectDataInFile incorrectDataInFile) {
            Writer.write(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
        } catch (ParseException e) {
            Writer.write(Constants.PARSING_PROBLEM);
        }
        catch (Exception e){
            Writer.write(Constants.GLOBAL_EXEPTION);
            Writer.write(e.toString());
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
        splitedLine = line.split(Constants.SERVICE_OR_QUESTION_SPLITER,0);
        if (splitedLine.length == Constants.DEFAULT_SERVICE_SIZE) {
            service.setService(splitedLine[0],splitedLine[1]);
        }
        else service.setService(splitedLine[0]);
        return service;
    }

    private Question parseQuestion(String line){

        Question question = new Question();
        String[] splitedLine;
        splitedLine = line.split(Constants.SERVICE_OR_QUESTION_SPLITER);
        if (splitedLine.length == Constants.DEFAULT_QUESTION_SIZE){
            question.setQuestion(splitedLine[0],splitedLine[1],splitedLine[2]) ;
        }
        else if (splitedLine.length == Constants.MIDLE_QUESTION_SIZE){
            question.setQuestion(splitedLine[0],splitedLine[1]);
        }
        else question.setQuestion(splitedLine[0]);
        return question;
    }

    private ResponseEnum parseResponse(String line){
        if ("P".equals(line)){
            return ResponseEnum.P;
        }
        else return ResponseEnum.N;
    }

    private Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat(ValidationForRecord.DATE_REGEX_FOR_PARSER).parse(date);
    }

    private int parseTime(String time) {
        return Integer.parseInt(time);
    }

    private DateOfComand parseDatePeriod(String datePeriod) throws ParseException {
        DateOfComand dateOfComand = new DateOfComand();
        if (datePeriod.length()>10){
            String[] splitedLine = datePeriod.split(Constants.DATE_SPLITER);
            dateOfComand.setOfComand(new SimpleDateFormat(ValidationForRecord.DATE_REGEX_FOR_PARSER).parse(splitedLine[0]),new SimpleDateFormat(ValidationForRecord.DATE_REGEX_FOR_PARSER).parse(splitedLine[1]));
        }
        else {
            dateOfComand.setOfComand(new SimpleDateFormat(ValidationForRecord.DATE_REGEX_FOR_PARSER).parse(datePeriod));
        }
        return dateOfComand;
    }

}
