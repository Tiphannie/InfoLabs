package eightqueens2;

public class MainEight {

	//creating the eight queen chessboard and solving the puzzle 
    public static void main(String[] args) {
        int N = 8; // Change this to try different board sizes
        Eight board = new Eight(N);
        board.solvePuzzle(0);
    }

}
