import java.awt.*;
import java.util.Scanner;
public class Hangman {

    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String word;
        char[] guessWord;
        char guess;
        System.out.print("Enter a word you want to be guessed: ");
        word = scanner.nextLine();
        guessWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            System.out.println();
            System.out.print("Enter guess: ");

            guess = scanner.next().charAt(0);
            for (int j = 0; j < word.length(); j++) {
                if(guess == word.charAt(j)) {
                    guessWord[j] = guess;
                    count++;
                }
                if (count == word.length()) {
                    System.out.println("You won");
                    return;
                }
            }
            for (int j = 0; j < word.length(); j++) {
                if (guessWord[j] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(guessWord[j] + " ");
                }
            }
        }

    }
}

