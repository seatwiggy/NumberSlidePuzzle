package edu.neumont.csc150.view;

import javax.swing.*;

public class SudokuPanel extends GamePanel {
	private JButton inputOne;
	private JButton inputTwo;
	private JButton inputThree;
	private JButton inputFour;
	private JButton inputFive;
	private JButton inputSix;
	private JButton inputSeven;
	private JButton inputEight;
	private JButton inputNine;

	private int inputNumber = 0;

	SudokuPanel(JFrame frame) {
		setSize(frame.getWidth(), frame.getHeight());

		setTitleLabel(new JLabel("Sudoku", SwingConstants.CENTER));
		getTitleLabel().setFont(GameView.font);
		getTitleLabel().setSize(70, 30);
		getTitleLabel().setLocation((getWidth() / 2) - (getTitleLabel().getWidth() / 2), 10);
		add(getTitleLabel());
	}

	@Override
	public void placeButtons() {
		inputOne = new JButton("1");
		inputOne.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputOne.setLocation(5, getHeight() - inputOne.getHeight() - 40);
		add(inputOne);

		inputTwo = new JButton("2");
		inputTwo.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputTwo.setLocation(inputOne.getX() + inputOne.getWidth() + 5, getHeight() - inputTwo.getHeight() - 40);
		add(inputTwo);

		inputThree = new JButton("3");
		inputThree.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputThree.setLocation(inputTwo.getX() + inputTwo.getWidth() + 5, getHeight() - inputThree.getHeight() - 40);
		add(inputThree);

		inputFour = new JButton("4");
		inputFour.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputFour.setLocation(inputThree.getX() + inputThree.getWidth() + 5, getHeight() - inputFour.getHeight() - 40);
		add(inputFour);

		inputFive = new JButton("5");
		inputFive.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputFive.setLocation(inputFour.getX() + inputFour.getWidth() + 5, getHeight() - inputFive.getHeight() - 40);
		add(inputFive);

		inputSix = new JButton("6");
		inputSix.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputSix.setLocation(inputFive.getX() + inputFive.getWidth() + 5, getHeight() - inputSix.getHeight() - 40);
		add(inputSix);

		inputSeven = new JButton("7");
		inputSeven.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputSeven.setLocation(inputSix.getX() + inputSix.getWidth() + 5, getHeight() - inputSeven.getHeight() - 40);
		add(inputSeven);

		inputEight = new JButton("8");
		inputEight.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputEight.setLocation(inputSeven.getX() + inputSeven.getWidth() + 5, getHeight() - inputEight.getHeight() - 40);
		add(inputEight);

		inputNine = new JButton("9");
		inputNine.setSize(((getWidth() - 10) / 9) - 10, ((getWidth() - 10) / 9) - 10);
		inputNine.setLocation(inputEight.getX() + inputEight.getWidth() + 5, getHeight() - inputNine.getHeight() - 40);
		add(inputNine);

		super.placeButtons();
	}

	public JButton[] getInputButtons() {
		return new JButton[]{inputOne, inputTwo, inputThree, inputFour, inputFive, inputSix, inputSeven, inputEight, inputNine};
	}

	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}
}