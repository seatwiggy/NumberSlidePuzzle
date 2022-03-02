package edu.neumont.csc150.models;

public abstract class Game {
    String name;

    public abstract void setUpBoard();

    public abstract void setUpGame(Difficulty difficulty);

    public abstract boolean checkForWin();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
