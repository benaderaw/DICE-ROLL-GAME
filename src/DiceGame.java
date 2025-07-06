import java.util.Scanner;

public class DiceGame {

    // OBJECTIVES
    // add players 🟢
    // player input 🟢
    // implement simple player turn logic 🟢
    // track rolls results  🟢
    // implement win/lose 🟢
    // implement full player turn logic 🟢
    // double points 🟢

    // OBJECTS
    Scanner scanner = new Scanner(System.in);
    Dice dice = new Dice();

    // FIELDS
    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");
    private Player currentPlayer;
    private int targetNum;
    private int diceOneResult;
    private int diceTwoResult;
    private boolean gotMultiplier;

    // start game
    public void startGame() {
        System.out.println("\n<=== GAME STARTED ===>");

        // get players name
        getPlayerNames();

        // get getScore() target
        targetNum = dice.targetNum();

        currentPlayer = player1;

        // player turns
        while (true) {
            // check if both players stoped
            if(player1.getHasStopped() && player2.getHasStopped()) {
                Player winner = player1.getScore() > player2.getScore() ? player1 : player2;
                System.out.println("🎉🎉🎉 " + winner.getName() + " has WON! 🎉🎉🎉");
                break;
            }

            // check if players1 stoped
            if(currentPlayer.getHasStopped()){
                currentPlayer = switchPlayers();
                continue;
            }

            // current player rolls dice
            playerRollDice();

            // check if player reached the target number exactly
            if (currentPlayer.getScore() == targetNum) {
                System.out.println("WOW! " + currentPlayer.getName() + " has reached the target number EXACTLY!");
                System.out.println("🎉🎉🎉🎉🎉 " + currentPlayer.getName() + " has WON! 🎉🎉🎉🎉🎉");
                break;
            }

            // check if current players went over target
            if(currentPlayer.getScore() > targetNum){
                Player otherPlayer = currentPlayer == player1 ? player2 : player1;
                System.out.println("You went over the target number of " + targetNum + ".");
                System.out.println("🎉🎉🎉 " + otherPlayer.getName() + " has WON! 🎉🎉🎉");
                break;
            }

            // change player
            currentPlayer = switchPlayers();
        }

        System.out.println("Game has ended!");
    }

    // get players name
    private void getPlayerNames(){
        System.out.print("Player 1 name: ");
        player1.setName(scanner.nextLine());

        while(true){
            System.out.print("Player 2 name: ");
            player2.setName(scanner.nextLine());
            if(player2.getName().equalsIgnoreCase(player1.getName())){
                System.out.println("Names can not be identical");
                continue;
            }
            break;
        }
        System.out.print("\n");
    }

    // player roll dice and keeps getScore()
    private void playerRollDice(){
        System.out.println("🎯Target: " + targetNum + "      " + "👤Player: " + currentPlayer.getName().toUpperCase());
        String playerInput;

        OuterLoop:
        while(true){
            if(currentPlayer.getScore() == 0){
                System.out.print("Type 'roll' to start your turn: ");
            }else{
                System.out.print("What would you like to do, roll / stop: ");
            }
            playerInput = scanner.nextLine().toLowerCase().trim();

            switch (playerInput){
                case "roll":
                    // dice rolls
                    diceOneResult = dice.rollDice();
                    diceTwoResult = dice.rollDice();

                    // see if both dice land on the same side
                    if(diceOneResult == diceTwoResult){
                        gotMultiplier = true;
                    }

                    // get points/sides sum
                    int rollPoints = roleSum(diceOneResult, diceTwoResult, gotMultiplier);

                    // rolled dice and getScore()/points display
                    diceDisplay();
                    scoreDisplay(rollPoints);

                    // player total getScore()
                    currentPlayer.playerScore(rollPoints);
                    break;
                case "stop":
                    if(currentPlayer.getScore() == 0){
                        System.out.println("🔶You have to roll on your first turn...\n");
                        continue;
                    }
                    currentPlayer.setHasStopped(true);
                    break;
                default:
                    if(currentPlayer.getScore() == 0){
                        System.out.println("🔶Type 'roll' please...\n");
                        continue;
                    }
                    System.out.println("🔶Type 'roll' or 'stop' please...\n");
                    continue;
            }
            System.out.println("🎯 " + targetNum + "     " + player1.getName() + ": " + player1.getScore() + "     " + player2.getName() + ": " + player2.getScore());
            System.out.print("\n\n");
            gotMultiplier = false;
            break;
        }
    }

    // switch player
    private Player switchPlayers(){
        return currentPlayer == player1 ? player2 : player1;
    }

    // dice role console display
    private void diceDisplay(){
        // first dice
        for(int i = 0; i < diceOneResult; i++){
            System.out.print("🎲");
        }
        System.out.print(" " + "(" + diceOneResult + ")\n");

        // second dice
        for(int i = 0; i < diceTwoResult; i++){
            System.out.print("🎲");
        }
        System.out.print(" " + "(" + diceTwoResult + ")");

    }

    // getScore() console display
    private void scoreDisplay(int rollPoints){
        String stars = gotMultiplier ? "🌟" : "✨";
        if(gotMultiplier){
            System.out.println("\n" + stars + "+" + rollPoints + " points " + stars);
        }else{
            System.out.println("\n" + stars + "+" + rollPoints + " points");
        }
    }

    // sum of two dice rolls
    private int roleSum(int diceOneResult, int diceTwoResult, boolean gotMultiplier){
        if(gotMultiplier){
            return  (diceOneResult + diceTwoResult) * 2;
        }

        return (diceOneResult + diceTwoResult);
    }

}
