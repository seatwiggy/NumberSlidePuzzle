package edu.neumont.csc150.view;

import javax.swing.*;

public class WinPanel extends ViewPanel {
	JButton button;

	WinPanel() {
		setTitleLabel(new JLabel("Congratulations! You won!"));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(300, 30);
	}
}
