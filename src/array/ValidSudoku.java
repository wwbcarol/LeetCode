package array;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] borad = 
		{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'},
		};
		
		ValidSudoku a = new ValidSudoku();
		
		System.out.println(a.isValidSudoku(borad));
	}
	public boolean isValidSudoku(char[][] board) {
        
		HashSet<Character> map = new HashSet<Character>();
		boolean result;
		// row
		for(int i=0;i<9;i++){
			map.clear();
			for(int j=0;j<9;j++){
				if (board[i][j]!='.') {
					if(map.contains(board[i][j])){
						return false;
					}
					else{
						map.add(board[i][j]);
					}
				}
			}
		}
		// column
		for(int j=0;j<9;j++){
			map.clear();
			for(int i=0;i<9;i++){
				if (board[i][j]!='.') {
					if(map.contains(board[i][j])){
						return false;
					}
					else{
						map.add(board[i][j]);
					}
				}
			}
		}
		
		// 3*3
		
		for(int i=1;i<9;i+=3){
			for(int j=1;j<9;j+=3){
				result = check(board, i, j);
				if(result == false) return false;
			}
		}
		return true;
    }
	private boolean check(char[][] board, int i, int j) {
		
		HashSet<Character> map = new HashSet<Character>();
		
		for(int k = i-1;k<=i+1;k++){
			for(int t = j-1;t<=j+1;t++){
				if (board[k][t]!='.') {
					if(map.contains(board[k][t])){
						return false;
					}
					else{
						map.add(board[k][t]);
					}
				}
			}
		}
		
		return true;
	}
}
