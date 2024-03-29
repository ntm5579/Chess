public class Pawn extends Piece{

    public Pawn(String teamName, int x, int y, int moveRangeLR, int moveRangeUD) {
        super(teamName, x, y, moveRangeLR, moveRangeUD, "Pawn");
    }
    
    
    public boolean validMove(int newx, String newy){
        if((Board.boardSpaces[Piece.getInt(y)][x] != null) && pieceInSpace(x,Piece.getInt(y)).getTeamColor() == App.currPlayer.getTeamColor()){    
            int xdistance = Math.abs(newx - this.x);
            int ydistance = Math.abs(Piece.getInt(newy.toLowerCase()) - (Piece.getInt(this.y.toLowerCase())));
            if(ydistance == 2 && xdistance == 0 && (this.inty == 6 || this.inty == 1))
                return true;
            else if((xdistance == 1 && ydistance == 1) && (Board.boardSpaces[inty + 1][x - 1] != null && Board.boardSpaces[inty + 1][x + 1] != null))
                return true;
            else if((xdistance == 0 && ydistance == 1) && Board.boardSpaces[inty + 1][x] == null)
                return true;
            else
                return false;}
        else
            return false;
    }
    
        
    public void print(){
        if(teamColor.equals("white")){
            System.out.print("  " + "\u2659" + " ");
        }
        else{
            System.out.print("  " + "\u265F" + " ");
        }
    }

    public void addToJLabel(){
        if(teamColor.equals("white")){
            Board.fullBoard += "\u2659";
        }
        else{
            Board.fullBoard += "\u265F";
        }
    }

    @Override
    public String toString(){
        if(teamColor.equals("white"))
            return "\u2659";
        
        else
            return "\u265F";
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
