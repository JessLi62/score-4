//can be removed?
package score4game;

public class TestGame {
    
    public static void main(String [] args){
        Colour color1 = Colour.BLACK;
        Colour color2 = Colour.WHITE;
        Location myLocation = new Location("a3");
        System.out.println(myLocation);


        Board myBoard = new Board();
        myBoard.addBead(myLocation, color2);
        myBoard.addBead(myLocation, color1);
        myBoard.displayBoard();
    }
    
}
