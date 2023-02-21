package Translator;

import java.util.HashMap;

public class Translator {
    public Translator() { }

    private final HashMap<Character, String> englishToMorse = new HashMap<>() {{
        put('A', ".-");
        put('B', "-...");
        put('C', "-.-.");
        put('D', "-..");
        put('E', ".");
        put('F', "..-.");
        put('G', "--.");
        put('H', "....");
        put('I', "..");
        put('J', ".---");
        put('K', "-.-");
        put('L', ".-..");
        put('M', "--");
        put('N', "-.");
        put('O', "---");
        put('P', ".--.");
        put('Q', "--.-");
        put('R', ".-.");
        put('S', "...");
        put('T', "-");
        put('U', "..-");
        put('V', "...-");
        put('W', ".--");
        put('X', "-..-");
        put('Y', "-.--");
        put('Z', "--..");
        put('1', ".----");
        put('2', "..---");
        put('3', "...--");
        put('4', "....-");
        put('5', ".....");
        put('6', "-....");
        put('7', "--...");
        put('8', "---..");
        put('9', "----.");
        put('0', "-----");
        put('.', ".-.-.-");
        put(',', "--..--");
        put('?', "..--..");
        put(' ', "/");
    }};
    private final HashMap<String, Character> morseToEnglish = new HashMap<>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
        put("-----", '0');
        put(".-.-.-", '.');
        put("--..--", ',');
        put("..--..", '?');
        put("/", ' ');
    }};
    private StringBuilder translation;
    private boolean specialChar = false;

    public int CheckNumber(String input) {
        int choice;
        try {
            choice = Integer.parseInt(input.trim());
        } catch (Exception e) {
            choice = 0;
        }
        return choice;
    }

    public void TranslateText(String input) {
        translation = new StringBuilder();
        specialChar = false;
        input = input.trim().replaceAll(" +", " ").toUpperCase();
        char[] inputArr = input.toCharArray();
        for (char c : inputArr) {
            if (englishToMorse.containsKey(c)) {
                translation.append(" ").append(englishToMorse.get(c));
            } else {
                specialChar = true;
                translation.append(" x");
            }
        }
        translation = new StringBuilder(translation.toString().trim());
    }

    public void TranslateMorse(String input) {
        translation = new StringBuilder();
        specialChar = false;
        input = input.trim().replaceAll(" +", " ").toUpperCase();
        String[] inputArr = input.split(" ");
        for (String s : inputArr) {
            if (morseToEnglish.containsKey(s)) {
                translation.append((morseToEnglish.get(s)));
            } else {
                specialChar = true;
                translation.append("x");
            }
        }
        translation = new StringBuilder(translation.toString().trim());
    }

    public StringBuilder GetTranslation() {
        return translation;
    }

    public boolean GetSpecialChar() {
        return specialChar;
    }

    /*
    private <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }*/
}
