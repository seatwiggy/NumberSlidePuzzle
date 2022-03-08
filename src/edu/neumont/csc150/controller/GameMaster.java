package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.view.GamePanel;
import edu.neumont.csc150.view.GameView;
import edu.neumont.csc150.view.SudokuPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameMaster {
	private final GameView ui = new GameView();
	private final ActionListener sudokuInputListener = e -> {
		JButton source = (JButton) e.getSource();
		ui.getSudokuPanel().setInputNumber(Integer.parseInt(source.getText()));
	};
	private IGame currentGame;
	private GamePanel currentGamePanel;
	private final ActionListener sudokuListener = e -> {
		int buttonRow = -1;
		int buttonColumn = -1;
		for (int row = 0; row < currentGamePanel.getBoard().length; row++) {
			for (int column = 0; column < currentGamePanel.getBoard()[row].length; column++) {
				if (e.getSource() == currentGamePanel.getBoard()[row][column]) {
					buttonRow = row;
					buttonColumn = column;
				}
			}
		}
		currentGame.getBoard().getBoard()[buttonRow][buttonColumn] = ui.getSudokuPanel().getInputNumber();
		updateNumberBoard();
		if (currentGame.checkForWin()) {
			ui.showWinPanel();
		}
	};
	private final ActionListener ticTacToeListener = e -> {
		TicTacToe ticTacToe = (TicTacToe) currentGame;
		int buttonRow = -1;
		int buttonColumn = -1;
		for (int row = 0; row < currentGamePanel.getBoard().length; row++) {
			for (int column = 0; column < currentGamePanel.getBoard()[row].length; column++) {
				if (e.getSource() == currentGamePanel.getBoard()[row][column]) {
					buttonRow = row;
					buttonColumn = column;
				}
			}
		}
		currentGame.getBoard().getBoard()[buttonRow][buttonColumn] = 1;
		ticTacToe.botsTurn();
		updateTicTacToeBoard();
		if (currentGame.checkForWin()) {
			if (ticTacToe.isPlayerWins()) {
				ui.showWinPanel();
			} else {
				ui.showLosePanel();
			}
		} else {
			if (ticTacToe.isTie()) {
				ui.showTiePanel();
			}
		}
	};
	private final ActionListener numberPuzzleListener = e -> {
		NumberPuzzle numberPuzzle = (NumberPuzzle) currentGame;
		int buttonRow = -1;
		int buttonColumn = -1;
		for (int row = 0; row < currentGamePanel.getBoard().length; row++) {
			for (int column = 0; column < currentGamePanel.getBoard()[row].length; column++) {
				if (e.getSource() == currentGamePanel.getBoard()[row][column]) {
					buttonRow = row;
					buttonColumn = column;
				}
			}
		}
		if (buttonRow != 0 && currentGame.getBoard().getBoard()[buttonRow - 1][buttonColumn] == 0) {
			numberPuzzle.moveValues(buttonRow, buttonColumn, buttonRow - 1, buttonColumn);
		} else if (buttonRow + 1 != currentGame.getBoard().getBoard().length && currentGame.getBoard().getBoard()[buttonRow + 1][buttonColumn] == 0) {
			numberPuzzle.moveValues(buttonRow, buttonColumn, buttonRow + 1, buttonColumn);
		} else if (buttonColumn != 0 && currentGame.getBoard().getBoard()[buttonRow][buttonColumn - 1] == 0) {
			numberPuzzle.moveValues(buttonRow, buttonColumn, buttonRow, buttonColumn - 1);
		} else if (buttonColumn + 1 != currentGame.getBoard().getBoard()[buttonRow].length && currentGame.getBoard().getBoard()[buttonRow][buttonColumn + 1] == 0) {
			numberPuzzle.moveValues(buttonRow, buttonColumn, buttonRow, buttonColumn + 1);
		}
		updateNumberBoard();
		if (currentGame.checkForWin()) {
			ui.showWinPanel();
		}
	};
	private final ActionListener difficultyMenuListener = e -> {
		currentGame.setUpGame(Difficulty.valueOf(((JButton) e.getSource()).getText().toUpperCase()));
		currentGamePanel.initializeBoard(currentGame.getBoard().getNumberOfRows(), currentGame.getBoard().getNumberOfColumns());
		currentGamePanel.placeButtons();
		switch (currentGame.getClass().getSimpleName()) {
			case "NumberPuzzle" -> ui.showSlidePuzzlePanel();
			case "Sudoku" -> ui.showSudokuPanel();
		}
		runGame();
	};
	private final ActionListener mainMenuListener = e -> {
		ui.initializeGamePanels();
		switch (((JButton) e.getSource()).getText()) {
			case "Number Slide Puzzle" -> {
				currentGame = new NumberPuzzle();
				currentGamePanel = ui.getSlidePuzzlePanel();
			}
			case "Sudoku" -> {
				currentGame = new Sudoku();
				currentGamePanel = ui.getSudokuPanel();
			}
			case "Tic Tac Toe" -> {
				currentGame = new TicTacToe();
				currentGamePanel = ui.getTicTacToePanel();
			}
		}
		switch (currentGame.getClass().getSimpleName()) {
			case "NumberPuzzle", "Sudoku" -> ui.showDifficultyMenu();
			case "TicTacToe" -> {
				currentGame.setUpGame(null);
				currentGamePanel.initializeBoard(currentGame.getBoard().getNumberOfRows(), currentGame.getBoard().getNumberOfColumns());
				currentGamePanel.placeButtons();
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
		switch (currentGame.getClass().getSimpleName()) {
			case "NumberPuzzle" -> {
				updateNumberBoard();
				for (JButton[] jButtons : currentGamePanel.getBoard()) {
					for (JButton jButton : jButtons) {
						jButton.addActionListener(numberPuzzleListener);
					}
				}
			}
			case "Sudoku" -> {
				updateNumberBoard();
				for (JButton[] jButtons : currentGamePanel.getBoard()) {
					for (JButton jButton : jButtons) {
						if (jButton.getText().equals("")) {
							jButton.addActionListener(sudokuListener);
						} else {
							jButton.setEnabled(false);
						}
					}
				}
				SudokuPanel sudokuPanel = (SudokuPanel) currentGamePanel;
				for (JButton jButton : sudokuPanel.getInputButtons()) {
					jButton.addActionListener(sudokuInputListener);
				}
			}
			case "TicTacToe" -> {
				updateTicTacToeBoard();
				for (JButton[] jButtons : currentGamePanel.getBoard()) {
					for (JButton jButton : jButtons) {
						jButton.addActionListener(ticTacToeListener);
					}
				}
			}
		}
	}

	private void updateTicTacToeBoard() {
		for (int row = 0; row < currentGamePanel.getBoard().length; row++) {
			for (int column = 0; column < currentGamePanel.getBoard()[row].length; column++) {
				switch (currentGame.getBoard().getBoard()[row][column]) {
					case 0 -> currentGamePanel.getBoard()[row][column].setText("");
					case 1 -> {
						currentGamePanel.getBoard()[row][column].setText("X");
						currentGamePanel.getBoard()[row][column].setEnabled(false);
					}
					case 2 -> {
						currentGamePanel.getBoard()[row][column].setText("O");
						currentGamePanel.getBoard()[row][column].setEnabled(false);
					}
				}
			}
		}
	}

	private void updateNumberBoard() {
		for (int row = 0; row < currentGamePanel.getBoard().length; row++) {
			for (int column = 0; column < currentGamePanel.getBoard()[row].length; column++) {
				if (currentGame.getBoard().getBoard()[row][column] == 0) {
					currentGamePanel.getBoard()[row][column].setText("");
				} else {
					currentGamePanel.getBoard()[row][column].setText(Integer.toString(currentGame.getBoard().getBoard()[row][column]));
				}
			}
		}
	}
}
