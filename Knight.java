package app;

/**
 * Knight
 */
public class Knight extends Piece{

    public Knight(String teamName, int x, int y, int moveRangeLR, int moveRangeUD) {
        super(teamName, x, y, moveRangeLR, moveRangeUD, "Knight");
    }
    
    public boolean validMove(int newx, String newy){
        if((Board.boardSpaces[Piece.getInt(y)][x] != null) && pieceInSpace(x,Piece.getInt(y)).getTeamColor() == App.currPlayer.getTeamColor()){ 
            int xdistance = Math.abs(newx - this.x);
            int ydistance = Math.abs(newy.toLowerCase().compareTo(this.y.toLowerCase()));
            return(xdistance == 3 && ydistance == 2) || (xdistance == 2 && ydistance == 3);}
            else
                return false;
    }
        
    public void print(){
        if(teamColor.equals("white")){
            System.out.print("  " + "\u2658" + " ");
        }
        else{
            System.out.print("  " + "\u265E" + " ");
        }
    }

    //edits Board.boardspaces with new local of the piece
    public void move(int newx, String newy){
        if(validMove(newx, newy)){
            if(Board.boardSpaces[Piece.getInt(newy)][newx] == null)
                Board.boardSpaces[x][inty] = null;
            else
                removePiece(newx, Piece.getInt(newy));
            x = newx;
            y = newy;
            inty = Piece.getInt(newy);
            Board.boardSpaces[inty][x] = this;

        }
        else{
            System.out.println("Invalid move, Input again.");
            App.currPlayer.takeTurn();
        }
        
    }
}