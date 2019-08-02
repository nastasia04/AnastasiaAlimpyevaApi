package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Languages {

    ENGLISH("en"),
    RUSSIAN("ru"),
    UKRAINIAN("uk");

    private final String language;
}
