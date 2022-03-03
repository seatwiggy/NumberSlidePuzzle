package edu.neumont.csc150.models;


public class Board {
    protected int[][] board;
    private int numberOfRows;
    private int numberOfColumns;

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setGetNumberOfColumns(int getNumberOfColumns) {
        this.numberOfColumns = getNumberOfColumns;
    }

    public int[][] getBoard() {
        return board;
    }
}