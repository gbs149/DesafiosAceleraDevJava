package caesar_cipher;

import java.util.stream.Collectors;

public class CaesarCipher {

    private CaesarCipher() {
    }

    static String encode(int offset, String message) {
        return message.codePoints()
                .map(Character::toLowerCase)
                .map(c -> c - 97)
                .map(character -> encodeLetters(offset, character))
                .map(c -> c + 97)
                .mapToObj(Character::toChars)
                .map(String::new)
                .collect(Collectors.joining());
    }

    static String decode(int offset, String secret) {
        return encode(-offset, secret);
    }

    private static int encodeLetters(int offset, Integer character) {
        return isLowerCaseLetter(character)
                ? Math.floorMod(character + offset, 26)
                : character;
    }

    private static boolean isLowerCaseLetter(Integer character) {
        return character >= 0 && character <= 25;
    }

}
