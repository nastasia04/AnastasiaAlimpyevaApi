package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum URI {
    CHECK_TEXT_URI ("checkText"),
    CHECK_TEXTS_URI ("checkTexts");

    private String uri;
}
