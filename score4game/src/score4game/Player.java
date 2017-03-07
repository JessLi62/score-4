package score4game;

import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
    
    private Colour myColor;
    private PrintWriter myWriter;
    private Scanner myReader;
    
    public Player (char color, Scanner scanner, PrintWriter printWriter){
        if (color == 'b')
            myColor = Colour.BLACK;
        else
            myColor = Colour.WHITE;
        
        myWriter = printWriter;
        myReader = scanner;
    }
    
    public Colour getColor(){
        return myColor;
    }
    
    public Colour getOppositePlayerColor(){
        return myColor.getOppositeColor();
    }
    
    public PrintWriter getWriter(){
        return myWriter;
    }
    
    public Scanner getReader(){
        return myReader;
    }
           
 }

