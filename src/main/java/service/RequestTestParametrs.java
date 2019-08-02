package service;

import enums.Formats;
import enums.Languages;
import enums.Options;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class RequestTestParametrs {
    private Map<String, List<String>> parameters;

    private RequestTestParametrs(Map<String, List<String>> parameters) {
        this.parameters = parameters;
    }

    public static RequestBuilder requestBuilder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder {
        private Map<String, List<String>> parameters = new HashMap<>();

        public RequestBuilder setLanguage(Languages lang) {
            parameters.put("lang", Stream.of(lang.getLanguage()).collect(Collectors.toList()));
            return this;
        }

        public RequestBuilder setFormat(Formats... format) {
            parameters.put("format",  Arrays.stream(format).map(f -> f.format).collect(Collectors.toList()));    return this;
        }

        public RequestBuilder setOptions(Options... options) {
            int optionSum = Arrays.stream(options).map(option -> option.getItem()).mapToInt(Integer::intValue).sum();
            parameters.put("options", Arrays.asList(String.valueOf(optionSum)));
            return this;
        }

        public RequestBuilder setText(String text) {
            parameters.put("text", Arrays.asList(text));
            return this;
        }
        public RequestBuilder setText(List<String> text) {
            parameters.put("text", text);
            return this;
        }

        public RequestTestParametrs build() {
            return new RequestTestParametrs(parameters);
        }
    }
}
