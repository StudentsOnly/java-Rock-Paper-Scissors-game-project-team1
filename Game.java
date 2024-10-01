import java.util.Scanner;

public class Game {
    private Player player;
    private Player opponent;
    private int rounds = 0;

    public Game(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void play() {
        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Welcome to Rock, Paper, Scissors Game!");
            while (true) {
                System.out.println("\n*** Round " + (rounds + 1) + " ***");

                ChoiceType playerChoice = player.makeChoice();
                ChoiceType opponentChoice = opponent.makeChoice();

                System.out.println(player.getName() + " chose: " + playerChoice);
                System.out.println(opponent.getName() + " chose: " + opponentChoice);

                String result = determineWinner(playerChoice, opponentChoice);
                System.out.println(result);

                updateScore(result);
                rounds++;

                System.out.println("Score: " + player.getName() + " " + player.getScore() + " - " + opponent.getScore() + " " + opponent.getName());

                System.out.print("Do you want to play another round? (yes/no): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("yes")) {
                    break;
                }
            }

            System.out.println("\nGame Over!");
            System.out.println("Final Score: " + player.getName() + " " + player.getScore() + " - " + opponent.getScore() + " " + opponent.getName());
        }
    }

    private void updateScore(String result) {
        if (result.contains("You win")) player.updateScore();
        else if (result.contains("Opponent wins"))  opponent.updateScore();
    }

    private String determineWinner(ChoiceType playerChoice, ChoiceType opponentChoice) {
        if (playerChoice == opponentChoice) {
            return "It's a tie!";
        }

        return switch (playerChoice) {
            case ChoiceType.ROCK ->
                    (opponentChoice == ChoiceType.SCISSORS) ? "Rock crushes Scissors. You win!" : "Paper covers Rock. Opponent wins!";
            case ChoiceType.PAPER ->
                    (opponentChoice == ChoiceType.ROCK) ? "Paper covers Rock. You win!" : "Scissors cuts Paper. Opponent wins!";
            case ChoiceType.SCISSORS ->
                    (opponentChoice == ChoiceType.PAPER) ? "Scissors cuts Paper. You win!" : "Rock crushes Scissors. Opponent wins!";
            default -> "Error: Unknown result.";
        };
    }
}

