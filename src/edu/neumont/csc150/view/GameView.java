package edu.neumont.csc150.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView {
	public final Font font = new Font("Comic Sans MS", Font.BOLD, 20);
	private final JFrame frame = new JFrame("Games");
	private final JPanel mainMenuPanel = new JPanel(null);
	private final JPanel difficultyMenuPanel = new JPanel(null);
	private final JPanel slidePuzzlePanel = new JPanel(null);
	private final JPanel sudokuPanel = new JPanel(null);
	private final JPanel ticTacToePanel = new JPanel(null);
	private JButton[][] board;

	public GameView() {
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		setUpMainMenuPanel();
		setUpDifficultyMenuPanel();
	}

	private void setUpMainMenuPanel() {
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

	private void setUpDifficultyMenuPanel() {
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
		hardButton.setLocation((difficultyMenuPanel.getWidth() / 2) - (hardButton.getWidth() / 2), mediumButton.getY() + mediumButton.getHeight() + 10);
		difficultyMenuPanel.add(hardButton);
	}

	private void placeButtons(JPanel panel) {
		int buttonWidth = (panel.getWidth() / board[0].length) - 10;
		int buttonHeight = ((panel.getHeight() - panel.getComponent(0).getY() - panel.getComponent(0).getHeight()) / board.length) - 10;
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				JButton square = board[row][column];
				square.setSize(buttonWidth, buttonHeight);
				if (row == 0 && column == 0) {
					square.setLocation(5, panel.getComponent(0).getY() + panel.getComponent(0).getHeight() + 10);
				} else if (row == 0) {
					square.setLocation(board[row][column - 1].getX() + board[row][column - 1].getWidth() + 5, panel.getComponent(0).getY() + panel.getComponent(0).getHeight() + 10);
				} else if (column == 0) {
					square.setLocation(5, board[row - 1][column].getY() + board[row - 1][column].getHeight() + 5);
				} else {
					square.setLocation(board[row][column - 1].getX() + board[row][column - 1].getWidth() + 5, board[row - 1][column].getY() + board[row - 1][column].getHeight() + 5);
				}
				panel.add(square);
			}
		}
	}

	private void setUpSlidePuzzlePanel() {
		slidePuzzlePanel.setSize(frame.getWidth(), frame.getHeight());

		JLabel titleLabel = new JLabel("Number Slide Puzzle", SwingConstants.CENTER);
		titleLabel.setFont(font);
		titleLabel.setSize(200, 30);
		titleLabel.setLocation((slidePuzzlePanel.getWidth() / 2) - (titleLabel.getWidth() / 2), 10);
		slidePuzzlePanel.add(titleLabel);

		placeButtons(slidePuzzlePanel);
	}

	private void setUpTicTacToePanel() {
		ticTacToePanel.setSize(frame.getWidth(), frame.getHeight());

		JLabel titleLabel = new JLabel("Tic Tac Toe", SwingConstants.CENTER);
		titleLabel.setFont(font);
		titleLabel.setSize(200, 30);
		titleLabel.setLocation((ticTacToePanel.getWidth() / 2) - (titleLabel.getWidth() / 2), 10);
		ticTacToePanel.add(titleLabel);

		placeButtons(ticTacToePanel);
	}

	private void setUpSudokuPanel() {
		sudokuPanel.setSize(frame.getWidth(), frame.getHeight());

		JLabel titleLabel = new JLabel("Sudoku", SwingConstants.CENTER);
		titleLabel.setFont(font);
		titleLabel.setSize(70, 30);
		titleLabel.setLocation((sudokuPanel.getWidth() / 2) - (titleLabel.getWidth() / 2), 10);
		sudokuPanel.add(titleLabel);

		placeButtons(sudokuPanel);
	}

	public void setUpBoard(int rows, int columns) {
		board = new JButton[rows][columns];
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				board[row][column] = new JButton();
			}
		}
	}

	public void showMainMenu() {
		frame.getContentPane().removeAll();
		frame.add(mainMenuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showDifficultyMenu() {
		frame.getContentPane().removeAll();
		frame.add(difficultyMenuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showSlidePuzzlePanel() {
		setUpSlidePuzzlePanel();
		frame.getContentPane().removeAll();
		frame.add(slidePuzzlePanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showSudokuPanel() {
		setUpSudokuPanel();
		frame.getContentPane().removeAll();
		frame.add(sudokuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showTicTacToePanel() {
		setUpTicTacToePanel();
		frame.getContentPane().removeAll();
		frame.add(ticTacToePanel);
		frame.revalidate();
		frame.repaint();
	}

	public ArrayList<JButton> getMainMenuButtons() {
		ArrayList<JButton> buttons = new ArrayList<>();
		for (Component component : mainMenuPanel.getComponents()) {
			if (component.getClass().getSimpleName().equals("JButton")) {
				buttons.add((JButton) component);
			}
		}
		return buttons;
	}

	public ArrayList<JButton> getDifficultyMenuButtons() {
		ArrayList<JButton> buttons = new ArrayList<>();
		for (Component component : difficultyMenuPanel.getComponents()) {
			if (component.getClass().getSimpleName().equals("JButton")) {
				buttons.add((JButton) component);
			}
		}
		return buttons;
	}

	public JButton[][] getBoard() {
		return board;
	}
}
