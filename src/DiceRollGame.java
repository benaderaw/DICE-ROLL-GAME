public class DiceRollGame {
    public static void main(String[] args){
        System.out.println("<===== OOP Practice: Dice Roll Game =====>");

        DiceGame dice = new DiceGame();

        dice.startGame();
    }
}

// GAME RULES
// get target number
// 2 players roll two dice until you get to target or as close to target
// double roles get bonus points - 2x rolled num
// players can stop any time
// go over target you lose, closest wins, perfect score auto wins with bonus point - 100 points