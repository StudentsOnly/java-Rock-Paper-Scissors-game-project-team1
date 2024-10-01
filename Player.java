abstract class Player {

    String name;
    int score;
    abstract String getName();
    abstract int getScore();
    abstract ChoiceType makeChoice();
    public void updateScore(){
        score++;
    }

}
