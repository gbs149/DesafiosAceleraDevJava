package caesar_cipher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Caesar Cipher Tests")
class CaesarCipherTest {

    @ParameterizedTest
    @CsvSource({
            "3, a, d",
            "3, abcxyz, defabc",
            "29, abcxyz, defabc",
            "3, aBcXyZ, defabc",
            "3, '', ''",
            "3, a b, d e",
            "3, a.b, d.e",
            "3, a-b, d-e",
            "3, a1b, d1e"
    })
    @DisplayName("Tests encoding strings")
    void itShouldEncodeStrings(int offset, String message, String expected) {
        assertEquals(expected, CaesarCipher.encode(offset, message));
    }

    @ParameterizedTest
    @CsvSource({
            "3, defabc, abcxyz",
            "29, defabc, abcxyz",
            "3, dEfAbC, abcxyz",
            "3, '', ''",
            "3, d e, a b",
            "3, d.e, a.b",
            "3, d-e, a-b",
            "3, d1e, a1b"
    })
    @DisplayName("Tests decoding strings")
    void itShouldDecodeStrings(int offset, String secret, String expected) {
        assertEquals(expected, CaesarCipher.decode(offset, secret));
    }
}
