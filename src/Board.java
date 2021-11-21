public class Board {
    public static Piece[][] boardSpaces = new Piece[8][8];
    public static String fullBoard;
    
    //puts all of the pieces in their starting places
    public static void initBoard(){
        //black pieces
        Piece [] blackPieceRow = new Piece[8];
        blackPieceRow[0] = new Rook("black", 0, 7, 8, 8);
        blackPieceRow[1] = new Knight("black", 1, 7, 3, 3);
        blackPieceRow[2] = new Bishop("black", 2, 7, 8, 8);
        blackPieceRow[3] = new Queen("black", 3, 7, 8, 8);
        blackPieceRow[4] = new King("black", 4, 7, 1, 1);
        King.kingcoords[0] = 4;
        King.kingcoords[1] = 7;
        blackPieceRow[5] = new Bishop("black", 5, 7, 8, 8);
        blackPieceRow[6] = new Knight("black", 6, 7, 3, 3);
        blackPieceRow[7] = new Rook("black", 7, 7, 8, 8);
        boardSpaces[0] = blackPieceRow;

        Piece [] blackPawnRow = new Piece[8];
        for(int r = 0; r < 8; r++){
            blackPawnRow[r] = new Pawn("black", 2, r, 1, 2);
        }
        boardSpaces[1] = blackPawnRow;
        
        //middle spaces 
        Piece [] middleRows = new Piece[8];
        for(int i = 2; i < 6 ; i++){
            boardSpaces[i] = middleRows;
        }

        //white pieces
        Piece [] whitePawnRow = new Piece[8];
        for(int r = 0; r < 8; r++){
            whitePawnRow[r] = new Pawn("white", 6, r, 1, 2);
        }
        boardSpaces[6] = whitePawnRow;

        Piece [] whitePieceRow = new Piece[8];
        whitePieceRow[0] = new Rook("white", 0, 0, 8, 8);
        whitePieceRow[1] = new Knight("white", 1, 0, 3, 3);
        whitePieceRow[2] = new Bishop("white", 2, 0, 8, 8);
        whitePieceRow[3] = new Queen("white", 3, 0, 8, 8);
        whitePieceRow[4] = new King("white", 4, 0, 1, 1);
        King.kingcoords[2] = 4;
        King.kingcoords[3] = 0;
        whitePieceRow[5] = new Bishop("white", 5, 0, 8, 8);
        whitePieceRow[6] = new Knight("white", 6, 0, 3, 3);
        whitePieceRow[7] = new Rook("white", 7, 0, 8, 8);
        boardSpaces[7] = whitePieceRow;
    }

    //will display the board in the console
    public static void print(){
        System.out.print("      (0) (1) (2) (3) (4) (5) (6) (7)");
        for(int r = 0; r < Board.boardSpaces.length; r++){
            System.out.println();
            System.out.print(" (" + Piece.spaceNames[r] + ") ");
            for(int c = 0; c < Board.boardSpaces[0].length; c++){
                if(Board.boardSpaces[r][c] !=  null)
                    Board.boardSpaces[r][c].print();
                else
                    System.out.print("  ");
            }
        }
    }
    
    //used to see if a king is in check, if it is that will alter the turn loop so that the player has to move out of check
    public static boolean checkCheck(){
        return ((King) Board.boardSpaces[King.kingcoords[1]][King.kingcoords[0]]).checkCheck(King.kingcoords[0],King.kingcoords[1]);
    }

    //takes the elements and formats them as a string for the jlabel for display in the jframe
    public static String boardToJLabel(){
        fullBoard = "      (0)-(1)-(2)-(3)-(4)-(5)-(6)-(7)";
        for(int r = 0; r < Board.boardSpaces.length; r++){
            fullBoard += "\n (" + Piece.spaceNames[r] + ") ";
            for(int c = 0; c < Board.boardSpaces[0].length; c++){
                if(Board.boardSpaces[r][c] !=  null){
                    Board.boardSpaces[r][c].addToJLabel();
                    fullBoard += "  ";}
                else{
                    //change
                    fullBoard += "     ";}
            }
        }

        return fullBoard;
    }
    
}
