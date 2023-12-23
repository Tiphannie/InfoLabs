package eightqueens1;

public class EightQueens {
	
		private int[] queens;
		private boolean[] cols;
		private boolean[] hillDiagonals;
		private boolean[] daleDiagonals;
		private int size;


		public EightQueens (int n) {
		this.size = n;
		this.queens = new int[n];
		this.cols = new boolean[n];
		this.hillDiagonals = new boolean[2*n - 1];
		this.daleDiagonals = new boolean[2*n - 1];
		}


		public void placeQueen(int row, int col) {
		this.queens[row] = col;
		this.cols[col] = true;
		this.hillDiagonals[row+col] = true;
		this.daleDiagonals[row-col+this.size-1] = true;
		}


		public void removeQueen(int row, int col) {
		this.queens[row] = 0;
		this.cols[col] = false;
		this.hillDiagonals[row+col] = false;
		this.daleDiagonals[row-col+this.size-1] = false;
		}


		public boolean isSafe(int row, int col) {
		return !(this.cols[col] || this.hillDiagonals[row+col] || this.daleDiagonals[row-col+this.size-1]);
		}


		public void printBoard() {
		for(int i=0; i<this.size; i++) {
		for(int j=0; j<this.size; j++) {
		if(this.queens[i] == j) {
		System.out.print("1 ");
		} else {
		System.out.print("0 ");
		}
		}
		System.out.println();
		}
		System.out.println("\n");
		}


		public void solve(int row) {
		if(row == this.size) {
		// All queens have been placed
		printBoard();
		return;
		}


		for(int col = 0; col < this.size; col++) {
		if(isSafe(row, col)) {
		// Place a queen here
		placeQueen(row, col);


		// Try to place the rest of the queens
		solve(row + 1);


		// After printing a solution, remove this queen and try the next position
		removeQueen(row, col);
		}
		}
		}
		public static void main(String[] args) {


		int N = 8; // Change this to try different board sizes
		EightQueens  board = new EightQueens (N);
		board.solve(0);


		}
		}