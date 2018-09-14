package com.validation;

import com.constants.CommandTypeEnum;
import com.constants.Constants;
import com.data.dataType.ResponseEnum;
import com.exceptions.IncorrectDataInFile;

public class Validation {

    public static String DATE_REGEX = "dd.MM.yyyy";


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
