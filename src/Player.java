import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private boolean hasStopped;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.hasStopped = false;
    }

    public void playerScore(int points){
        score += points;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', score=" + score + "has stopped='" + hasStopped + "}";
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean getHasStopped(){
        return hasStopped;
    }

    // SETTER
    public void setName(String name){
        this.name = name;
    }

    public void setHasStopped(boolean hasStopped){
        this.hasStopped = hasStopped;
    }
}
