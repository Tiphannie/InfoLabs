package eightqueens2;

public class Eight {

    private int size;             // Size of the chessboard
    private int[][] board;        // 2D array for the chessboard

   //n is the size of the chessboard 
    public Eight(int n) {
        this.size = n;
        this.board = new int[n][n];
    }


    private boolean safeSpace(int row, int col) {
        // checks, if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // if there is a queen in the upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // if there is a queen in the upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Solves the Eight Queens puzzle using backtracking
     */
    public void solvePuzzle(int row) {
        if (row == size) {
            // all eight queens have been placed
            printChessboard();
            return;
        }
 
        for (int col = 0; col < size; col++) {
            if (safeSpace(row, col)) {
                // places a queen at the current position
                board[row][col] = 1;

                // tries to place the rest of the queens in the next row
                solvePuzzle(row + 1);

                // removes the queen from the current position
                board[row][col] = 0;
            }
        }
    }

    /**
     * prints the states of the chessboard when a queen is placed 
     */
    private void printChessboard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

   
}