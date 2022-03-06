package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.view.GameView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameMaster {
	private static IGame currentGame;
	private final GameView ui = new GameView();
	private final ActionListener difficultyMenuListener = e -> {
		currentGame.setUpGame(Difficulty.valueOf(((JButton) e.getSource()).getText().toUpperCase()));
		ui.setUpBoard(currentGame.getBoard().getNumberOfRows(), currentGame.getBoard().getNumberOfColumns());
		switch (currentGame.getClass().getSimpleName()) {
			case "NumberPuzzle" -> ui.showSlidePuzzlePanel();
			case "Sudoku" -> ui.showSudokuPanel();
		}
		runGame();
	};
	private final ActionListener mainMenuListener = e -> {
		switch (((JButton) e.getSource()).getText()) {
			case "Number Slide Puzzle" -> currentGame = new NumberPuzzle();
			case "Sudoku" -> currentGame = new Sudoku();
			case "Tic Tac Toe" -> currentGame = new TicTacToe();
		}
		switch (currentGame.getClass().getSimpleName()) {
			case "NumberPuzzle", "Sudoku" -> ui.showDifficultyMenu();
			case "TicTacToe" -> {
				ui.showTicTacToePanel();
				runGame();
			}
		}
	};

	public void run() {
		for (JButton button : ui.getMainMenuButtons()) {
			button.addActionListener(mainMenuListener);
		}
		for (JButton button : ui.getDifficultyMenuButtons()) {
			button.addActionListener(difficultyMenuListener);
		}
		ui.showMainMenu();
	}

	private void runGame() {
		while (!currentGame.checkForWin()) {
			for (int row = 0; row < ui.getBoard().length; row++) {
				for (int column = 0; column < ui.getBoard()[row].length; column++) {
					ui.getBoard()[row][column].setText(Integer.toString(currentGame.getBoard().getBoard()[row][column]));
				}
			}
		}
	}
}
