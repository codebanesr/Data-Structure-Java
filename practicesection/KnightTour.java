import java.util.Arrays;

public class KnightTour {
    public static void main(String[] args) {
        int board[][] = new int[8][8];
        boolean visited[][] = new boolean[3][3];
        visited[0][0] = true;
        board[0][0] = 1;
        for (int i = 0; i < board.length;i++)
            Arrays.fill(board[i], -1);
        tour(board, 1, 0, 0);

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    static boolean isMoveValid(int board[][], int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == -1) {
            return true;    
        }

        return false;
    }

    static int x[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    // board is the final result that contains one number on each entry denoting when in the
    // path was that box covered. We only cover each box once and never again
    // row and col tells us which cell we are currently exploring as part of the final solution
    // counter tells how many cells we have covered so far in the path
    static boolean tour(int board[][], int counter, int row, int col) {
        if (counter >= Math.pow(board.length, 2)) {
            return true;
        }

        for (int i = 0; i < x.length; i++) {
            if (isMoveValid(board, row + x[i], col + y[i])) {
                board[row + x[i]][col + y[i]] = counter;
                // check if making this move helps knight cover all square boxes
                if (tour(board, counter+1, row + x[i], col + y[i])) {
                    return true;
                }

                board[row + x[i]][col + y[i]] = -1;
            }
        }

        return false;
    }

}
