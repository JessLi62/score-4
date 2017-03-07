package score4game;

public class Peg {
    
    private  final char [] peg;
    private Location myLocation;
    
    public Peg(int rows){
        peg = new char[rows];
        for (int i = 0; i < peg.length; i++)
            peg[i] = 'n';
    }
    
    public void addBead(Colour color){
        //should make so player can't click on a full peg and
        //AI can't add or even generate a full peg number
//        if(isFull())
//            throw exception
//        ;
        
        for (int i = 0; i < peg.length; i++)
            //change this when actionlistener in place
            if (peg[i]== 'n'){ //n represents a blank in the peg
                peg[i]= color.getColorChar();
                return;
            }
    }
    
    public void addLocation(int row, int column){
        myLocation = new Location (row,column);
    }
    
    //change to Colours instead of chars?
    public char getBeadColorLetter(int i){
        return (peg[i]);
    }
    
    public Location getLocation(){
        return myLocation; 
    }
    
    public String toString(){
        String beads ="";
        for (int i = 0; i < peg.length; i++){
            beads =  peg[i] + beads;
        }
        return beads;
    }
    
    public void clearPeg(){
        for (int i = 0; i < peg.length; i++)
            peg[i] = 'n';
    }
    
    private boolean isFull(){
        return peg.length != 'n';
    }
}
