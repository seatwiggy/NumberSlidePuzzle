package edu.neumont.csc150.view;

import javax.swing.*;

public abstract class GamePanel extends ViewPanel {
    private JButton[][] board;
    private JButton exitButton;

    GamePanel(JFrame frame) {
        super(frame);
    }

    public void initializeBoard(int rows, int columns) {
        board = new JButton[rows][columns];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = new JButton();
            }
        }
    }

    public void placeButtons() {
        exitButton = new JButton("Exit");
        exitButton.setSize(60, 50);
        exitButton.setLocation(getWidth() - exitButton.getWidth() - 15, getHeight() - exitButton.getHeight() - 40);
        add(exitButton);

        int buttonWidth = (getWidth() / getBoard()[0].length) - 10;
        int buttonHeight;
        if (getComponentCount() == 1) {
            buttonHeight = ((getHeight() - getComponent(0).getY() - getComponent(0).getHeight()) / getBoard().length) - 10;
        } else {
            buttonHeight = ((getHeight() - getComponent(0).getY() - getComponent(0).getHeight() - (getHeight() - getComponent(getComponentCount() - 1).getY())) / getBoard().length) - 10;
        }
        for (int row = 0; row < getBoard().length; row++) {
            for (int column = 0; column < getBoard()[row].length; column++) {
                JButton square = getBoard()[row][column];
                square.setSize(buttonWidth, buttonHeight);
                if (row == 0 && column == 0) {
                    square.setLocation(5, getComponent(0).getY() + getComponent(0).getHeight() + 10);
                } else if (row == 0 && column % 3 == 0) {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 10, getComponent(0).getY() + getComponent(0).getHeight() + 10);
                } else if (row == 0) {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 5, getComponent(0).getY() + getComponent(0).getHeight() + 10);
                } else if (column == 0 && row % 3 == 0) {
                    square.setLocation(5, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 10);
                } else if (column == 0) {
                    square.setLocation(5, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 5);
                } else if (row % 3 == 0 && column % 3 == 0) {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 10, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 10);
                } else if (column % 3 == 0) {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 10, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 5);
                } else if (row % 3 == 0) {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 5, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 10);
                } else {
                    square.setLocation(getBoard()[row][column - 1].getX() + getBoard()[row][column - 1].getWidth() + 5, getBoard()[row - 1][column].getY() + getBoard()[row - 1][column].getHeight() + 5);
                }
                add(square);
            }
        }
    }

    public JButton[][] getBoard() {
        return board;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
