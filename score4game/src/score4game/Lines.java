package score4game;

public  abstract class Lines {
    
    private static int deadLines;
    public abstract boolean isWhiteLine(Board board);
    public abstract boolean isBlackLine(Board board);
    
    public void addDeadLines(){
        deadLines++;
    }
    
    public static int getDeadLines(){
        return deadLines;
    }
    
    //change so then it examines colours instead of chars
    public boolean isDeadLine(String line){
        return (line.contains("B") && (line.contains("W")));
    }
}
