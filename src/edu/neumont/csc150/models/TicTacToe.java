package edu.neumont.csc150.models;

public class TicTacToe implements IGame {
    private Board gameBoard;
    /**
     * if true and playing against the bot the player has on, if true and playing against another person the person playing X has won
     */
    private boolean playerWins = false;
    private boolean tie = false;

    @Override
    public void setUpBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard.board[i][j] = 0;
            }
        }
    }

    @Override
    public void setUpGame(Difficulty difficulty) {
        gameBoard = new Board();
        gameBoard.setNumberOfRows(3);
        gameBoard.setGetNumberOfColumns(3);
        gameBoard.board = new int[gameBoard.getNumberOfRows()][gameBoard.getNumberOfColumns()];
        playerWins = false;
        tie = false;
        setUpBoard();
    }

    @Override
    public boolean checkForWin() {
        if (gameBoard.board[0][0]==1 && gameBoard.board[0][1]==1 && gameBoard.board[0][2]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[1][0]==1 && gameBoard.board[1][1]==1 && gameBoard.board[1][2]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[2][0]==1 && gameBoard.board[2][1]==1 && gameBoard.board[2][2]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[0][1]==1 && gameBoard.board[1][1]==1 && gameBoard.board[2][1]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[0][2]==1 && gameBoard.board[1][2]==1 && gameBoard.board[2][2]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[0][0]==1 && gameBoard.board[1][0]==1 && gameBoard.board[2][0]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[0][0]==1 && gameBoard.board[1][1]==1 && gameBoard.board[2][2]==1) {
            playerWins=true;
            return true;
        }
        if (gameBoard.board[0][2]==1 && gameBoard.board[1][1]==1 && gameBoard.board[2][0]==1) {
            playerWins=true;
            return true;
        }

        if (gameBoard.board[0][0]==2 && gameBoard.board[0][1]==2 && gameBoard.board[0][2]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[1][0]==2 && gameBoard.board[1][1]==2 && gameBoard.board[1][2]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[2][0]==2 && gameBoard.board[2][1]==2 && gameBoard.board[2][2]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[0][1]==2 && gameBoard.board[1][1]==2 && gameBoard.board[2][1]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[0][2]==2 && gameBoard.board[1][2]==2 && gameBoard.board[2][2]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[0][0]==2 && gameBoard.board[1][0]==2 && gameBoard.board[2][0]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[0][0]==2 && gameBoard.board[1][1]==2 && gameBoard.board[2][2]==2) {
            playerWins=false;
            return true;
        }
        if (gameBoard.board[0][2]==2 && gameBoard.board[1][1]==2 && gameBoard.board[2][0]==2) {
            playerWins=false;
            return true;
        }
        int check = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.board[i][j] == 0) {
                    check++;
                }
            }
        }
        if (check > 0) {
            return false;
        }
        tie = true;
        return false;
    }

    public Board getBoard() {
        return gameBoard;
    }

    /**
     * makes the AI take a turn and place a 2 somewhere on the gameBoard
     */
    public void botsTurn() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 0 && j == 0) {
                    if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j + 1] == 2 && gameBoard.board[i + 2][j + 2] == 0) {
                        gameBoard.board[i + 2][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 2][j + 2] == 2 && gameBoard.board[i + 1][j + 1] == 0) {
                        gameBoard.board[i + 1][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 0) {
                        gameBoard.board[i + 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 0) {
                        gameBoard.board[i][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 2) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 2) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j + 1] == 1 && gameBoard.board[i + 2][j + 2] == 0) {
                        gameBoard.board[i + 2][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 2][j + 2] == 1 && gameBoard.board[i + 1][j + 1] == 0) {
                        gameBoard.board[i + 1][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 0) {
                        gameBoard.board[i + 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 0) {
                        gameBoard.board[i][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 1) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 1) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 1) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    }
                } else if (i == 0) {
                    if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 0) {
                        gameBoard.board[i + 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 2) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 0) {
                        gameBoard.board[i + 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 1) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    }
                } else if (j == 0) {
                    if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 0) {
                        gameBoard.board[i][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 0) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 0) {
                        gameBoard.board[i][j + 2] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 1) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    }
                } else if (i == 1 && j == 1) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i - 1][j] == 2) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 0) {
                        gameBoard.board[i - 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j - 1] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j - 1] == 2) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j - 1] == 0) {
                        gameBoard.board[i][j - 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i - 1][j] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i - 1][j] == 1) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i - 1][j] == 0) {
                        gameBoard.board[i - 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j - 1] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j - 1] == 1) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j - 1] == 0) {
                        gameBoard.board[i][j - 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i - 1][j + 1] == 1 && gameBoard.board[i + 1][j - 1] == 0) {
                        gameBoard.board[i + 1][j - 1] = 2;
                        return;
                    }
                } else if (i == 1) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i - 1][j] == 2) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 0) {
                        gameBoard.board[i - 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i - 1][j] == 0) {
                        gameBoard.board[i - 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i - 1][j] == 1) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i - 1][j] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    }
                } else if (j == 1) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j - 1] == 2) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j - 1] == 2) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j - 1] == 0) {
                        gameBoard.board[i][j - 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j - 1] == 1) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j - 1] == 1) {
                        gameBoard.board[i][j + 1] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j - 1] == 0) {
                        gameBoard.board[i][j - 1] = 2;
                        return;
                    }
                } else if (i == 2) {
                    if (gameBoard.board[i][j] == 2 && gameBoard.board[i - 1][j] == 2 && gameBoard.board[i - 2][j] == 0) {
                        gameBoard.board[i - 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i - 1][j] == 2 && !(gameBoard.board[i - 2][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i - 1][j] == 1 && gameBoard.board[i - 2][j] == 0) {
                        gameBoard.board[i - 2][j] = 2;
                        return;
                    }
                } else if (i == 0) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && !(gameBoard.board[i][j + 2] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 2] == 2 && !(gameBoard.board[i][j + 1] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && !(gameBoard.board[i + 2][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 0 && !(gameBoard.board[i][j] == 1)) {
                        gameBoard.board[i + 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 2][j] == 2 && !(gameBoard.board[i + 1][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && !(gameBoard.board[i + 2][j] == 1)) {
                        gameBoard.board[i + 1][j] = 2;
                        return;
                    }
                } else if (i == 1) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i - 1][j] == 2 && !(gameBoard.board[i + 1][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && !(gameBoard.board[i - 1][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    }
                } else if (j == 1) {
                    if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j - 1] == 2 && !(gameBoard.board[i][j + 1] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && !(gameBoard.board[i][j - 1] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    }
                } else if (i == 2) {
                    if (gameBoard.board[i - 1][j] == 2 && gameBoard.board[i - 2][j] == 0 && !(gameBoard.board[i][j] == 1)) {
                        gameBoard.board[i - 2][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i - 2][j] == 2 && !(gameBoard.board[i - 1][j] == 1)) {
                        gameBoard.board[i][j] = 2;
                        return;
                    } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i - 1][j] == 0 && !(gameBoard.board[i - 2][j] == 1)) {
                        gameBoard.board[i - 1][j] = 2;
                        return;
                    }
                } else if (gameBoard.board[1][1] == 1 && gameBoard.board[0][2] == 0) {
                    gameBoard.board[0][2] = 2;
                    return;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.board[i][j] == 0) {
                    gameBoard.board[i][j] = 2;
                    return;
                }
            }
        }
    }

    public boolean isPlayerWins() {
        return playerWins;
    }

    public boolean isTie() {
        return tie;
    }
}
