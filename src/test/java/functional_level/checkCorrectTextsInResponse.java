package functional_level;

import dataProviders.dataProveders;
import dto.SpellerDto;
import enums.Languages;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.List;

import static service.RequestTestParametrs.requestBuilder;

public class checkCorrectTextsInResponse {

    @Test(dataProvider = "incorrectWords",
            dataProviderClass = dataProveders.class,
            description = "Check correct text in response")
    public void checkText(String text, String correctText, Languages language) {
        SpellerDto[] result = SpellerSteps.getCheckText(requestBuilder()
                .setLanguage(language)
                .setText(text)
                .build());
        SpellerAssertions.checkCorrectTextInResponse(result, correctText);
    }
    @Test(dataProvider = "incorrectTexts",
            dataProviderClass = dataProveders.class,
            description = "Check correct texts in response")
    public void checkTexts(List<String> texts, List<String> correctTexts, Languages language) {
        SpellerDto [][] response = SpellerSteps
                .getCheckTexts(
                        requestBuilder()
                        .setLanguage(language)
                        .setText(texts)
                        .build());
            SpellerAssertions.checkCorrectTextsInResponse(response, correctTexts);
    }
}
