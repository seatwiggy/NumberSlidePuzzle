package edu.neumont.csc150.models;

public class Board {
	protected int[][] board;
	private Difficulty difficulty;
	private int size;

	public Board(Difficulty difficulty) {
		setDifficulty(difficulty);
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}