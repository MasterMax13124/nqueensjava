import java.util.Arrays;

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
     * Marks all fields that are checked by a queen with an 'X'.
     */
    public void checkQueens(){
        int[] queenPositions = new int[size];
        Arrays.fill(queenPositions, -1);

        //Mark all columns that contain a queen as checked
        for (int i = 0; i < this.size; i++){
            if(Arrays.toString(board[i]).contains("Q")){
                int queenIndex = Arrays.asList(board[i]).indexOf("Q");

                queenPositions[i] = queenIndex;

                String[] s = new String[size];
                Arrays.fill(s, "X");
                s[queenIndex] = "Q";
                board[i] = s;
            }
        }

        //Mark all rows that contain a queen as checked
        String[] rowarray = this.getBoardText().split("\n");
        for (int i = 0; i < this.size; i++){
            if(!rowarray[i].contains(("Q"))){
                continue;
            }

            int queenIndex = rowarray[i].indexOf("Q") / 2;

            for(int j = 0; j < this.size; j++){
                board[j][i] = "X";
            }
            board[queenIndex][i] = "Q";
        }

        //Mark diagonals that can be checked by the queen 
        for (int i = 0; i < queenPositions.length; i++){
            if(queenPositions[i] == -1) {
                continue;
            }

            int c = i;
            int r = queenPositions[i];

            while(c > 0 && r > 0) {
                c--;
                r--;
                board[c][r] = "X";
            }

            c = i;
            r = queenPositions[i];

            while(c < this.size -1 && r < this.size -1) {
                c++;
                r++;
                board[c][r] = "X";
            }
        }
    }

    /**
     * Sets an arbitrary value for a specified field on the board.
     */
    public void setField(int column, int row, String value){
        this.board[column][row] = value;
    }

    /**
     * Marks the specified field as a queen. Useful specifically for the n queens problem.
     */
    public void setQueen(int column, int row){
        this.board[column][row] = "Q";
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