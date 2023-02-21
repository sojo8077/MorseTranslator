package Translator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TranslatorTest {
    @Test
    public void TranslateText() {
        Translator translator = new Translator();
        translator.TranslateText(" HELLO    World");

        String expected = (".... . .-.. .-.. --- / .-- --- .-. .-.. -..");
        String actual = translator.GetTranslation().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TranslateMorse() {
        Translator translator = new Translator();
        translator.TranslateMorse("  .... . .-.. .-.. --- / .-- --- .-. .-.. -.. / hello / world");

        String expected = ("HELLO WORLD x x");
        String actual = translator.GetTranslation().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CheckNumber() {
        Translator translator = new Translator();
        int choice = translator.CheckNumber(" 1  ");

        int expected = 1;
        int actual = choice;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CheckNumberABC() {
        Translator translator = new Translator();
        int choice = translator.CheckNumber("ABC");

        int expected = 0;
        int actual = choice;

        Assertions.assertEquals(expected, actual);
    }
}
