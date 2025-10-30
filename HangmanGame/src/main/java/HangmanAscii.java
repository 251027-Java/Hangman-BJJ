public class HangmanAscii {

    public static String getHangmanArt(int wrongGuesses) {
        switch (wrongGuesses) {
            case 0:
                return """
                       
                       
                       
                       
                       
                       
                       """;
            case 1:
                return """
                          -----
                          |   |
                          |
                          |
                          |
                          |
                       -------
                       """;
            case 2:
                return """
                          -----
                          |   |
                          |   O
                          |
                          |
                          |
                       -------
                       """;
            case 3:
                return """
                          -----
                          |   |
                          |   O
                          |   |
                          |
                          |
                       -------
                       """;
            case 4:
                return """
                          -----
                          |   |
                          |   O
                          |  /|
                          |
                          |
                       -------
                       """;
            case 5:
                return """
                          -----
                          |   |
                          |   O
                          |  /|\\
                          |
                          |
                       -------
                       """;
            case 6:
                return """
                          -----
                          |   |
                          |   O
                          |  /|\\
                          |  /
                          |
                       -------
                       """;
            case 7:
                return """
                          -----
                          |   |
                          |   O
                          |  /|\\
                          |  / \\
                          |
                       -------
                       """;
            default:
                return "Invalid number of wrong guesses.";
        }
    }
}