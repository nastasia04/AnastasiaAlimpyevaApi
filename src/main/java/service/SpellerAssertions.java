package service;

import dto.SpellerDto;
import enums.ErrorCodes;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpellerAssertions {

    public static void checkCorrectTextInResponse(SpellerDto[] result, String correctString) {
        assertTrue(result[0].getS().contains(correctString));
    }
    public static void checkErrorCode(SpellerDto[] result, ErrorCodes expectedErrorCode) {
        assertEquals(result[0].getCode(), expectedErrorCode.getItem().intValue());
    }
    public static void checkCorrectTextsInResponse(SpellerDto[][] result, List<String> expectedTexts){
        for(int i = 0; i < expectedTexts.size(); i++){
            checkCorrectTextInResponse(result[i], expectedTexts.get(i));
        }
    }
    
}
