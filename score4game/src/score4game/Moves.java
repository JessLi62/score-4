package score4game;

import java.awt.Color;
import java.util.ArrayList;
import static score4game.Colour.BLACK;
import static score4game.Colour.WHITE;

public class Moves {

    private ArrayList<Location> listOfMoves = new ArrayList();

    private int numberOfMoves;//?irrelevant?

    public Moves() {

        char[] rowChar = {'a', 'b', 'c', 'd'};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                listOfMoves.add(new Location(i, j));
            }
        }
    }

    public int getMovesMade() {
        return numberOfMoves;
    }

    public Location getMove(Board gameBoard, Color playerColor) {

        Boolean moveFound = false;
        Location moveToMake;

        while (!moveFound) {

            gameBoard.displayBoard();

            for (int i = 0; i < listOfMoves.size(); i++) {
                moveToMake = listOfMoves.get(i);
                if (!(gameBoard.getPeg(moveToMake).isFull())) {
                    gameBoard.addBead(moveToMake, playerColor);
                } else {
                    continue;
                }

                if (isLineComplete(gameBoard, playerColor)) {
                    return moveToMake;
                }

                gameBoard.removeBead(moveToMake);
            }

            for (int i = 0; i < listOfMoves.size(); i++) {
                moveToMake = listOfMoves.get(i);

                if (!(gameBoard.getPeg(moveToMake).isFull())) {
                    gameBoard.addBead(moveToMake, playerColor.getOppositeColor());
                } else {
                    continue;
                }

                if (isLineComplete(gameBoard, playerColor.getOppositeColor())) {
                    gameBoard.removeBead(moveToMake);
                    gameBoard.addBead(moveToMake, playerColor);
                    return moveToMake;
                }

                gameBoard.removeBead(moveToMake);
            }

            for (int i = 0; i < listOfMoves.size(); i++) {
                if ((gameBoard.getPeg(listOfMoves.get(i))).isFull() == false) {
                    gameBoard.addBead(listOfMoves.get(i), playerColor);
                    return listOfMoves.get(i);
                }
            }

        }
        //Possibly throw exception
        return listOfMoves.get(0);
    }

    private boolean isLineComplete(Board gameBoard, Color color) {
        switch (color) {
            case BLACK:
                return gameBoard.isBlackWin();
            case WHITE:
                return gameBoard.isWhiteWin();
        }
        return false; // throw exception?
    }
}
