package com.controller.validation;

import com.model.constants.Constants;
import com.model.exceptions.IncorrectDataInFile;

public class ValidationForRecord extends Validation{

    private static String SERVICE_REGEX = "(([1-9]|10)(\\.[1-3])?)";
    private static String QUESTION_TYPE_REGEX = "(([1-9]|10)(\\.([1-9]|1[0-9]|20)(\\.[1-5])?)?)";
    public static String TIME_REGEX = "\\d+";

    public static boolean isRecordValidate(String[] splitedLine) throws IncorrectDataInFile {
        return isServiceCorrect(splitedLine[1]) && isQuestionCorrect(splitedLine[2]) && isResponseCorrect(splitedLine[3]) && isDateCorrect(splitedLine[4]) && isTimeCorrect(splitedLine[5]);
    }

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

    public static boolean isDateCorrect(String date) throws IncorrectDataInFile {
        if (date.matches(DATE_REGEX)){
            return true;
        }
        throw new IncorrectDataInFile(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
    }

    public static boolean isTimeCorrect(String time) throws IncorrectDataInFile {
        if (time.matches(TIME_REGEX)){
            return true;
        }
        throw new IncorrectDataInFile(Constants.INCORRECT_DATA_IN_FILE_MESSAGE);
    }

}
