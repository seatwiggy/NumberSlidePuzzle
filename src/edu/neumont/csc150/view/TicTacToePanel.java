package edu.neumont.csc150.view;

import javax.swing.*;

public class TicTacToePanel extends GamePanel {
	TicTacToePanel(JFrame frame) {
		super(frame);

		setTitleLabel(new JLabel("Tic Tac Toe", SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(200, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);

		add(getTitleLabel());
	}
}
