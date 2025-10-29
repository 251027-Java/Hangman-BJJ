import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanAscii hangman = new HangmanAscii();
        String[] words = {
                "java", "computer", "hangman", "developer", "keyboard",
                "internet", "software", "variable", "function", "compile",
                "object", "class", "inheritance", "exception", "loop",
                "array", "syntax", "algorithm", "runtime", "method",
                "stack", "queue", "string", "integer", "boolean",
                "package", "library", "framework", "scanner", "input"
        };
        Set<Character> guessedLetters = new HashSet<>();


        Random rand = new Random();

        String word = words[rand.nextInt(words.length)];

        char[] guessWord = new char[word.length()];
        int correctCount = 0;
        int wrongGuesses = 1;
        int maxGuesses = 7;

        while (wrongGuesses < maxGuesses && correctCount < word.length()) {
            System.out.println(hangman.getHangmanArt(wrongGuesses));
            System.out.println();
            System.out.println("Wrong guesses: " + (wrongGuesses - 1) + " / " + (maxGuesses - 1));
            System.out.print("Current word: ");
            for (char c : guessWord) {
                System.out.print(c == 0 ? "_ " : c + " ");
            }
            System.out.println();

            System.out.print("Enter guess: ");
            char guess = Character.toLowerCase(scanner.next().charAt(0));

            if (guessedLetters.contains(guess)) {
                System.out.println("⚠️ You already guessed '" + guess + "'. Try a different letter!");
                continue; // skip this round
            } else {
                guessedLetters.add(guess);
            }


            boolean correct = false;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == guess && guessWord[j] == 0) {
                    guessWord[j] = guess;
                    correctCount++;
                    correct = true;
                }
            }

            if (!correct) {
                wrongGuesses++;

            }

            if (correctCount == word.length()) {
                System.out.println("\n🎉 You won! The word was: " + word);
                return;
            }
        }
        System.out.println(hangman.getHangmanArt(7));
        System.out.println("\n💀 You lost! The word was: " + word);
    }
}
