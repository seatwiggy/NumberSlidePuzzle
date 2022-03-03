package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMaster {
	private final GameView ui = new GameView();
	private IGame currentGame;
	private final ActionListener setDifficulty = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			currentGame.setUpGame(Difficulty.valueOf(((JButton) e.getSource()).getText().toUpperCase()));
			ui.setUpBoard(currentGame.getBoard().getBoard().length, currentGame.getBoard().getBoard()[0].length);
			switch (currentGame.getClass().getSimpleName()) {
				case "NumberPuzzle" -> ui.showSlidePuzzlePanel();
				case "Sudoku" -> ui.showSudokuPanel();
			}
			runGame();
		}
	};
	private final ActionListener setGame = e -> {
		switch (((JButton) e.getSource()).getText()) {
			case "Number Slide Puzzle" -> {
				currentGame = new NumberPuzzle();
				ui.showDifficultyMenu();
			}
			case "Sudoku" -> {
				currentGame = new Sudoku();
				ui.showDifficultyMenu();
			}
			case "Tic Tac Toe" -> {
				currentGame = new TicTacToe();
				ui.showTicTacToePanel();
				runGame();
			}
		}
	};

	public void run() {
		for (JButton button : ui.getMainMenuButtons()) {
			button.addActionListener(setGame);
		}
		for (JButton button : ui.getDifficultyMenuButtons()) {
			button.addActionListener(setDifficulty);
		}
		ui.showMainMenu();
	}

	public void runGame() {

	}
}
