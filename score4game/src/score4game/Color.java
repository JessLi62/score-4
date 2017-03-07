package score4game;

enum Color {
    BLACK ('B'),
    WHITE ('W');

    private char colorChar;

    Color (char color){
        this.colorChar = color;
    }

    public char getColorChar(){
        return colorChar;
    }

    public Color getOppositeColor(){
        if (this == Color.BLACK)
            return Color.WHITE;
        else
            return Color.BLACK;

    }
}
