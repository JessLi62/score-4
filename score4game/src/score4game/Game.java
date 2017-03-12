package score4game;

public class Game {
    private Board myBoard;
    private Player blackPlayer;
    private Player whitePlayer;
    private boolean isDraw = false;
    private boolean isFinished = false;
    
    private int numberOfMoves;
    
    //keep board size to 4*4
    public Game(){
        numberOfMoves = 0;
        myBoard = new Board (); //create a board
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
        if (myBoard.isWhiteWin()){
            isFinished = true;
            return true;
        }
        return false;
    }
    
    public boolean isBlackWin(){
        if (myBoard.isBlackWin()){
            isFinished = true;
            return true;
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
    
    public void resetGame(){
        myBoard.resetBoard();
    }
    
    //remove when we get GUI working
    public void displayBoard(){
        myBoard.displayBoard();
    }
}
