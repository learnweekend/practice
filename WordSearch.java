/**
 * https://leetcode.com/problems/word-search/description/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 * Example:
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] Given word = "ABCCED", return
 * true. Given word = "SEE", return true. Given word = "ABCB", return false.
 */
public class WordSearch {
	/*
	 * Solution : Use DFS,  runtime : O(N ^ 4), Space : O(1)
	 */
	public boolean existV1(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (existsV1(board, 0, i, j, word))
						return true;
				}
			}
		}
		return false;
	}

	private boolean existsV1(char[][] board, int index, int row, int col, String word) {
		if (index == word.length())
			return true;

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}

		board[row][col] ^= 256;  // any number > 256 would work fine

		boolean exists = existsV1(board, index + 1, row + 1, col, word) || 
				existsV1(board, index + 1, row - 1, col, word) || 
				existsV1(board, index + 1, row, col + 1, word) || 
				existsV1(board, index + 1, row, col - 1, word);

		board[row][col] ^= 256;

		return exists;
	}
   
	/*
	 * Solution : Use DFS,  runtime : O(N ^ 4), Space : O(M * N)
	 */
	 public boolean exist(char[][] board, String word) {
       if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
           return false;
       
       boolean[][] visited = new boolean[board.length][board[0].length];
       
       for(int i = 0; i < board.length; i++) {
           for(int j = 0; j < board[0].length; j++) {
               if(board[i][j] == word.charAt(0) && exists(board, 0, i, j, word, visited))
                   return true;
           }
       }
       return false;
   }
   
   private boolean exists(char[][] board, int index, int row, int col, String word, boolean[][] visited){
       if(index == word.length())
           return true;
       
       if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || 
          visited[row][col] || board[row][col] != word.charAt(index)) {
           return false;
       }
       
       visited[row][col] = true;
       
       boolean exists = exists(board, index + 1, row + 1, col, word, visited) ||   // from left-to-right
                        exists(board, index + 1, row, col + 1, word, visited) ||     // from up-to-down
       					        exists(board, index + 1, row - 1, col, word, visited) ||  // go up
                        exists(board, index + 1, row, col - 1, word, visited);     // go left
       
       visited[row][col] = false;
       
       return exists;
   }

	public static void main(String[] args) {
		char[][] board = { 
				{'F', 'A', 'C', 'I'}, 
				{'O', 'B', 'Q', 'P'}, 
				{'A', 'N', 'O', 'B'}, 
				{'M', 'A', 'S', 'S'}
			};
		
		WordSearch obj = new WordSearch();
		System.out.println(obj.exist(board, "FOAM"));
		System.out.println(obj.exist(board, "MASS"));
	}
}
