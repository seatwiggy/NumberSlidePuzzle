package edu.neumont.csc150.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView {
	public final Font font = new Font("Comic Sans MS", Font.BOLD, 20);
	private final JFrame frame = new JFrame("Games");
	private final JPanel mainMenuPanel = new JPanel(null);
	private final JPanel difficultyMenuPanel = new JPanel(null);
	private JButton[][] squares;

	public GameView() {
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		mainMenu();
		difficultyMenu();
	}

	private void mainMenu() {
		mainMenuPanel.setSize(frame.getWidth(), frame.getHeight());

		JLabel titleLabel = new JLabel("What game would you like to play?", SwingConstants.CENTER);
		titleLabel.setFont(font);
		titleLabel.setSize(350, 30);
		titleLabel.setLocation((mainMenuPanel.getWidth() / 2) - (titleLabel.getWidth() / 2), 10);
		mainMenuPanel.add(titleLabel);

		JButton slidePuzzleButton = new JButton("Number Slide Puzzle");
		slidePuzzleButton.setSize(240, 30);
		slidePuzzleButton.setLocation((mainMenuPanel.getWidth() / 2) - (slidePuzzleButton.getWidth() / 2), titleLabel.getY() + titleLabel.getHeight() + 10);
		slidePuzzleButton.setFont(font);
		mainMenuPanel.add(slidePuzzleButton);

		JButton sudokuButton = new JButton("Sudoku");
		sudokuButton.setFont(font);
		sudokuButton.setSize(240, 30);
		sudokuButton.setLocation((mainMenuPanel.getWidth() / 2) - (sudokuButton.getWidth() / 2), slidePuzzleButton.getY() + slidePuzzleButton.getHeight() + 10);
		mainMenuPanel.add(sudokuButton);

		JButton ticTacToeButton = new JButton("Tic Tac Toe");
		ticTacToeButton.setFont(font);
		ticTacToeButton.setSize(240, 30);
		ticTacToeButton.setLocation((mainMenuPanel.getWidth() / 2) - (ticTacToeButton.getWidth() / 2), sudokuButton.getY() + sudokuButton.getHeight() + 10);
		mainMenuPanel.add(ticTacToeButton);
	}

	private void difficultyMenu() {
		difficultyMenuPanel.setSize(frame.getWidth(), frame.getHeight());
		JLabel titleLabel = new JLabel("Choose a difficulty", SwingConstants.CENTER);
		titleLabel.setFont(font);
		titleLabel.setSize(190, 30);
		titleLabel.setLocation((difficultyMenuPanel.getWidth() / 2) - (titleLabel.getWidth() / 2), 10);
		difficultyMenuPanel.add(titleLabel);

		JButton easyButton = new JButton("Easy");
		easyButton.setFont(font);
		easyButton.setSize(110, 30);
		easyButton.setLocation((difficultyMenuPanel.getWidth() / 2) - (easyButton.getWidth() / 2), titleLabel.getY() + titleLabel.getHeight() + 10);
		difficultyMenuPanel.add(easyButton);

		JButton mediumButton = new JButton("Medium");
		mediumButton.setFont(font);
		mediumButton.setSize(110, 30);
		mediumButton.setLocation((difficultyMenuPanel.getWidth() / 2) - (mediumButton.getWidth() / 2), easyButton.getY() + easyButton.getHeight() + 10);
		difficultyMenuPanel.add(mediumButton);

		JButton hardButton = new JButton("Hard");
		hardButton.setFont(font);
		hardButton.setSize(110, 30);
		hardButton.setLocation((frame.getWidth() / 2) - (hardButton.getWidth() / 2), mediumButton.getY() + mediumButton.getHeight() + 10);
		difficultyMenuPanel.add(hardButton);
	}

	public void showMainMenu() {
		frame.removeAll();
		for (Component component : mainMenuPanel.getComponents()) {
			frame.add(component);
		}
	}

	public void showDifficultyMenu() {
		frame.removeAll();
		for (Component component : difficultyMenuPanel.getComponents()) {
			frame.add(component);
		}
	}

	public ArrayList<JButton> getMainMenuButtons() {
		ArrayList<JButton> buttons = new ArrayList<>();
		for (Component component : mainMenuPanel.getComponents()) {
			if (component instanceof JButton) {
				buttons.add((JButton) component);
			}
		}
		return buttons;
	}
}
