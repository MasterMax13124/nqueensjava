import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class nqueensolver {
    public static void main(String[] args) {
        final chessboard board = new chessboard(8);
        // board.fillBoardDefault();
        putQueen(board, 0);

        // board.setQueen(0, 0);
        // board.checkQueens();
        // modifyBoard(board);
        //System.out.println("Final board:\n" + board.getBoardText());

        // int x = 0;
        // System.out.println(x);

    }

    public static void modifyBoard(final chessboard inpb) {
        chessboard xyz = new chessboard(inpb.getBoard(), 4);
        // chessboard bbb = new chessboard(inpb);

        xyz.setQueen(2, 2);
        // xyz.setQueen(2, 2);
    }

    public static boolean putQueen(chessboard inputBoard, int columnIndex) { //c specifies the target column for the queen
        chessboard board = new chessboard(inputBoard.getBoard(), inputBoard.getSize());

        if (columnIndex >= board.getSize()) { //Stop the recursion when the last column is reached
            // inputBoard = board;
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
            System.out.println(board.getBoardText());
            //System.out.println(board.getSize());
            if(putQueen(board, columnIndex +1)){
                break;
            }

            board = new chessboard(inputBoard.getBoard(), inputBoard.getSize());
        } while (true);

        // System.out.println(board.getBoardText());

        // putQueen(board, columnIndex + 1);
        inputBoard = board;

        return true;
    }
}