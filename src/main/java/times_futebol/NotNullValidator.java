package times_futebol;

import java.util.Arrays;
import java.util.Objects;

public class NotNullValidator {

    public static void validateNotNull(Object... params) {
        Arrays.stream(params)
                .filter(Objects::isNull)
                .forEach(o -> {
                    throw new NullPointerException();
                });
    }
}
