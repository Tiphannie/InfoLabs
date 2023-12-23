package eightqueens;

public class Chessboard {
    private int[][] board;
    private static final int EMPTY = 0;
    private static final int QUEEN = 1;

    public Chessboard() {
        board = new int[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public boolean placeQueens() {
        return placeQueensHelper(0);
    }

    private boolean placeQueensHelper(int col) {
        if (col >= 8) {
            return true; // All queens have been successfully placed
        }

        for (int row = 0; row < 8; row++) {
            if (isSafe(row, col)) {
                board[row][col] = QUEEN; // Place a queen in the current cell

                if (placeQueensHelper(col + 1)) {
                    return true;
                }

                board[row][col] = EMPTY; // Backtrack and remove the queen
            }
        }

        return false; // Unable to place a queen in the current column
    }

    private boolean isSafe(int row, int col) {
        // Check if no queen is present in the same row
        for (int c = 0; c < col; c++) {
            if (board[row][c] == QUEEN) {
                return false;
            }
        }

        // Check if no queen is present in the upper diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == QUEEN) {
                return false;
            }
        }

        // Check if no queen is present in the lower diagonal
        for (int r = row, c = col; r < 8 && c >= 0; r++, c--) {
            if (board[r][c] == QUEEN) {
                return false;
            }
        }

        return true; // It is safe to place a queen in the current cell
    }
    

    public boolean isThreateningQueens() {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (board[row][col] == QUEEN) {
                    if (isQueenThreatened(row, col)) {
                        return true; // Found a threatening queen
                    }
                }
            }
        }
        return false; // No threatening queens found
    }

    private boolean isQueenThreatened(int row, int col) {
        // Check if any other queen in the same row
        for (int c = 0; c < 8; c++) {
            if (c != col && board[row][c] == QUEEN) {
                return true;
            }
        }

        // Check if any other queen in the same column
        for (int r = 0; r < 8; r++) {
            if (r != row && board[r][col] == QUEEN) {
                return true;
            }
        }

        // Check if any other queen in the upper-left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == QUEEN) {
                return true;
            }
        }

        // Check if any other queen in the lower-left diagonal
        for (int r = row + 1, c = col - 1; r < 8 && c >= 0; r++, c--) {
            if (board[r][c] == QUEEN) {
                return true;
            }
        }

        return false; // No threatening queens found
    }
    

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == QUEEN) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}