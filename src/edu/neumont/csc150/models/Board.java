package edu.neumont.csc150.models;

public class Board {
	Square[][] board;
	Difficulty difficulty;
	int size;

	public Board(Difficulty difficulty) {
		setDifficulty(difficulty);
	}

	public void setUpGame(){
		setUpBoard();
		shuffle();
	}

	public void setUpBoard(){
		board = new Square[size][size];
		int num = 1;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = new Square();
				board[row][col].setValue(num);
				num++;
			}
		}
		board[size-1][size-1].setValue(0);
	}

	public void shuffle(){
		for (int i = 0; i < 50; i++) {
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int holdNum;
					if(row!=0) {
						if (board[row - 1][col].getValue() == 0) {
							board[row - 1][col].setValue(board[row][col].getValue());
							board[row][col].setValue(0);
						}
					}
					if(row!=2) {
						if (board[row + 1][col].getValue() == 0) {
							board[row + 1][col].setValue(board[row][col].getValue());
							board[row][col].setValue(0);
						}
					}
					if(col!=0) {
						if (board[row][col - 1].getValue() == 0) {
							board[row][col - 1].setValue(board[row][col].getValue());
							board[row][col].setValue(0);
						}
					}
					if(col!=2) {
						if (board[row][col + 1].getValue() == 0) {
							board[row][col + 1].setValue(board[row][col].getValue());
							board[row][col].setValue(0);
						}
					}
				}
			}
		}
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
		switch (difficulty){
			case easy -> setSize(3);
			case medium -> setSize(5);
			case hard -> setSize(7);
		}
	}

	public int getSize() {
		return size;
	}

	private void setSize(int size) {
		this.size = size;
	}

	public void checkingToSeeIfThingsWork(){
		setUpGame();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(" "+board[row][col].getValue());
			}
			System.out.println();
		}
	}
}
