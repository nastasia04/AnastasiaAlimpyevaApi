package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Formats {

    PLAIN("plain"),
    HTML("html"),
    INCORRECT_FORMAT("incorrect format");

    public String format;
}