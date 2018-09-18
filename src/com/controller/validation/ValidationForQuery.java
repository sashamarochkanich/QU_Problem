package com.controller.validation;

import com.model.constants.Constants;
import com.model.exceptions.IncorrectDataInFile;

import java.text.ParseException;

public class ValidationForQuery extends Validation{
    private static String SERVICE_REGEX = "(([1-9]|10)(\\.[1-3])?)|\\*";
    private static String QUESTION_TYPE_REGEX = "(([1-9]|10)(\\.([1-9]|1[0-9]|20)(\\.[1-5])?)?)|\\*";
    public static String DATE_PERIOD_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)\\-(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)$";


    public static boolean isServiceCorrect(String service) throws IncorrectDataInFile {
        if (service.matches(SERVICE_REGEX)){
            return true;
        }
        throw new IncorrectDataInFile(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
    }

    public static boolean isQuestionCorrect(String question) throws IncorrectDataInFile {
        if (question.matches(QUESTION_TYPE_REGEX)){
            return true;
        }
        throw new IncorrectDataInFile(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
    }

    public static boolean isDatePeriodCorrect(String date) throws IncorrectDataInFile, ParseException {
        if (date.matches(DATE_REGEX)){
            return true;
        }
        if (date.matches(DATE_PERIOD_REGEX)){
            return true;
        }
        throw new IncorrectDataInFile(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
    }


}
