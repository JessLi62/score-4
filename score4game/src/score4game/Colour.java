package score4game;

//Colour should be set up so then we represents an actual colour that will be for the bead
enum Colour {
    BLACK ('B'),
    WHITE ('W');

    private char colorChar;

    Colour (char color){
        this.colorChar = color;
    }

    public char getColorChar(){
        return colorChar;
    }

    public Colour getOppositeColor(){
        if (this == Colour.BLACK)
            return Colour.WHITE;
        else
            return Colour.BLACK;

    }
}
