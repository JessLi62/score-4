package score4game;

public class Moves {
    private static int numberOfMoves;
    
    public static void addMove(){
        numberOfMoves++;
    }
    
    public static int getMovesMade(){
        return numberOfMoves;
    }
}
