import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
public class Hangman {
    public static void main(String[] args) {

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
        Scanner scanner = new Scanner(System.in);
        char guess;
        while (wrongGuesses < maxGuesses && correctCount < word.length()) {
            System.out.println(hangman.getHangmanArt(wrongGuesses));
            System.out.println();

            System.out.print("Current word: ");
            for (char c : guessWord) {
                System.out.print(c == 0 ? "_ " : c + " ");
            }
            System.out.println();
            System.out.println("Wrong guesses: " + (wrongGuesses - 1) + " / " + (maxGuesses - 1));

            System.out.print("Enter guess: ");
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please Enter a Single Letter");
                    continue;
                }

                guess = input.charAt(0);
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
                    scanner.close();
                    return;
                }


            } catch (Exception e) {
                System.out.println("Exception: " + e);

            }

        }
            System.out.println(hangman.getHangmanArt(7));
            System.out.println("\n💀 You lost! The word was: " + word);
            scanner.close();
    }

}
