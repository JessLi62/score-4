package score4game;
//tested
public class VerticalLines extends Lines {

    //change so then it examines colours instead of chars
    @Override
    public boolean isWhiteLine(Board board){
        String line = "";
        int boardSize = board.getMyLength();
        for (int i=0; i< boardSize; i++)
            for(int j= 0; j<boardSize; j++){
                for(int k= 0 ; k< boardSize; k++){
                    line += board.getPeg(i, j).getBeadColorLetter(k);
                }
                if (line.equals("WWWW"))
                    return true; 
                
                if (isDeadLine(line))
                    addDeadLines();
                line = "";
                } 
        return false;
    }
    
    @Override
    public boolean isBlackLine(Board board){
        String line = "";
        int boardSize = board.getMyLength();
        for (int i=0; i< boardSize; i++)
            for(int j= 0; j<boardSize; j++){
                for(int k= 0 ; k< boardSize; k++){
                    line += board.getPeg(i, j).getBeadColorLetter(k);
                }
                if (line.equals("BBBB"))
                    return true; 
                
                if (isDeadLine(line))
                    addDeadLines();
                
                line = "";
                } 
        return false;
    }
}
