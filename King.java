package app;

public class King extends Piece{

    public static int [] kingcoords = new int[4];

    public King(final String teamName, final int x, final int y, final int moveRangeLR, final int moveRangeUD) {
        super(teamName, x, y, moveRangeLR, moveRangeUD, "King");
    }

    public boolean checkCheck(int x, int y){
        for(int r = 0; r < Board.boardSpaces.length; r++){
            for(int c = 0; c < Board.boardSpaces[r].length; c++){
                if(Board.boardSpaces[r][c] != null && !Board.boardSpaces[r][c].teamColor.equals(App.currPlayer.teamColor) && Board.boardSpaces[r][c].validMove(x, Piece.spaceNames[y]))
                    return false;
            }
        }
        return true;
    }
    
    public boolean validMove(int newx, String newy){
        if((Board.boardSpaces[Piece.getInt(y)][x] != null) && pieceInSpace(x,Piece.getInt(y)).getTeamColor() == App.currPlayer.getTeamColor() && checkCheck(newx, Piece.getInt(newy))){ 
            int xdistance = Math.abs(newx - this.x);
            int ydistance = Math.abs(newy.toLowerCase().compareTo(this.y.toLowerCase()));
            return ((xdistance <= this.moveRangeLR && ydistance <= this.moveRangeUD));}
        else
            return false;
    }
    
    public void print(){
        if(teamColor.equals("white")){
            System.out.print("  " + "\u2654" + " ");
        }
        else{
            System.out.print("  " + "\u265A" + " ");
        }
    }

    //edits Board.boardspaces with new local of the piece
    public void move(int newx, String newy){
        if(validMove(newx, newy)){
            if(Board.boardSpaces[Piece.getInt(newy)][x] == null)
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