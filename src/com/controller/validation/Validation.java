package com.controller.validation;

import com.model.constants.CommandTypeEnum;
import com.model.constants.Constants;
import com.model.dataType.ResponseEnum;
import com.model.exceptions.IncorrectDataInFile;

public class Validation {

    public static String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.]((19|20)\\d\\d)$";
    public static String DATE_REGEX_FOR_PARSER = "dd.MM.yyyy";



    public static boolean isTypeOfCommandCorrect(String command) throws IncorrectDataInFile {
        if ((CommandTypeEnum.valueOf(command)==CommandTypeEnum.C)||(CommandTypeEnum.valueOf(command)==CommandTypeEnum.D)){
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
}
