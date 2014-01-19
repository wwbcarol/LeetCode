package array;

import java.util.ArrayList;

public class SolveSudoku {
	
	public static void main(String[] args) {
		char[][] board = 
			{
					{'5','1','9','7','4','8','6','3','2'},
					{'7','8','3','6','5','2','4','1','9'},
					{'4','2','6','1','3','9','8','7','5'},
					{'3','5','7','9','8','6','2','4','1'},
					{'2','6','4','3','1','7','5','9','8'},
					{'1','9','8','5','2','4','3','6','7'},
					{'9','7','5','8','6','3','1','2','4'},
					{'8','3','2','4','9','1','7','5','6'},
					{'.','.','.','.','.','.','.','.','.'},
			};
		
		solveSudoku(board);
		for(int i=0;i<9;i++){
			System.out.print(board[8][i]);
		}
		
	}

	public static boolean check(char[][] board, int i, int j) {
		int N = 9;
		for (int t = 0; t < N; t++) {
			if (t != i && board[t][j] != '.' && board[t][j] == board[i][j]) {
				return false;
			}
			if (t != j && board[i][t] != '.' && board[i][t] == board[i][j]) {
				return false;
			}
		}
		int x = 3 * (i / 3) + 1;
		int y = 3 * (j / 3) + 1;
		for (int t = -1; t <= 1; t++) {
			for (int k = -1; k <= 1; k++) {
				if (((x + t != i) && (y + k != j))
						&& board[x + t][y + k] != '.'
						&& board[x + t][y + k] == board[i][j])
					return false;
			}
		}

		return true;
	}

	static ArrayList<Integer> ilist = new ArrayList<Integer>();
	static ArrayList<Integer> jlist = new ArrayList<Integer>();
	static boolean isOver = false;
	public static void solveSudoku(char[][] board) {
		
		ilist.clear();
		jlist.clear();
		int N = 9;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '.') {
					ilist.add(i);
					jlist.add(j);
				}
			}
		}
		
		solveSudoku(board, ilist.size()-1);

	}
	
	public static void solveSudoku(char[][] board, int len){
		if(len<0){
			for(int i=0;i<9;i++){
				System.out.print(board[8][i]);
			}
			System.out.println("");
			isOver = true;
			return;
		}
		
		int i = ilist.get(len);
		int j = jlist.get(len);
		for(int t=1;t<=9;t++){
			board[i][j] = (char)(t+'0');
			if(check(board, i, j)){
				solveSudoku(board, len-1);
				
			}
			if(isOver)break;
			else board[i][j] = '.';
		}
	}
}
