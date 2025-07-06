import java.util.Scanner;

public class DiceGame {

    // OBJECTIVES
    // add players 🟢
    // player input 🟢
    // implement simple player turn logic 🟢
    // track rolls results  🟢
    // implement win/lose 🔴
    // implement full player turn logic 🟢

    //Objects
    Scanner scanner = new Scanner(System.in);
    Dice dice = new Dice();

    // FIELDS
    private String player;
    private int targetNum;
    private int diceOneResult;
    private int diceTwoResult;
    private int playerOneScore;
    private int playerTwoScore;
    private boolean isPlayerOneStopped;
    private boolean isPlayerTwoStopped;

    public DiceGame(){
        this.player = "player1";
        this.isPlayerOneStopped = false;
        this.isPlayerTwoStopped = false;
    }

    // start game
    public void startGame() {
        System.out.println("\n<=== GAME STARTED ===>");

        // get score target
        targetNum = dice.targetNum();

        // player turns
        while (true) {
            // check if both players stoped
            if(isPlayerOneStopped && isPlayerTwoStopped){
                break;
            }

            // check if player went over target
            if(playerOneScore > targetNum || playerTwoScore > targetNum){
                break;
            }

            // check if players1 stoped
            if(isPlayerOneStopped){
                player = "player2";
            }

            // check if players2 stoped
            if(isPlayerTwoStopped){
                player = "player1";
            }

            // take turns ro roll dice
            if (player.equals("player1")) {
                playerRollDice();
            }else{
                playerRollDice();
            }

            // change player
            player = (player.equals("player1")) ? "player2" : "player1";
        }

        System.out.println("Game has ended!");
    }

    // METHODS
    // player roll dice and keeps score
    public void playerRollDice(){
        String playersTurn = (this.player.equals("player1")) ? "Player 1" : "player 2";

        System.out.println("Turn: " + playersTurn);
        System.out.println("🎯 " + targetNum + "     Player One: " + playerOneScore + "     Player Two: " + playerTwoScore);
        System.out.print("What would you like to do, roll / stop: ");
        String playerInput = scanner.nextLine().toLowerCase().trim();

        while(true){
            switch (playerInput){
                case "roll":
                    // dice rolls
                    diceOneResult = dice.rollDice();
                    diceTwoResult = dice.rollDice();

                    // roll display
                    rollResultDisplay();

                    // get dice result sum
                    int rollPoints = roleSum(diceOneResult, diceTwoResult);
                    System.out.println("\n✨+" + rollPoints + " points");
                    if(player.equals("player1")){
                        playerOneScore += rollPoints;

                    }else{
                        playerTwoScore += rollPoints;
                    }
                    break;
                case "stop":
                    if(player.equals("player1")){
                        isPlayerOneStopped = true;
                    }else{
                        isPlayerTwoStopped = true;
                    }
                    break;
                default:
                    System.out.println("🔶Type 'roll' or 'stop' please...");
            }

            System.out.print("\n");
            break;
        }
    }

    // dice role display
    private void rollResultDisplay(){
        for(int i = 0; i < diceOneResult; i++){
            System.out.print("🎲");
        }
        System.out.print(" " + "(" + diceOneResult + ")\n");

        //
        for(int i = 0; i < diceTwoResult; i++){
            System.out.print("🎲");
        }
        System.out.print(" " + "(" + diceTwoResult + ")");
    }

    // sum of two dice rolls
    private int roleSum(int diceOneResult, int diceTwoResult){
        return (diceOneResult + diceTwoResult);
    }

}
