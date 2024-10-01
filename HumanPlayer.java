import java.util.Scanner;

public class HumanPlayer extends Player{

    private Scanner scan;


    public HumanPlayer(String name){
        this.name = name;
        this.score = 0;
        scan = new Scanner(System.in);
    }
    public HumanPlayer(){
        this.name = "Player1";
        this.score = 0;
        scan = new Scanner(System.in);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getScore() {
        return score;
    }


    @Override
    public ChoiceType makeChoice() {
        String input;
        while(true) {
            System.out.println("Make your choice:\n\tRock, Paper or Scissors:");
            input = scan.nextLine().trim().toLowerCase();
            switch(input){
                case "rock":
                    return ChoiceType.ROCK;
                case "paper":
                    return ChoiceType.PAPER;
                case "scissors":
                    return ChoiceType.SCISSORS;
            }
            System.out.println("Incorrect input, try again:");
        }
    }
}
