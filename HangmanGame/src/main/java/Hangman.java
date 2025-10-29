import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanAscii hangman = new HangmanAscii();

        System.out.print("Enter a word you want to be guessed: ");
        String word = scanner.nextLine().toLowerCase();

        char[] guessWord = new char[word.length()];
        int correctCount = 0;
        int wrongGuesses = 0;
        int maxGuesses = 7;

        while (wrongGuesses < maxGuesses && correctCount < word.length()) {
            System.out.println();
            System.out.println("Wrong guesses: " + wrongGuesses + " / " + maxGuesses);
            System.out.print("Current word: ");
            for (char c : guessWord) {
                System.out.print(c == 0 ? "_ " : c + " ");
            }
            System.out.println();

            System.out.print("Enter guess: ");
            char guess = Character.toLowerCase(scanner.next().charAt(0));

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
                System.out.println(hangman.getHangmanArt(wrongGuesses));
            }

            if (correctCount == word.length()) {
                System.out.println("\n🎉 You won! The word was: " + word);
                return;
            }
        }

        System.out.println("\n💀 You lost! The word was: " + word);
    }
}
