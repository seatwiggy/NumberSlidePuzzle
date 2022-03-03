package edu.neumont.csc150.models;

import java.util.Random;

public class Sudoku implements IGame {
	Random randy = new Random();
	/**
	 * the number of numbers that the sudoku board begins with, it is determined by the difficulty selected
	 */
	int startingAmountOfNumbers;
	private Board gameBoard;
	private Board solution;

	@Override
	public void setUpBoard() {
		boolean loop = false;
		do {
			generateSudokuBoard();
			loop = solve();
		} while (!loop);
	}

	@Override
	public void setUpGame(Difficulty difficulty) {
		gameBoard = new Board();
		solution = new Board();
		gameBoard.setSize(9);
		solution.setSize(9);
		switch (difficulty) {
			case EASY -> startingAmountOfNumbers = 60;
			case MEDIUM -> startingAmountOfNumbers = 50;
			case HARD -> startingAmountOfNumbers = 30;
		}
		setUpBoard();
	}

	@Override
	public boolean checkForWin() {
		int checkForWin = 0;
		for (int row = 0; row < gameBoard.getSize(); row++) {
			for (int col = 0; col < gameBoard.getSize(); col++) {
				if (gameBoard.board[row][col] == 0) {
					checkForWin++;
				} else if (gameBoard.board[row][col] != solution.board[row][col]) {
					checkForWin++;
				}
			}
		}
		return checkForWin == 0;
	}

	public Board getBoard() {
		return gameBoard;
	}

	/**
	 * makes a Sudoku board with random numbers in it, could be unsolvable, run the solve method to check
	 */
	public void generateSudokuBoard() {
		for (int i = 0; i < gameBoard.board.length; i++) {
			for (int j = 0; j < gameBoard.board.length; j++) {
				gameBoard.board[i][j] = 0;
				solution.board[i][j] = 0;
			}
		}
		for (int i = 0; i < (startingAmountOfNumbers); i++) {
			int newNum = randy.nextInt(9) + 1;
			int row = randy.nextInt(8) + 1;
			int col = randy.nextInt(8) + 1;

			if (isOk(row, col, newNum)) {
				gameBoard.board[row][col] = newNum;
			} else {
				i--;
			}
		}

		for (int i = 0; i < solution.board.length; i++) {
			for (int j = 0; j < solution.board.length; j++) {
				solution.board[i][j] = gameBoard.board[i][j];
			}
		}
		solve();
	}

	//checks to make sure the number that is going to be placed is safe for the row
	private boolean safeNumberForRow(int rowNum, int enteredNum) {
		boolean isInRow = false;
		for (int i = 0; i < 9; i++) {
			if (gameBoard.board[rowNum][i] == enteredNum || solution.board[rowNum][i] == enteredNum) {
				isInRow = true;
			}
			if (isInRow) {
				return false;
			}
		}
		return true;
	}

	//checks to make sure the number that is going to be placed is safe for the column
	private boolean safeNumberForColumn(int colNum, int enteredNum) {
		boolean isInCol = false;
		for (int i = 0; i < 9; i++) {
			if (gameBoard.board[i][colNum] == enteredNum || solution.board[i][colNum] == enteredNum) {
				isInCol = true;
			}
			if (isInCol) {
				return false;
			}
		}
		return true;
	}

	//checks to make sure the number that is going to be placed is safe for the square
	private boolean safeForSquare(int rowNum, int colNum, int enteredNum) {
		int row = rowNum % 3;
		int col = colNum % 3;
		int top = rowNum - row;
		int farLeft = colNum - col;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (top + i == rowNum && farLeft + j == colNum) {
					continue;
				} else {
					if (gameBoard.board[top + i][farLeft + j] == enteredNum || solution.board[top + i][farLeft + j] == enteredNum) {
						return false;
					}
				}
			}
		}


		return true;
	}

	//checks to make sure the number that is going to be placed is safe for the row, column and, square
	private boolean isOk(int row, int col, int num) {
		return safeForSquare(row, col, num) && safeNumberForColumn(col, num) && safeNumberForRow(row, num);
	}

	/**
	 * solves the sudoku and store the answer in another board will return false if the board is unsolvable
	 *
	 * @return returns true if the board could be solved
	 */
	public boolean solve() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (solution.board[row][col] == 0) {
					for (int number = 1; number <= 9; number++) {
						if (isOk(row, col, number)) {
							solution.board[row][col] = number;
							if (solve()) {
								return true;
							} else {
								solution.board[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
