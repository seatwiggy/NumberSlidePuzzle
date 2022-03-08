package edu.neumont.csc150.view;

import javax.swing.*;

public class SlidePuzzlePanel extends GamePanel {
	SlidePuzzlePanel(JFrame frame) {
		super(frame);

		setTitleLabel(new JLabel("Number Slide Puzzle", SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(200, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);

		add(getTitleLabel());
	}
}
