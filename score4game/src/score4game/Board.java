package score4game;

public class Board {
    private final int myLength = 4;
    private final Peg [][] myGrid;
    private Lines[] myLines;
    
    public Board (){
        myGrid = new Peg [myLength][myLength]; //create a 4*4 board grid

        for (int i = 0; i < myLength; i++){
           for (int j = 0; j < myLength; j++)
               myGrid[i][j] = new Peg(myLength);
        }

        for (int i = 0; i < myLength; i++)
            for (int j = 0; j < myLength; j++)
               myGrid[i][j].addLocation(i, j);
        
        myLines = new Lines[]{new HorizontalLines(), new VerticalLines(), new StraightDiagonalLines(),
                    new DiagonalSingleSkew(), new DiagonalDoubleSkew()};
    }

    //action listeners for player adding bead with click?
    public void addBead (Location location, Colour color){
        for (int i = 0; i < myLength; i++)
            for (int j = 0; j < myLength; j++)
                if (myGrid[i][j].getLocation().equals(location)){
                    myGrid[i][j].addBead(color);
                    return;
                }
    }
    
    public boolean isWhiteWin(){
        for (Lines thisLine:myLines){
            if (thisLine.isWhiteLine(this))
                return true;
        }
        return false;
    }
    
    public boolean isBlackWin(){
        for (Lines thisLine:myLines){
            if (thisLine.isBlackLine(this))
                return true;
        }
        return false;
    }

    public int getMyLength(){
        return myLength;
    }

    public Peg getPeg(Location location){
        return myGrid[location.getRowNumber()][location.getColumn()];
    }

    public Peg getPeg(int row, int column){
       return myGrid[row][column];
    }
    
    public void resetBoard(){
        for (int i = 0; i < myLength; i++){
           for (int j = 0; j < myLength; j++)
               myGrid[i][j].resetPeg();
        }
    }
    
    public void removeBead(Location location){
        for (int i = 0; i < myLength; i++)
            for (int j = 0; j < myLength; j++)
                if (myGrid[i][j].getLocation().equals(location)){
                    myGrid[i][j].removeBead();
                    return;
                } 
    }

    //temporary don't need when GUI is working
    public void displayBoard(){
        for (int i = 0; i < myLength; i++){
            for (int j = 0; j < myLength; j++){
                System.out.print(myGrid[i][j].toString());
                System.out.print("  ");
            }
            System.out.printf("%n%n");
        }
    }
}
