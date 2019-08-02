package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static enums.ErrorCodes.*;
import static enums.Languages.*;

public class dataProveders {
    @DataProvider
    public Object[][] incorrectWords() {
        return new Object[][]{
                {"helo", "hello", ENGLISH},
                {"прывет", "привет", RUSSIAN},
                {"превіт", "привіт", UKRAINIAN}
        };
    }
    @DataProvider
    public Object[][] correctTexts() {
        return new Object[][]{
                {Arrays.asList("hello", "world", "sun"), ENGLISH},
                {Arrays.asList("привет", "мир", "солнце"), RUSSIAN},
                {Arrays.asList("привiт", "можливо", "тисяча"), UKRAINIAN}
        };
    }

    @DataProvider
    public Object[][] incorrectTexts() {
        return new Object[][]{
                {Arrays.asList("helo", "inglish"), Arrays.asList("hello", "english"),ENGLISH},
                {Arrays.asList("превет", "сонце"), Arrays.asList("привет", "солнце"), RUSSIAN},
                {Arrays.asList("превіт", "мажливо"), Arrays.asList("привіт", "можливо"), UKRAINIAN}
        };
    }
    @DataProvider(name = "errorsUnknownWords")
    public static Object[][] errors() {
        return new Object[][]{
                {"thethethe;", ERROR_UNKNOWN_WORD, ENGLISH},
                {"синхрофазатрон", ERROR_UNKNOWN_WORD, RUSSIAN},
                {"синхрофазатрон", ERROR_UNKNOWN_WORD, UKRAINIAN}
        };
    }@DataProvider(name = "ignoreCapitalization")
    public static Object[][] ignoreCapitalization() {
        return new Object[][]{
                {"london", ENGLISH},
                {"москва",  RUSSIAN},
                {"москва",  UKRAINIAN}
        };
    }

}
