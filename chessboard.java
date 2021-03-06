public class chessboard{
    //board is represented as string array, one string is one vertical column of the board (called rank)
    //therefore the topmost row of the board is made up of the 0th index of each string in the array
    private int size;
    private String[] board = new String[size]; 

    /**
     * If no size value is given, then the board is created with the standard chessboard size (8 by 8).
     */
    public chessboard(){
        this.size = 8;       
    }

    public chessboard(int size) {
       this.size = size;
    }

    /**
    Returns just the fields of the board, in the way they are internally stored.
    */
    public String[] getFields() {
        return this.board;
    }

    /**
    Returns the size of the board as an integer.
    */
    public int getSize() {
        return this.size;
    }

}