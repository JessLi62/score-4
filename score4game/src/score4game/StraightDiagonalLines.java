
package score4game;

//tested
public class StraightDiagonalLines extends Lines {
    //change so then it examines colours instead of chars?
    @Override
    public boolean isWhiteLine(Board board) {
         String line ="",
                 line2 = "";
         int boardSize = board.getMyLength();
         
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                 line += board.getPeg(j, 3-j).getBeadColorLetter(i);
                 line2 += board.getPeg(j,j).getBeadColorLetter(i);
            }
            areDeadLines(line, line2);
            if (line.equals("WWWW") || line2.equals("WWWW"))
                return true; 
            line = line2 = "";
        }
        return false;
    }
    
    
    @Override
    public boolean isBlackLine(Board board) {
         String line = "",
                 line2 = "";
         int boardSize = board.getMyLength();
         
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                 line += board.getPeg(j, 3-j).getBeadColorLetter(i);
                 line2 += board.getPeg(j,j).getBeadColorLetter(i);
            }
            areDeadLines(line, line2);
            if (line.equals("BBBB") || line2.equals("BBBB"))
                return true; 
            line = line2 = "";
        }
        return false;
    }
    
    public void areDeadLines(String line1, String line2){
        String [] lines = {line1, line2};
        for (String test : lines)
            if (isDeadLine(test))
                addDeadLines();
    }
}
