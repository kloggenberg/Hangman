package hangman;

import java.util.List;

public class HangmanGame {

    private int guesses;
    private String word;
    private String answer;

    public HangmanGame() {
        this.guesses = 6;
    }

    public void startGame() {
        String wordsFile = HangmanDisplay.askFileName();
        List<String> words = HangmanUtils.readFile(wordsFile);
        this.word = HangmanUtils.selectRandomWord(words);
        this.answer = HangmanUtils.randomFillWord(this.word);
        runGameLoop();
    }

    private void runGameLoop() {
        System.out.println("Guess the word: " + answer);
        while (!answer.equals(word) && guesses > 0) {
            String guess = HangmanDisplay.getUserInput();
            if (guess.equals("exit") || guess.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            char guessChar = guess.charAt(0);
            if (HangmanUtils.isMissingChar(word, answer, guessChar)) {
                answer = HangmanUtils.fillInChar(word, answer, guessChar);
                HangmanDisplay.doCorrectAnswer(answer);
            } else {
                guesses--;
                HangmanDisplay.doWrongAnswer(guesses);
            }
        }
        if (answer.equals(word)) {
            HangmanDisplay.victoryMessage();
        } else if (guesses == 0) {
            HangmanDisplay.gameOverMessage(word);
        }
    }

    public static void main(String[] args) {
        new HangmanGame().startGame();
    }
}
