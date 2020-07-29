package app;

import java.util.Scanner;
import java.util.ArrayList;

public class Player {
    //variables
    public String teamColor;
    public final String playerName;
    public static Player[] order = new Player[2];
    private Scanner scanMove;

    //construtors
    public Player(String assignName) {
        playerName = assignName;
        if(order[0] == this){
            teamColor = "black";
        }
        else
            teamColor = "white";
    }
    
    //methods
	public String getTeamColor() {return teamColor;}

    public void setTeamColor(String newTeamColor) {this.teamColor = newTeamColor;}
    
    public void takeTurn(){
        App.currPlayer = this;
        scanMove = new Scanner(System.in);
        String move = scanMove.nextLine();
        //puts user output into Arraylist
        ArrayList<String> letters = new ArrayList<String>();
        for(int i = 0; i < move.length(); i++){
            letters.add(move.substring(i, i + 1).toLowerCase());}
        //splits the input into parts to put in arguments
        String [] input = new String [5];
        int lowerlimit = 0;
        int stage = 0;
        int istage1;
        int istage3;
        for(int i = 0; i < letters.size(); i++){
            if(letters.get(i).equals(",")){
                input[stage] = move.substring(lowerlimit, i);
                lowerlimit = i + 1;
                stage++;}
            else if(stage == 4)
                input[4] = move.substring(lowerlimit);            
        }
        istage1 = Integer.parseInt(input[1]);
        istage3 = Integer.parseInt(input[3]);
        
        try{
            Board.boardSpaces[Piece.getInt(input[2])][istage1].move(istage3, input[4]);
        }
        catch(ArrayIndexOutOfBoundsException arrExcept){
            System.out.println("Something happened");
        }
        catch(Exception e){
            System.out.println("Incorrect input formatting.");
        }
        
        /** testing user input system and parsing
        System.out.println();
        System.out.println("Piece type: " + input[0]);
        System.out.println("X coordinate: " + istage1);
        System.out.println("Y coordinate: " + input[2]);
        System.out.println("Next X coordinate: " + istage3);
        System.out.println("Next Y coordinate: " + input[4]);
        System.out.println("X coord difference: " + (istage1 - istage3));
        
        //Board.boardSpaces[istage1][Piece.getInt(input[2])].move(istage3, input[4]);
        //*/
    }

            
    //impliment a way to make sure that the pieces are on the board, should includes null protection
        
        
    //impliment a method for moving the pieces, calls the validmove method
        
        
    //impliment a method for taking the pieces off the board when they are defeated, replaces the space with null
}