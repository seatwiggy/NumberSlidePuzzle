package edu.neumont.csc150.controller;

import edu.neumont.csc150.models.IGame;
import edu.neumont.csc150.models.SlidePuzzle;
import edu.neumont.csc150.models.Sudoku;
import edu.neumont.csc150.models.TicTacToe;
import edu.neumont.csc150.view.GameView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameMaster {
	private final GameView ui = new GameView();
	private IGame currentGame;
	private final ActionListener setGame = e -> {
		switch (((JButton) e.getSource()).getText()) {
			case "Number Slide Puzzle" -> currentGame = new SlidePuzzle();
			case "Sudoku" -> currentGame = new Sudoku();
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
