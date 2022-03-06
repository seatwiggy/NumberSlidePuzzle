package edu.neumont.csc150.models;

import java.util.Random;

public class NumberPuzzle implements IGame {
	private Board gameBoard;

	public void setUpGame(Difficulty difficulty) {
		gameBoard = new Board();
		switch (difficulty) {
			case EASY:
				gameBoard.setNumberOfRows(3);
				gameBoard.setGetNumberOfColumns(3);
				break;
			case MEDIUM:
				gameBoard.setNumberOfRows(5);
				gameBoard.setGetNumberOfColumns(5);
			case HARD:
				gameBoard.setNumberOfRows(7);
				gameBoard.setGetNumberOfColumns(7);
		}
		setUpBoard();
		shuffle();
		soutBoard();
	}

	public void setUpBoard() {
		gameBoard.board = new int[gameBoard.getNumberOfRows()][gameBoard.getNumberOfColumns()];
		int num = 1;
		for (int row = 0; row < gameBoard.getNumberOfRows(); row++) {
			for (int col = 0; col < gameBoard.getNumberOfColumns(); col++) {
				gameBoard.board[row][col] = num;
				num++;
			}
		}
		gameBoard.board[gameBoard.getNumberOfRows() - 1][gameBoard.getNumberOfColumns() - 1] = 0;
	}

	public boolean checkForWin() {
		int num = 1;
		int incorrectPieces = 0;
		for (int row = 0; row < gameBoard.getNumberOfRows(); row++) {
			for (int col = 0; col < gameBoard.getNumberOfColumns(); col++) {
				if (!(gameBoard.board[row][col] == num)) {
					incorrectPieces++;
				}else if(gameBoard.board[gameBoard.getNumberOfRows()-1][getBoard().getNumberOfColumns()-1]==0){
					incorrectPieces--;
				}
				num++;
			}
		}
		return incorrectPieces == 0;
	}

	public Board getBoard() {
		return gameBoard;
	}

	/**
	 * rearranges the values on the board so the game can be played
	 */
	private void shuffle() {
		for (int i = 0; i < 100; i++) {
			for (int row = 0; row < gameBoard.getNumberOfRows(); row++) {
				for (int col = 0; col < gameBoard.getNumberOfColumns(); col++) {
					if (gameBoard.board[row][col] == 0) {
						Random randy = new Random();
						switch (randy.nextInt(4)) {
							case 0:
								if (col != 0) {
									gameBoard.board[row][col] = gameBoard.board[row][col - 1];
									gameBoard.board[row][col - 1] = 0;
									break;
								}
							case 1:
								if (col != gameBoard.getNumberOfColumns() - 1) {
									gameBoard.board[row][col] = gameBoard.board[row][col + 1];
									gameBoard.board[row][col + 1] = 0;
									break;
								}
							case 2:
								if (row != 0) {
									gameBoard.board[row][col] = gameBoard.board[row - 1][col];
									gameBoard.board[row - 1][col] = 0;
									break;
								}
							case 3:
								if (row != gameBoard.getNumberOfRows() - 1) {
									gameBoard.board[row][col] = gameBoard.board[row + 1][col];
									gameBoard.board[row + 1][col] = 0;
								}
						}
					}
				}
			}
		}
	}

	/**
	 * swaps the values of two spots in the board
	 *
	 * @param row1 row of the first value to be swapped
	 * @param col1 column of the first value to be swapped
	 * @param row2 row of the second value to be swapped
	 * @param col2 column of the second value to be swapped
	 */
	public void moveValues(int row1, int col1, int row2, int col2) {
		int temp = gameBoard.board[row1][col1];
		gameBoard.board[row1][col1] = gameBoard.board[row2][col2];
		gameBoard.board[row2][col2] = temp;
	}

	public void soutBoard(){
		for (int row = 0; row < gameBoard.getNumberOfRows(); row++) {
			for (int col = 0; col < gameBoard.getNumberOfColumns(); col++) {
				System.out.print(gameBoard.board[row][col]);
			}
			System.out.println();
		}
	}

}
