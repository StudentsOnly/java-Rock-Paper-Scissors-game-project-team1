import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player{
    Random randomNum;

    public ComputerPlayer(){
        this.name = "Player2";
        this.score = 0;
        randomNum  = new Random();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public ChoiceType makeChoice() {
        ChoiceType choice;

        int num = randomNum.nextInt(3);
        switch(num){
            case 0:
                choice = ChoiceType.ROCK;
                break;
            case 1:
                choice = ChoiceType.PAPER;
                break;
            case 2:
                choice = ChoiceType.SCISSORS;
                break;
            default:
                System.out.println("Something went wrong!" + num);
                choice = null;
        }
       return choice;
    }
}
