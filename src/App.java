public class App {
    public static Board make;
    public static Player currPlayer;
    public static String gameState = "prep";
    //static may break the players, they were not desinged this way but were switched
    public static Player playerOne;
    public static Player playerTwo;

    public static void main(final String[] args) throws Exception {
        System.out.println();
        System.out.println("Hello, Welcome to Java Chess");
        System.out.println();

        Board.initBoard();

        Gui gamewindow = new Gui();
        String[] names = gamewindow.nameWindow();

        //Players need name assignments?
        playerOne = new Player(names[0]);
        Player.order[0] = playerOne;
        playerOne.setTeamColor("black");
        System.out.println();
        System.out.println("Name Player Two: ");
        playerTwo = new Player(names[1]);
        Player.order[1] = playerTwo;
        playerTwo.setTeamColor("white");

        gamewindow.gameWindowSetup();

        //player info
        System.out.println(Player.order[1].playerName + ": " + Player.order[1].getTeamColor());
        System.out.println(Player.order[0].playerName + ": " + Player.order[0].getTeamColor());
        
        currPlayer = playerTwo;
        gameState = "playing";

        System.out.println();
        System.out.println("To move a piece use this format without spaces. Piece,current # coordinate,current letter coordinate,future # coordinate,future letter coordinate");
        //need to change while loop to account for check happening between playertwo and playerone, needs to make sure the move won't put the king in check
        Board.print();
        Board.boardToJLabel();
        /*
        while(gameState.equals("playing")){
            System.out.println();
            System.out.println(playerTwo.playerName + "'s turn.");

            playerTwo.takeTurn();
            //replacing with boardToJLabel
            //Board.print();
            Board.boardToJLabel();
            if(Board.checkCheck())
                gameState = "check";
            System.out.println();
            System.out.println(playerOne.playerName + "'s turn.");
            playerOne.takeTurn();
            //replacing with boardToJLabel
            //Board.print();
            Board.boardToJLabel();
            if(Board.checkCheck())
                gameState = "check";
        }
        */
    }
    
    //impliment a loop that lets you play again, maybe add a start screen
}
