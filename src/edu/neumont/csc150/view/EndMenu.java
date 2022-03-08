package edu.neumont.csc150.view;

import javax.swing.*;

public class EndMenu extends ViewPanel {
	JButton button;

	EndMenu(JFrame frame) {
		super(frame);
	}

	EndMenu(JFrame frame, String label) {
		super(frame);

		setTitleLabel(new JLabel(label, SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(300, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);

		button = new JButton("Play another game?");
		button.setFont(GameView.font);
		button.setSize(230, 50);
		button.setLocation((getWidth() / 2) - (button.getWidth() / 2), (getHeight() / 2) - (button.getHeight() / 2));

		add(getTitleLabel());
		add(button);
	}

	public JButton getButton() {
		return button;
	}
}
