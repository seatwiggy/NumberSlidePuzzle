package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.*;
import edu.neumont.csc150.view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMaster {
	private final GameView ui = new GameView();
	Difficulty difficulty;
	private final ActionListener setDifficulty = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			difficulty = Difficulty.valueOf(((JButton) e.getSource()).getText().toUpperCase());
		}
	};
	private IGame currentGame;
	private final ActionListener setGame = e -> {
		switch (((JButton) e.getSource()).getText()) {
			case "Number Slide Puzzle" -> {
				currentGame = new SlidePuzzle();
				ui.showDifficultyMenu();
			}
			case "Sudoku" -> {
				currentGame = new Sudoku();
				ui.showDifficultyMenu();
			}
			case "Tic Tac Toe" -> currentGame = new TicTacToe();
		}
	};

	public void run() {
		for (JButton button : ui.getMainMenuButtons()) {
			button.addActionListener(setGame);
		}

		ui.showMainMenu();
	}
}
