import java.util.Scanner;

public class DiceGame {

    //Objects
    Scanner scanner = new Scanner(System.in);
    Dice dice = new Dice();

    // FIELDS
    private String player;
    private int diceOneResult;
    private int diceTwoResult;

    public void startGame(){
        System.out.println("\n<=== GAME STARTED ===>");
        System.out.println(dice.targetNum());
        player = "player1";
        String player1Input = "";
        String player2Input = "";


        while(true){

            if(player.equals("player1")){
                System.out.println("=== TURN: PLAYER 1 ===");
                System.out.print("What would you like to do, roll / stop: ");
                player1Input = scanner.nextLine().toLowerCase().trim();

                while(true){
                    switch (player1Input){
                        case "roll":
                            diceOneResult = dice.rollDice();
                            diceTwoResult = dice.rollDice();
                            System.out.println(diceOneResult);
                            System.out.println(diceTwoResult);
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
                System.out.println("=== TURN: PLAYER 2 ===");
                System.out.print("What would you like to do, roll / stop: ");
                player2Input = scanner.nextLine();

                while(true){
                    switch (player2Input){
                        case "roll":
                            diceOneResult = dice.rollDice();
                            diceTwoResult = dice.rollDice();
                            System.out.println(diceOneResult);
                            System.out.println(diceTwoResult);
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

}
