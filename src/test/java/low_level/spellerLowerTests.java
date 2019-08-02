package low_level;

import dataProviders.dataProveders;
import enums.Languages;import enums.URI;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import service.SpellerService;

import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static service.RequestTestParametrs.requestBuilder;

public class spellerLowerTests {

private static final int NUMBER_OF_SUGGESTIONS = 3;
    @Test(dataProvider = "incorrectWords",
            dataProviderClass = dataProveders.class,
            description = "Check status code when method checkText is called")
   void checkText(String word, String correctWord, Languages language) {
       Map<String, List<String>> parameters = requestBuilder()
                .setLanguage(language)
                .setText(word)
                .build()
                .getParameters();

        new SpellerService().checkTextorTexts(URI.CHECK_TEXT_URI,parameters)
                .then()
                .statusCode(HTTP_OK).and()
                .body("s[0]", Matchers.hasItems(correctWord));
    }
    @Test(dataProvider = "correctTexts",
            dataProviderClass = dataProveders.class,
            description = "Check status code when method checkTexts is called")
    void checkTexts(List<String> text,  Languages language) {
        Map<String, List<String>> parameters = requestBuilder()
                .setLanguage(language)
                .setText(text)
                .build()
                .getParameters();

        new SpellerService().checkTextorTexts(URI.CHECK_TEXTS_URI,parameters)
                .then()
                .statusCode(HTTP_OK);
    }
    @Test(dataProvider = "incorrectWords",
            dataProviderClass = dataProveders.class,
            description = "right number of suggestions")
    void numberOfSuggestionsTest(String word, String correctWord, Languages language) {
        Map<String, List<String>> parameters = requestBuilder()
                .setLanguage(language)
                .setText(word)
                .build()
                .getParameters();
        new SpellerService().checkTextorTexts(URI.CHECK_TEXT_URI,parameters)
                .then()
                .statusCode(HTTP_OK).and()
                .body("s[0]", hasSize(NUMBER_OF_SUGGESTIONS));
    }
}
