package edu.neumont.csc150.models;

import java.util.Random;

public class NumberPuzzle implements IGame{
    private Board gameBoard;
    public void setUpGame(Difficulty difficulty) {
        gameBoard = new Board();
        switch (difficulty) {
            case easy -> gameBoard.setSize(3);
            case medium -> gameBoard.setSize(5);
            case hard -> gameBoard.setSize(7);
        }
        setUpBoard();
        shuffle();
    }

    public void setUpBoard() {
        gameBoard.board = new int[gameBoard.getSize()][gameBoard.getSize()];
        int num = 1;
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int col = 0; col < gameBoard.getSize(); col++) {
                gameBoard.board[row][col] = num;
                num++;
            }
        }
        gameBoard.board[gameBoard.getSize() - 1][gameBoard.getSize() - 1] = 0;
    }

    public boolean checkForWin(){
        int num = 1;
        int incorrectPieces =0;
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int col = 0; col < gameBoard.getSize(); col++) {
                if(!(gameBoard.board[row][col] == num)){
                    incorrectPieces++;
                }
                gameBoard.board[row][col] = num;
                num++;
            }
        }
        return incorrectPieces == 0;
    }

    public void getBoard(){
        gameBoard.getBoard();
    }


    /**
     * rearranges the values on the board so the game can be played
     */
    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            for (int row = 0; row < gameBoard.getSize(); row++) {
                for (int col = 0; col < gameBoard.getSize(); col++) {
                    if (gameBoard.board[row][col] == 0) {
                        Random randy = new Random();
                        switch (randy.nextInt(4)) {
                            case 0:
                                if (col != 0) {
                                    gameBoard.board[row][col] = gameBoard.board[row][col - 1];
                                    gameBoard.board[row][col - 1] = 0;
                                    break;
                                }
                            case 1:
                                if (col != gameBoard.getSize()-1) {
                                    gameBoard.board[row][col] = gameBoard.board[row][col + 1];
                                    gameBoard.board[row][col + 1] = 0;
                                    break;
                                }
                            case 2:
                                if (row != 0) {
                                    gameBoard.board[row][col] = gameBoard.board[row - 1][col];
                                    gameBoard.board[row - 1][col] = 0;
                                    break;
                                }
                            case 3:
                                if (row != gameBoard.getSize()-1) {
                                    gameBoard.board[row][col] = gameBoard.board[row + 1][col];
                                    gameBoard.board[row + 1][col] = 0;
                                }
                        }
                    }
                }
            }
        }
    }

    /**
     * swaps the values of to spots in the board
     * @param row1 row of the first value to be swapped
     * @param col1 column of the first value to be swapped
     * @param row2 row of the second value to be swapped
     * @param col2 column of the second value to be swapped
     */
    public void moveValues(int row1, int col1, int row2, int col2){
        int temp = gameBoard.board[row1][col1];
        gameBoard.board[row1][col1] = gameBoard.board[row2][col2];
        gameBoard.board[row2][col2] = temp;
    }
}
