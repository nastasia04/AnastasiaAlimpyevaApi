package service;

import enums.URI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import readProperty.ReadProperties;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SpellerService {

    private RequestSpecification requestSpecification;

     {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(new ReadProperties().getSpellerDomain())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public  Response checkTextorTexts( URI uri, Map<String, List<String>> parameters) {
        return given(requestSpecification)
                .queryParams(parameters)
                .get(uri.getUri());
    }
}
