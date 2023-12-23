package eightqueens;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        boolean solutionExists = chessboard.placeQueens();

        if (solutionExists) {
            System.out.println("Solution found:");
            chessboard.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}