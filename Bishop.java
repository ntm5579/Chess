package app;

/**
 * Bishop
 */
public class Bishop extends Piece{

    public Bishop(final String teamName, final int x, final int y, final int moveRangeLR, final int moveRangeUD) {
        super(teamName, x, y, moveRangeLR, moveRangeUD, "Bishop");
    }

    public boolean validMove(int newx, String newy){
        if((Board.boardSpaces[Piece.getInt(y)][x] != null) && pieceInSpace(x,Piece.getInt(y)).getTeamColor() == App.currPlayer.getTeamColor()){
            int xdistance = Math.abs(newx - this.x);
            int ydistance = Math.abs(newy.toLowerCase().compareTo(this.y.toLowerCase()));
            return ((xdistance <= this.moveRangeLR && ydistance <= this.moveRangeUD) && xdistance == ydistance);}
        else
            return false;
        
    }
        
    public void print(){
        if(teamColor.equals("white")){
            System.out.print("  " + "\u2657" + " ");
        }
        else{
            System.out.print("  " + "\u265D" + " ");
        }
    }
    
    //edits Board.boardspaces with new local of the piece
    public void move(int newx, String newy){
        if(validMove(newx, newy)){
            if(Board.boardSpaces[Piece.getInt(newy)][newx] == null)
                Board.boardSpaces[inty][x] = null;
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