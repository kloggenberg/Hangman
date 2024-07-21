package hangman;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class HangmanUtils {

    private static final Random random = new Random();

    public static List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }

    public static String selectRandomWord(List<String> words) {
        int index = random.nextInt(words.size());
        return words.get(index).trim();
    }

    public static String randomFillWord(String word) {
        int index = random.nextInt(word.length());
        StringBuilder filledWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i == index) {
                filledWord.append(word.charAt(i));
            } else {
                filledWord.append('_');
            }
        }
        return filledWord.toString();
    }

    public static boolean isMissingChar(String originalWord, String answerWord, char c) {
        return !answerWord.contains(String.valueOf(c)) && originalWord.indexOf(c) != -1;
    }

    public static String fillInChar(String originalWord, String answerWord, char c) {
        StringBuilder newAnswer = new StringBuilder(answerWord);
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) == c) {
                newAnswer.setCharAt(i, c);
            }
        }
        return newAnswer.toString();
    }

    public static void drawFigure(int numberGuesses) {
        String[] stages = {
                """
/---- 
|   0 
|  /|\\ 
|   | 
|  / \\ 
_______
            """,
                """
|  | 
|  0 
| /|\\ 
| 
| 
________ 
            """,
                """
|  | 
|  0 
| /|\\ 
| 
| 
________ 
            """,
                """
/----
|
|
|
|
_______
            """,
                """
|  | 
| 0 
|
|
|
________ 
            """,
                """
| | 
|
|
|
|
________ 
            """
        };
        System.out.println(stages[6 - numberGuesses]);
    }
}
