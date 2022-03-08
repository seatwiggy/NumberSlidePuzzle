package edu.neumont.csc150.view;

import javax.swing.*;

public class DifficultyMenu extends ViewPanel {
	private final JButton easyButton;
	private final JButton mediumButton;
	private final JButton hardButton;

	DifficultyMenu(JFrame frame) {
		super(frame);

		setTitleLabel(new JLabel("Choose a difficulty", SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(190, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);

		easyButton = new JButton("Easy");
		easyButton.setFont(GameView.font);
		easyButton.setSize(110, 30);
		easyButton.setLocation((getWidth() / 2) - (easyButton.getWidth() / 2), getTitleLabel().getY() + getTitleLabel().getHeight() + 10);

		mediumButton = new JButton("Medium");
		mediumButton.setFont(GameView.font);
		mediumButton.setSize(110, 30);
		mediumButton.setLocation((getWidth() / 2) - (mediumButton.getWidth() / 2), easyButton.getY() + easyButton.getHeight() + 10);

		hardButton = new JButton("Hard");
		hardButton.setFont(GameView.font);
		hardButton.setSize(110, 30);
		hardButton.setLocation((getWidth() / 2) - (hardButton.getWidth() / 2), mediumButton.getY() + mediumButton.getHeight() + 10);

		add(getTitleLabel());
		add(easyButton);
		add(mediumButton);
		add(hardButton);
	}
}
