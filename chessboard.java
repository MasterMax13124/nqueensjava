public class chessboard{
    //The board is represented by a two dimensional String array. The first index specifies the column/file and the second index specifies the row/rank.
    private int size;
    private String[][] board = new String[size][size]; 

    /**
     * If no size value is given, then the board is created with the standard chessboard size (8 by 8).
     */
    public chessboard(){
        this.size = 8;       
        this.board = new String[size][size]; 
    }

    public chessboard(int size) {
       this.size = size;
       this.board = new String[size][size]; 
    }

    /**
     * Fills all spaces on the board with their per column index.
     */
    public void fillBoardDefault() {
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                board[i][j] = "" + j;
            }
        }
    }

    /**
    *Returns just the fields of the board, in the way they are internally stored.
    */
    public String[][] getBoard() {
        return this.board;
    }

    /**
     * Returns the entire board as a formatted string. Useful for displaying to the user.
     */
    public String getBoardText(){
        String b = "";

        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                b += board[j][i] + " ";
            }
            b += "\n";
        }

        return b;
    }

    /**
     * Returns just one column/file of the board.
     */
    public String[] getColumn(int index) {
        return this.board[index];
    }

    /**
    *Returns the size of the board as an integer.
    */
    public int getSize() {
        return this.size;
    }

}