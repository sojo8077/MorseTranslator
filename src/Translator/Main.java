package Translator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Translator translator = new Translator();
        boolean run = true;

        ShowMenu();
        while (run) {
            System.out.print("Enter a number: ");
            int choice = translator.CheckNumber(scan.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Write text you want to translate.\n\nText:\n");
                    PrintTextToMorse(translator, scan.nextLine());
                }
                case 2 -> {
                    System.out.print("Write Morse code you want to translate. Separate letters with space, and words using \" / \".\n\nMorse Code:\n");
                    PrintMorseToText(translator, scan.nextLine());
                }
                case 3 -> {
                    run = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Write \"1\", \"2\", or \"3\".");
            }
        }
    }

    static void ShowMenu() {
        System.out.println("""
                -------------------------------
                1 - Translate from text
                2 - Translate from Morse code
                3 - Exit program
                -------------------------------
                """);
    }

    static void PrintTextToMorse(Translator t, String input) {
        t.TranslateText(input);
        if (t.GetSpecialChar()) {
            System.out.println("Some characters could not be translated.");
        }
        System.out.println("Morse Code:\n" + t.GetTranslation() + "\n");
    }

    static void PrintMorseToText(Translator t, String input) {
        t.TranslateMorse(input);
        if (t.GetSpecialChar()) {
            System.out.println("Some characters could not be translated.");
        }
        System.out.println("Text:\n" + t.GetTranslation() + "\n");
    }
}
