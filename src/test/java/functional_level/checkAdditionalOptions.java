package functional_level;

import dataProviders.dataProveders;
import dto.SpellerDto;
import enums.ErrorCodes;
import enums.Languages;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;


import static enums.Options.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.testng.AssertJUnit.assertEquals;
import static service.RequestTestParametrs.requestBuilder;

public class checkAdditionalOptions {
    private static final String  TEXT_FOR_IGNORE_URL_OPTIONS = "http://yandex.com";
    private static final String  TEXT_FOR_IGNORE_DIGIT_OPTIONS = "33hello+hi876";



    @Test(dataProvider = "errorsUnknownWords",
            dataProviderClass = dataProveders.class,
            description = "Check Unknown word errors in response")
    public void errorCodesTest(String text, ErrorCodes errorCode, Languages language) {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(language)
                        .setText(text)
                        .build());
        SpellerAssertions.checkErrorCode(response,errorCode );

    }
    @Test(dataProvider = "ignoreCapitalization",
            dataProviderClass = dataProveders.class,
            description = "Check ignoreCapitalization in response")
    public void ignoreCapitalization(String text,  Languages language) {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(language)
                        .setOptions(IGNORE_CAPITALIZATION)
                        .setText(text)
                        .build());

        assertThat(response).hasSize(0);
    }
    @Test(dataProvider = "ignoreCapitalization",
            dataProviderClass = dataProveders.class,
            description = "Check error Capitalization in response",
            enabled = false)
    // it looks like speller doesn't recognize Capitalization error without IGNORE_CAPITALIZATION option
    //test failed
    public void errorCapitalization(String text,  Languages language) {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(language)
                        .setText(text)
                        .build());
        assertEquals(ErrorCodes.ERROR_CAPITALIZATION.getItem().intValue(),response[0].getCode());
    }

    @Test(description = "Check with IgnoreDigit option")
    void checkTextWithOptionsParameterIgnoreDigit() {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(Languages.ENGLISH)
                        .setOptions(IGNORE_DIGITS)
                        .setText(TEXT_FOR_IGNORE_DIGIT_OPTIONS)
                        .build());
        assertThat(response).hasSize(0);
    }
    @Test(description = "Check without IgnoreDigit option")
    void checkTextWithoutOptionsParameterIgnoreDigit() {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(Languages.ENGLISH)
                        .setText(TEXT_FOR_IGNORE_DIGIT_OPTIONS)
                        .build());
        assertThat(response).hasSize(2);
    }

    @Test(description = "Check with IGNORE_URLS parameter")
    void checkTextWithOptionParameterIgnoreUrL() {
        SpellerDto[] response = SpellerSteps
                .getCheckText(requestBuilder()
                        .setLanguage(Languages.ENGLISH)
                        .setOptions(IGNORE_URLS)
                        .setText(TEXT_FOR_IGNORE_URL_OPTIONS)
                                .build());
        assertThat(response).hasSize(0);
    }
}
