package edu.neumont.csc150.view;

import javax.swing.*;

public class MainMenu extends ViewPanel {
	JButton slidePuzzleButton;
	JButton sudokuButton;
	JButton ticTacToeButton;

	MainMenu(JFrame frame) {
		super(frame);

		setTitleLabel(new JLabel("What game would you like to play?", SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(350, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);

		slidePuzzleButton = new JButton("Number Slide Puzzle");
		slidePuzzleButton.setSize(240, 30);
		slidePuzzleButton.setFont(GameView.font);
		slidePuzzleButton.setLocation((getWidth() / 2) - (slidePuzzleButton.getWidth() / 2), getTitleLabel().getY() + getTitleLabel().getHeight() + 10);

		sudokuButton = new JButton("Sudoku");
		sudokuButton.setFont(GameView.font);
		sudokuButton.setSize(240, 30);
		sudokuButton.setLocation((getWidth() / 2) - (sudokuButton.getWidth() / 2), slidePuzzleButton.getY() + slidePuzzleButton.getHeight() + 10);

		ticTacToeButton = new JButton("Tic Tac Toe");
		ticTacToeButton.setFont(GameView.font);
		ticTacToeButton.setSize(240, 30);
		ticTacToeButton.setLocation((getWidth() / 2) - (ticTacToeButton.getWidth() / 2), sudokuButton.getY() + sudokuButton.getHeight() + 10);

		add(getTitleLabel());
		add(slidePuzzleButton);
		add(sudokuButton);
		add(ticTacToeButton);
	}
}
