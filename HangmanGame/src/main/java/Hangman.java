import java.awt.*;
import java.util.Scanner;
public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        char[] guessWord;
        char guess;
        int guessCount = 5;
        System.out.print("Enter a word you want to be guessed: ");
        word = scanner.nextLine();
        guessWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            System.out.print("Enter guess: ");
            guess = scanner.next().charAt(0);
            for (int j = 0; j < word.length(); j++) {
                if(guess == word.charAt(j)) {
                    guessWord[j] = guess;
                }

            }
            System.out.println(guessWord);
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (guessWord[i] == word.charAt(i)) {
                count++;
            }
        }
        if (count == word.length()) {
            System.out.println("You Won");
        } else {
            System.out.println("You Lost");
        }

    }
}

