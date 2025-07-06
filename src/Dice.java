import java.util.Random;

public class Dice {
    // OBJECTS
    Random random = new Random();

    // METHODS
    // target number
    public int targetNum(){
        return random.nextInt(6, 20);
    }

    // roll dice
    public int rollDice(){
        return random.nextInt(1, 7);
    }

}
