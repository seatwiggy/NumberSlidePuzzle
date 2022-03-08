package edu.neumont.csc150.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView {
	public static final Font font = new Font("Comic Sans MS", Font.BOLD, 20);
	private final JFrame frame;
	private final MainMenu mainMenuPanel;
	private final DifficultyMenu difficultyMenuPanel;
	private final EndMenu winMenuPanel;
	private final EndMenu loseMenuPanel;
	private final EndMenu tieMenuPanel;
	private SlidePuzzlePanel slidePuzzlePanel;
	private SudokuPanel sudokuPanel;
	private TicTacToePanel ticTacToePanel;

	public GameView() {
		frame = new JFrame("Games");

		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		mainMenuPanel = new MainMenu(frame);
		difficultyMenuPanel = new DifficultyMenu(frame);
		winMenuPanel = new EndMenu(frame, "Congratulations, you win!");
		loseMenuPanel = new EndMenu(frame, "Oops, you lost.");
		tieMenuPanel = new EndMenu(frame, "There was a tie.");
	}

	public void initializeGamePanels() {
		slidePuzzlePanel = new SlidePuzzlePanel(frame);
		sudokuPanel = new SudokuPanel(frame);
		ticTacToePanel = new TicTacToePanel(frame);
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
		frame.getContentPane().removeAll();
		frame.add(slidePuzzlePanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showSudokuPanel() {
		frame.getContentPane().removeAll();
		frame.add(sudokuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showTicTacToePanel() {
		frame.getContentPane().removeAll();
		frame.add(ticTacToePanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showWinPanel() {
		frame.getContentPane().removeAll();
		frame.add(winMenuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showLosePanel() {
		frame.getContentPane().removeAll();
		frame.add(loseMenuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public void showTiePanel() {
		frame.getContentPane().removeAll();
		frame.add(tieMenuPanel);
		frame.revalidate();
		frame.repaint();
	}

	public SlidePuzzlePanel getSlidePuzzlePanel() {
		return slidePuzzlePanel;
	}

	public SudokuPanel getSudokuPanel() {
		return sudokuPanel;
	}

	public TicTacToePanel getTicTacToePanel() {
		return ticTacToePanel;
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

	public EndMenu getWinMenuPanel() {
		return winMenuPanel;
	}

	public EndMenu getLoseMenuPanel() {
		return loseMenuPanel;
	}

	public EndMenu getTieMenuPanel() {
		return tieMenuPanel;
	}
}
