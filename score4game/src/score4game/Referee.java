//needs a lot of work
package score4game;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Referee {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Referee window = new Referee();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Referee() {
        initialize();
    }

    public static void setup() {
        char humanColor;
        char aiColor;
        String currentMove;
        Player currentPlayer;
        PrintWriter consoleWriter;
        PrintWriter consoleWriter2;
        PrintWriter aiWriter;
        System.out.print("enter color: ");
        //JavaPipe myAiPlayer = new JavaPipe ("Game Responder");

        Scanner keyboardInput = new Scanner(System.in);

        //try{
        //myAiPlayer.start();
        humanColor = keyboardInput.next().charAt(0);
        consoleWriter = new PrintWriter(System.out);
        Scanner consoleReader = new Scanner(System.in);
        Player player1 = new Player(humanColor, consoleReader, consoleWriter);

        System.out.println("enter color");
        humanColor = keyboardInput.next().charAt(0);
        consoleWriter2 = new PrintWriter(System.out);

        Player player2 = new Player(humanColor, consoleReader, consoleWriter);

//            aiWriter = myAiPlayer.getOutputWriter();
//            Scanner aiReader = new Scanner(myAiPlayer.getInputReader());
//            aiColor = player1.getOppositePlayerColor().getColorChar();
//            Player player2 = new Player (aiColor, aiReader, aiWriter);
        Game myGame = new Game(); //initialize the game

        consoleWriter2.flush();
        if (player1.getColor() == Colour.WHITE) {
            currentPlayer = player1;
            myGame.addPlayers(player1, player2);
        } else {
            currentPlayer = player2;
            myGame.addPlayers(player2, player1);
        }

        while (!myGame.isFinished()) {//|| !myGame.isDraw()){
            currentPlayer.getWriter().println("move;");
            currentPlayer.getWriter().flush();
            currentMove = currentPlayer.getReader().next();
            myGame.makeMove(currentMove, currentPlayer);
            currentPlayer = myGame.getOppositePlayer(currentPlayer);
        }

        // }catch (IOException e){
        myGame.displayBoard();
        System.out.print("Winner:");
        System.out.println((myGame.getOppositePlayer(currentPlayer)).getColor());
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewGame = new JButton("New Game");

        btnNewGame.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent arg0) {
                // Colour frame at

                ColourChooser colour1 = new ColourChooser();
                colour1.setVisible(true);

            }
        });
        btnNewGame.setBounds(0, 0, 136, 36);
        frame.getContentPane().add(btnNewGame);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(165, 0, 125, 36);
        frame.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(311, 0, 123, 36);
        frame.getContentPane().add(btnExit);
    }
}
