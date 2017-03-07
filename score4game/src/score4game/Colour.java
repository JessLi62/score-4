package score4game;

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
