package com.validation;

import com.constants.CommandTypeEnum;
import com.constants.Constants;
import com.data.dataType.ResponseEnum;
import com.exceptions.IncorrectDataInFile;

public class ValidationForQuery extends Validation{
    private static String SERVICE_REGEX = "";
    private static String QUESTION_TYPE_REGEX = "";


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

    public static boolean isResponseCorrect(String response) throws IncorrectDataInFile {
        if ((ResponseEnum.valueOf(response)==ResponseEnum.N)||(ResponseEnum.valueOf(response)==ResponseEnum.P)){
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


}
