package kudosu;

public class KuDoSu {

	private static long deapth=0;
	
	public static void main(String[] args) {
		System.out.println("Start");
		
//		int[][] board= {
//				{8,0,0,0,0,0,0,0,0},
//				{0,0,3,6,0,0,0,0,0},
//				{0,7,0,0,9,0,2,0,0},
//				{0,5,0,0,0,7,0,0,0},
//				{0,0,0,0,4,5,7,0,0},
//				{0,0,0,1,0,0,0,3,0},
//				{0,0,1,0,0,0,0,6,8},
//				{0,0,8,5,0,0,0,1,0},
//				{0,9,0,0,0,0,4,0,0}};
//		
		int[][] board={{3,0,0,9,6,7,0,0,1},
		{0,4,0,3,0,2,0,8,0},
		{0,2,0,0,0,0,0,7,0},
		{0,7,0,0,0,0,0,9,0},
		{0,0,0,8,7,3,0,0,0},
		{5,0,0,0,1,0,0,0,3},
		{0,0,4,7,0,5,1,0,0},
		{9,0,5,0,0,0,2,0,7},
		{8,0,0,6,2,1,0,0,4}};
		
		
		GUI.showInitial(board);
		GUI.showNumberBoard(board);
		long s = System.nanoTime();
		solveSudoku(board);
		System.out.println("time taken (ms) "+(System.nanoTime()-s)/1000000);
		Util.printBoard(board);
		
		//System.out.println("chk sol: "+isValid(board,8,7,8)); //false 
		System.out.println("deapth "+deapth);
		
		System.out.println("End");
	}
	
	private static boolean solveSudoku(int[][] board) {
		deapth++;
		//System.out.println("deapth " + deapth);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						board[i][j] = k;
						 GUI.updateNumber(i, j, k);
						//GUI.showNumberBoard(board);
						if (isValid(board, i, j, k) && solveSudoku(board)) {
							return true;
						}
						board[i][j] = 0;
						GUI.updateNumber(i, j, 0);
						//GUI.showNumberBoard(board);
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isValid(int[][] board, int row, int col, int num) {
		// check the row
		for (int colIter = 0; colIter < 9; colIter++) {
			if (colIter != col && board[row][colIter] == num) {
				return false;
			}
		}

		// check the column
		for (int rowIter = 0; rowIter < 9; rowIter++) {
			if (rowIter != row && board[rowIter][col] == num) {
				return false;
			}
		}

		// check the 3x3 box
		int boxStartRow = (row / 3) * 3;
		int boxStartCol = (col / 3) * 3;

		for (int rowIter = boxStartRow; rowIter < boxStartRow + 3; rowIter++) {
			for (int colIter = boxStartCol; colIter < boxStartCol + 3; colIter++) {
				if (rowIter != row && colIter != col && board[rowIter][colIter] == num) {
					return false;
				}
			}
		}
		return true;
	}

}
