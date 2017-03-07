package score4game;

public class Game {
    private Board myBoard;
    private Player blackPlayer;
    private Player whitePlayer;
    private boolean isDraw = false;
    private boolean isFinished = false;
    private Lines[] myLines;
    private int numberOfMoves;
    
    //keep board size to 4*4
    public Game(){
        numberOfMoves = 0;
        myBoard = new Board (); //create a board
        myLines = new Lines[]{new HorizontalLines(), new VerticalLines(), new StraightDiagonalLines(),
                    new DiagonalSingleSkew(), new DiagonalDoubleSkew()};
    }
    
    public void makeMove(String location, Player current){
        myBoard.addBead(new Location (location), current.getColor()); //Board class, add bead method
        numberOfMoves++;
        if (numberOfMoves % 2 == 0)
            isBlackWin();
        else
            isWhiteWin();
    }
    
    public void addPlayers(Player white, Player black){
        whitePlayer = white;
        blackPlayer = black;
    }
    
    public boolean isWhiteWin(){
        for (Lines thisLine:myLines){
            if (thisLine.isWhiteLine(myBoard)){
                isFinished = true;
                return true;
            }
        }
        return false;
    }
    
    public boolean isBlackWin(){
        for (Lines thisLine:myLines){
            if (thisLine.isBlackLine(myBoard)){
                isFinished = true;
                return true;
            }
        }
        return false;
    }
    
    public boolean isFinished(){
        return isFinished;
    }
    
    public boolean isDraw(){
        if (Lines.getDeadLines() == 76 || numberOfMoves == 64)
            isDraw = true;
        return isDraw;
    }
    
    public Player getOppositePlayer(Player current){
        if (current.equals(blackPlayer))
                return whitePlayer;
        return blackPlayer;
    }
    
    //remove when we get GUI working
    public void displayBoard(){
        myBoard.displayBoard();
    }
}
