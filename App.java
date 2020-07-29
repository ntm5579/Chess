package app;

import java.util.Scanner;

public class App {
    public static Board make;
    private static Scanner scanName1;
    private static Scanner scanName2;
    public static Player currPlayer;
    public static String gameState = "prep";

    public static void main(final String[] args) throws Exception {
        System.out.println();
        System.out.println("Hello, Welcome to Java Chess");
        System.out.println();

        //takes input for names and assigns team colors to each player
        scanName1 = new Scanner(System.in);
        System.out.println("Name Player One: ");
        final Player playerOne = new Player(scanName1.nextLine());
        Player.order[0] = playerOne;
        playerOne.setTeamColor("black");
        System.out.println();

        scanName2 = new Scanner(System.in);
        System.out.println("Name Player Two: ");
        final Player playerTwo = new Player(scanName2.nextLine());
        Player.order[1] = playerTwo;
        playerTwo.setTeamColor("white");
        System.out.println();

        //player info
        System.out.println(Player.order[1].playerName + ": " + Player.order[1].getTeamColor());
        System.out.println(Player.order[0].playerName + ": " + Player.order[0].getTeamColor());
        
        Board.initBoard();
        
        currPlayer = playerTwo;
        gameState = "playing";

        System.out.println();
        System.out.println("To move a piece use this format without spaces. Piece,current # coordinate,current letter coordinate,future # coordinate,future letter coordinate");
        //need to change while loop to account for check happening between playertwo and playerone, needs to make sure the move won't put the king in check
        Board.print();
        while(gameState.equals("playing")){
            System.out.println();
            System.out.println(playerTwo.playerName + "'s turn.");
            playerTwo.takeTurn();
            Board.print();
            if(Board.checkCheck())
                gameState = "check";
            System.out.println();
            System.out.println(playerOne.playerName + "'s turn.");
            playerOne.takeTurn();
            Board.print();
            if(Board.checkCheck())
                gameState = "check";
        }
    }
}