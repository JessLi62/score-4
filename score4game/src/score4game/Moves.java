package score4game;

import java.util.ArrayList;

public class Moves {
    Board movesBoard = new Board();
    private ArrayList<Location> listOfMoves = new ArrayList();
    private ArrayList <Location> movesMade = new ArrayList();// necessary?
    private Colour myColor;
    private int numberOfMoves;
    
    public Moves(){
        
        char [] rowChar = {'a','b','c','d'};
        for (int i=0; i < 4; i++)
            for (int j = 0; j< 4; j++){
            listOfMoves.add(new Location(i,j));
        }
    }
    
    public void setMyColor(Colour color){
        myColor = color;
    }
    
    public Colour getMyColor(){
        return myColor;
    }
    
    public void addMove(Location location, Colour color){
        movesBoard.addBead(location, color);
        movesMade.add(location);
        numberOfMoves++;
    }
    
    public int getMovesMade(){
        return numberOfMoves;
    }
    
    public Location getMove(){
        
        Boolean moveFound = false;
        Location moveToMake;
        
        while (!moveFound){
           
            movesBoard.displayBoard();
            
            for (int i = 0; i< listOfMoves.size(); i++){
                moveToMake = listOfMoves.get(i);
                if (!(movesBoard.getPeg(moveToMake).isFull()))
                    movesBoard.addBead(moveToMake, myColor);
                else
                    continue;
                
                if (isLineComplete(myColor))
                    return moveToMake;
                
                movesBoard.removeBead(moveToMake);
            }
            
            for (int i = 0; i< listOfMoves.size(); i++){   
                moveToMake = listOfMoves.get(i);
                
                if (!(movesBoard.getPeg(moveToMake).isFull()))
                    movesBoard.addBead(moveToMake, myColor.getOppositeColor());
                else
                    continue;
                
                if (isLineComplete(myColor.getOppositeColor())){
                    movesBoard.removeBead(moveToMake);
                    movesBoard.addBead(moveToMake, myColor);
                    return moveToMake;}
                
                movesBoard.removeBead(moveToMake);
            }
            
            for (int i=0; i < listOfMoves.size(); i++){
                if ((movesBoard.getPeg(listOfMoves.get(i))).isFull()== false){
                    movesBoard.addBead(listOfMoves.get(i), myColor);
                    return listOfMoves.get(i);
                }}
            
        }
        //Possibly throw exception
        return listOfMoves.get(0);
    }
    
    
    private boolean isLineComplete(Colour color){
        switch (color){
            case BLACK: return movesBoard.isBlackWin();
            case WHITE: return movesBoard.isWhiteWin();
        }
        return false; // throw exception?
    }
}
