import java.util.Scanner;
public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        String guess;
        int guessCount = 5;
        System.out.print("Enter a word you want to be guessed: ");
        word = scanner.nextLine();
        for (int i = 0; i < guessCount; i++) {
            System.out.print("Enter guess: ");
            guess = scanner.nextLine();
        }

    }
}

