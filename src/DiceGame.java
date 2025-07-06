import java.util.Scanner;

public class DiceGame {

    // OBJECTIVES
    // add players 🟢
    // player input 🟢
    // implement simple player turn logic 🟢
    // track rolls results  🟢
    // implement win/lose 🔴
    // implement full player turn logic 🔴

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

    public void startGame(){
        System.out.println("\n<=== GAME STARTED ===>");
        // FIELDS
        player = "player1";
        String player1Input = "";
        String player2Input = "";

        // get score target
        targetNum = dice.targetNum();


        // player turns
        while(true){
            if (player.equals("player1")){
                System.out.println("Turn: Player 1");
                System.out.println("🎯 " + targetNum + "     Player One: " + playerOneScore + "     Player Two: " + playerTwoScore);
                System.out.print("What would you like to do, roll / stop: ");
                player1Input = scanner.nextLine().toLowerCase().trim();

                while(true){
                    switch (player1Input){
                        case "roll":
                            // roll two dice
                            diceOneResult = dice.rollDice();
                            diceTwoResult = dice.rollDice();
                            System.out.println("🎲 Dice One: " + diceOneResult);
                            System.out.println("🎲 Dice Two: " + diceTwoResult);

                            // get dice result sum
                            int rollPoints = roleSum(diceOneResult, diceTwoResult);
                            playerOneScore = playerOneScore + roleSum(diceOneResult, diceTwoResult);
                            System.out.println("+" + rollPoints);

                            break;
                        case "stop":
                            break;
                        default:
                            System.out.println("🔶Type roll or stop please...");
                    }

                    System.out.print("\n");
                    break;
                }
            }else if(player.equals("player2")){
                System.out.println("Turn: Player 2");
                System.out.println("🎯 " + targetNum + "     player One: " + playerOneScore + "     player Two: " + playerTwoScore);
                System.out.print("What would you like to do, roll / stop: ");
                player2Input = scanner.nextLine().toLowerCase().trim();

                while(true){
                    switch (player2Input){
                        case "roll":
                            diceOneResult = dice.rollDice();
                            diceTwoResult = dice.rollDice();
                            System.out.println(diceOneResult);
                            System.out.println(diceTwoResult);

                            // get dice result sum
                            int rollPoints = roleSum(diceOneResult, diceTwoResult);
                            playerTwoScore = playerTwoScore + roleSum(diceOneResult, diceTwoResult);
                            System.out.println("+" + rollPoints);

                            break;
                        case "stop":
                            break;
                        default:
                            System.out.println("🔶Type roll or stop please...");
                    }

                    System.out.print("\n");
                    break;
                }

            }else{
                System.out.println("🔴[ERROR] Player not selected...");
            }


            player = (player.equals("player1")) ? "player2" : "player1";
        }
    }

    // METHODS
    private int roleSum(int diceOneResult, int diceTwoResult){
        return (diceOneResult + diceTwoResult);
    }

}
