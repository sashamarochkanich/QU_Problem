package test;

import com.controller.validation.ValidationForQuery;
import com.model.constants.Constants;
import com.model.exceptions.IncorrectDataInFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValidationForQueryTesting {
    ValidationForQuery validationForQuery;

    @Before
    public void validationForQueryInit(){
        validationForQuery = new ValidationForQuery();
    }

    @Test
    public void isServiceCorrectTest(){
        String serviceTest = "1.1";
        boolean flag = false;
        try {
            flag = ValidationForQuery.isServiceCorrect(serviceTest);
        } catch (IncorrectDataInFile incorrectDataInFile) {
            incorrectDataInFile.printStackTrace();
        }
        assertEquals(true, flag);
    }

    @Test
    public void isServiceCorrectExceptionTest(){
        String serviceTest = "1/1kl";
        String exceptionMessage = "";
        try {
            ValidationForQuery.isServiceCorrect(serviceTest);
        } catch (IncorrectDataInFile incorrectDataInFile) {
            exceptionMessage = incorrectDataInFile.getMessage();
        }
        Assert.assertEquals(Constants.INCORRECT_DATA_IN_FILE_MESSAGE, exceptionMessage);
    }

}
