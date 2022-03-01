package edu.neumont.csc150.models;

import java.util.Random;

public class Board {
    int[][] board;
    Difficulty difficulty;
    int size;

    public Board(Difficulty difficulty) {
        setDifficulty(difficulty);
    }

    public void setUpGame() {
        setUpBoard();
        shuffle();
    }

    private void setUpBoard() {
        board = new int[size][size];
        int num = 1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = num;
                num++;
            }
        }
        board[size - 1][size - 1] = 0;
    }

    public void shuffle() {
        for (int i = 0; i < 100; i++) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board[row][col] == 0) {
                        Random randy = new Random();
                        switch (randy.nextInt(4)) {
                            case 0:
                                if (col != 0) {
                                    board[row][col] = board[row][col - 1];
                                    board[row][col - 1] = 0;
                                    break;
                                }
                            case 1:
                                if (col != size-1) {
                                    board[row][col] = board[row][col + 1];
                                    board[row][col + 1] = 0;
                                    break;
                                }
                            case 2:
                                if (row != 0) {
                                    board[row][col] = board[row - 1][col];
                                    board[row - 1][col] = 0;
                                    break;
                                }
                            case 3:
                                if (row != size-1) {
                                    board[row][col] = board[row + 1][col];
                                    board[row + 1][col] = 0;
                                }
                        }
                    }
                }
            }
        }
    }

    public void moveValues(int row1, int col1, int row2, int col2){
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = board[row1][col1];
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case easy -> setSize(3);
            case medium -> setSize(5);
            case hard -> setSize(7);
        }
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void checkingToSeeIfThingsWork() {
        setUpGame();
        soutBoard();
    }

    public void soutBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(" " + board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }
}