package leetcode;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

    A move is guaranteed to be valid and is placed on an empty block.
    Once a winning condition is reached, no more moves is allowed.
    A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 */
public class TicTacToe {

	private int[][] board;
	private int size;

	public TicTacToe(int board_size) {
		this.size = board_size;
		this.board = new int[board_size][board_size];
	}

	public int move(int row, int col, int player) {
		board[row][col] = player;
		return validateBoard(row, col, player);
	}

	private int validateBoard(int row, int col, int player) {
		if (checkRow(row, player) || checkColumn(col, player) || checkBackwardDiagonal(player)
				|| checkForwardDiagonal(player)) {
			return player;
		}
		return 0;
	}

	private boolean checkRow(int currentRow, int player) {
		for (int column = 0; column < size; column++) {
			if (board[currentRow][column] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean checkColumn(int currentCol, int player) {
		for (int row = 0; row < size; row++) {
			if (board[row][currentCol] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean checkBackwardDiagonal(int player) {
		for (int x = 0; x < size; x++) {
			if (board[x][x] != player) {
				return false;
			}
		}
		return true;
	}

	private boolean checkForwardDiagonal(int player) {
		for (int x = size - 1; x >= 0; x--) {
			if (board[x][size - x - 1] != player) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TicTacToe toe = new TicTacToe(3);
		System.out.println(toe.move(0, 0, 1));
		System.out.println(toe.move(0, 2, 2));
		System.out.println(toe.move(2, 2, 1));
		System.out.println(toe.move(1, 1, 2));
		System.out.println(toe.move(2, 0, 1));
		System.out.println(toe.move(1, 0, 2));
		System.out.println(toe.move(2, 1, 1));
	}
}
