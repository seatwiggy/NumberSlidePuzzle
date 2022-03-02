package edu.neumont.csc150.models;

public interface IGame {
    public void setUpBoard();

    public void setUpGame(Difficulty difficulty);

    public boolean checkForWin();

    public Board getBoard();

}
