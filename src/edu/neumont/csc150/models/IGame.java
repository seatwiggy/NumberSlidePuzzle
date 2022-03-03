package edu.neumont.csc150.models;

public interface IGame {
    void setUpBoard();

    void setUpGame(Difficulty difficulty);

    boolean checkForWin();

    Board getBoard();

}
