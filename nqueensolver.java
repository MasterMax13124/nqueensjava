import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class nqueensolver {
    public static void main(String[] args) {
        System.out.println("Please input the chessboard size limit: ");
        int inputvalue = Integer.parseInt( System.console().readLine() );
        for(int i = 4; i <= inputvalue; i++) {
            chessboard board = new chessboard(i);
            board = putQueen(board);
        }
    }

    public static chessboard putQueen(chessboard inputBoard) {
        putQueen(inputBoard, 0);

        return inputBoard;
    }

    public static boolean putQueen(chessboard inputBoard, int columnIndex) {
        chessboard board = new chessboard(inputBoard.getBoard(), inputBoard.getSize());

        if (columnIndex >= board.getSize()) { //Stop the recursion when the last column is reached
            String result = board.getBoardText();
            System.out.println(result);
            System.out.println("Final amount of queens: " + (result.length() - result.replace("Q", "").length()));
            System.out.println("Chessboard size: " + board.getSize() + " * " + board.getSize() + "\n\n");
            return true;
        }

        String[] column = board.getColumn(columnIndex);
        if (Arrays.toString(column).replace("X", "").length() == 0) {
            return false;
        }

        int i = -1;
        Random r = new Random();

        do {
            List<Integer> checklist = new ArrayList<Integer>();
            do {
                i = r.nextInt(board.getSize());
                if(!checklist.contains(i)){
                    checklist.add(i);
                }
                else{
                    return false;
                }
            }while (column[i].equals("X"));

            board.setQueen(columnIndex, i);
            board.checkQueens();

            // System.out.println(board.getBoardText());

            if(putQueen(board, columnIndex +1)){
                break;
            }
            board = new chessboard(inputBoard.getBoard(), inputBoard.getSize());
        } while (true);

        // inputBoard = board;

        return true;
    }
}
