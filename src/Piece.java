public class Piece extends Player{

    public int x , moveRangeLR, moveRangeUD;
    public int inty;
    public String y;
    public String pieceType;
   

    public final static String[] spaceNames = {"a", "b", "c" , "d" , "e", "f", "g", "h"};

    //converts y string to int value, returns -1 if the string does not match the spaceNames table
    public static int getInt(String s){
        for(int i = 0; i < spaceNames.length; i++){
            if(spaceNames[i].toLowerCase().equals(s))
                return i;
        }
        return -1;
    }

    public Piece(String teamName, int xIn, int yIn, int moveRangeLR, int moveRangeUD, String pieceType) {
        super(teamName);
        this.x = xIn;
        this.moveRangeLR = moveRangeLR;
        this.moveRangeUD = moveRangeUD;
        this.y = spaceNames[yIn];
        this.inty = yIn;
    }
    
    public String getSpace(){return  y + " " + x;}
    
    //in place to prevent error
    public boolean validMove(int newx, String newy){
        System.out.println("The wrong validMove method is being called.");
        return false;
    }
    
    public void move(int newx, String newy){System.out.println("The wrong move method is being called.");}

    //returns the piece at those coordinates
    public Piece pieceInSpace(int xcoord, int ycoord){return Board.boardSpaces[inty][x];}

    //updates coordinates of piece
    public void updateCoords(){
        
    }



    //https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode for the unicode characters of chess pieces

    public void print(){
        System.out.println();
    }
    public void addToJLabel(){
        //does nothing
    }

    public String getString(){
        return "";
    }

    public void removePiece(int x, int y){


    }

    //add try and except to each validMove() to prevent errors. also add to parseINt()??
}
