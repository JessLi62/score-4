/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score4game;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Shahana Alam
 */
public class ComputerOpponent {
     public static void main(String[] args){
        
        String command; 
        Board myBoard = new Board();
        Colour myColor = Colour.BLACK;// default color
        PrintWriter responseWriter = new PrintWriter (System.out);
        Scanner commandReader = new Scanner (System.in);
        String [] opponentMove;
        Moves myMoves = new Moves();
        
        
        
        
        while(commandReader.hasNext()){
            command = commandReader.next();
            
            //Command to end program
            if (command.equals("quit;"))
                break;
            
            switch (command){
                case "restart;": myBoard.resetBoard();
                                 break;
                case "play":   if( commandReader.nextLine().equalsIgnoreCase(" black;"))
                                    myColor = Colour.BLACK;
                                else
                                    myColor = Colour.WHITE;
                responseWriter.println("ok;");
                responseWriter.flush();
                                break;
                
                case "move;":  responseWriter.println(myMoves.getMove(myBoard, myColor));
                               break; 
                case "note:" : opponentMove = (commandReader.nextLine()).split(" ");
                               myBoard.addBead(new Location(opponentMove[3].substring(0, 2)),myColor.getOppositeColor());
                               responseWriter.println("ok.");
                               break;
                default: responseWriter.println("Bad command.");
            }
            //commandReader.nextLine();// Moves to next line if more words such as Note: 'color' plays 'location'
            responseWriter.flush();
        }
    }
}
