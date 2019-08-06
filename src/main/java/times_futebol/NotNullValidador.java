package times_futebol;

import java.util.Arrays;
import java.util.Objects;

public class NotNullValidador {

    public static void validarNotNull(Object... params) {
        Arrays.stream(params)
                .filter(Objects::isNull)
                .findFirst()
                .ifPresent(o -> {
                    throw new NullPointerException();
                });
    }
}
