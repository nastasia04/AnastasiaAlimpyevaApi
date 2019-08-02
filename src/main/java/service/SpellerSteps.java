package service;

import com.google.gson.Gson;
import dto.SpellerDto;
import enums.URI;

public class SpellerSteps {

    public static SpellerDto[] getCheckText(RequestTestParametrs requestParametrs) {

        return new Gson().fromJson(new SpellerService()
                .checkTextorTexts(URI.CHECK_TEXT_URI, requestParametrs.getParameters())
                .getBody()
                .asString()
                ,SpellerDto[].class);
    }
    public static SpellerDto[][] getCheckTexts(RequestTestParametrs requestParametrs) {

        return new Gson().fromJson(new SpellerService()
                .checkTextorTexts(URI.CHECK_TEXTS_URI, requestParametrs.getParameters())
                .getBody()
                .asString()
                ,SpellerDto[][].class);
    }


}
