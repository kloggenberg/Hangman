package hangman;

import java.util.Scanner;

public class HangmanDisplay {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        System.out.print("Guess the missing letter: ");
        return scanner.nextLine().toLowerCase();
    }

    public static String askFileName() {
        System.out.print("Words file? [leave empty to use short_words.txt] : ");
        String fileName = scanner.nextLine();
        return fileName.isEmpty() ? "words/short_words.txt" : fileName;
    }

    public static void doCorrectAnswer(String answer) {
        System.out.println(answer);
    }

    public static void doWrongAnswer(int numberGuesses) {
        System.out.println("Wrong! Number of guesses left: " + numberGuesses);
        HangmanUtils.drawFigure(numberGuesses);
    }

    public static void gameOverMessage(String word) {
        System.out.println("Sorry, you are out of guesses. The word was: " + word);
    }

    public static void victoryMessage() {
        System.out.println("Congratulations! You've guessed the word!");
    }
}
