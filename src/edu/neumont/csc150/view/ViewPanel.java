package edu.neumont.csc150.view;

import javax.swing.*;

public abstract class ViewPanel extends JPanel {
	private JLabel titleLabel;

	ViewPanel() {
		setLayout(null);
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
}
