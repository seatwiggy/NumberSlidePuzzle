package edu.neumont.csc150.model;

public class Board {
    private Difficulty difficulty;
    private Square[][] squares;
    private int size;
    public void setUPBoard(int size){
        squares = new Square[size][size];
        this.size = size;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
