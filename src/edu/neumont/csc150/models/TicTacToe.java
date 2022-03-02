package edu.neumont.csc150.models;

public class TicTacToe implements IGame {
     Board gameBoard;
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
        gameBoard = new Board(difficulty);
        gameBoard.setSize(3);
        playerWins=false;
        tie=false;
        setUpBoard();
    }

    public void updateBoard(int a, int b, int c, int d, int e, int f, int g, int h, int k) {
        gameBoard.board[0][0] = a;
        gameBoard.board[0][1] = b;
        gameBoard.board[0][2] = c;
        gameBoard.board[1][0] = d;
        gameBoard.board[1][1] = e;
        gameBoard.board[1][2] = f;
        gameBoard.board[2][0] = g;
        gameBoard.board[2][1] = h;
        gameBoard.board[2][2] = k;

    }

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
                if (gameBoard.board[i][j]==0) {
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

    public void botsTurn() {
        int played = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (played == 0) {
                    if (i == 0 && j == 0) {
                        if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j + 1] == 2 && gameBoard.board[i + 2][j + 2] == 0) {
                            gameBoard.board[i + 2][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 2][j + 2] == 2 && gameBoard.board[i + 1][j + 1] == 0) {
                            gameBoard.board[i + 1][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 0) {
                            gameBoard.board[i + 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 0) {
                            gameBoard.board[i][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 2) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 2) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 2) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j + 1] == 1 && gameBoard.board[i + 2][j + 2] == 0) {
                            gameBoard.board[i + 2][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 2][j + 2] == 1 && gameBoard.board[i + 1][j + 1] == 0) {
                            gameBoard.board[i + 1][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 0) {
                            gameBoard.board[i + 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 0) {
                            gameBoard.board[i][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 1) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 1) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 1) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        }
                    } else if (i == 0) {
                        if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 0) {
                            gameBoard.board[i + 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i + 2][j] == 2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 2) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 0) {
                            gameBoard.board[i + 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 1 && gameBoard.board[i + 2][j] == 1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i + 2][j] == 1) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        }
                    } else if (j == 0) {
                        if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 0) {
                            gameBoard.board[i][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j + 2] == 2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 0) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 0) {
                            gameBoard.board[i][j + 2] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 1 && gameBoard.board[i][j + 2] == 1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 1 && gameBoard.board[i][j + 1] == 0 && gameBoard.board[i][j + 2] == 1) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        }
                    } else if (i == 1 && j == 1) {
                        if (gameBoard.board[i][j] == 0 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 0 && gameBoard.board[i - 1][j] == 2) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 2 && gameBoard.board[i + 1][j] == 2 && gameBoard.board[i - 1][j] == 0) {
                            gameBoard.board[i - 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j] == 0 && gameBoard.board[i][j + 1] == 2 && gameBoard.board[i][j - 1] == 2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i][j + 1]==0 && gameBoard.board[i][j - 1]==2) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i][j + 1]==2 && gameBoard.board[i][j - 1]==0) {
                            gameBoard.board[i][j - 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i + 1][j]==1 && gameBoard.board[i - 1][j]==1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i + 1][j]==0 && gameBoard.board[i - 1][j]==1) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i + 1][j]==1 && gameBoard.board[i - 1][j]==0) {
                            gameBoard.board[i - 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 1]==1 && gameBoard.board[i][j - 1]==1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i][j + 1]==0 && gameBoard.board[i][j - 1]==1) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i][j + 1]==1 && gameBoard.board[i][j - 1]==0) {
                            gameBoard.board[i][j - 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i - 1][j + 1]==1 && gameBoard.board[i + 1][j - 1]==0) {
                            gameBoard.board[i + 1][j - 1] = 2;
                            played++;
                        }
                    } else if (i == 1) {
                        if (gameBoard.board[i][j]==0 && gameBoard.board[i + 1][j]==2 && gameBoard.board[i - 1][j]==2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i + 1][j]==0 && gameBoard.board[i - 1][j]==2) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i + 1][j]==2 && gameBoard.board[i - 1][j]==0) {
                            gameBoard.board[i - 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i + 1][j]==1 && gameBoard.board[i - 1][j]==0) {
                            gameBoard.board[i - 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i + 1][j]==0 && gameBoard.board[i - 1][j]==1) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i + 1][j]==1 && gameBoard.board[i - 1][j]==1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        }

                    } else if (j == 1) {
                        if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 1]==2 && gameBoard.board[i][j - 1]==2) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i][j + 1]==0 && gameBoard.board[i][j - 1]==2) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i][j + 1]==2 && gameBoard.board[i][j - 1]==0) {
                            gameBoard.board[i][j - 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 1]==1 && gameBoard.board[i][j - 1]==1) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i][j + 1]==0 && gameBoard.board[i][j - 1]==1) {
                            gameBoard.board[i][j + 1] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i][j + 1]==1 && gameBoard.board[i][j - 1]==0) {
                            gameBoard.board[i][j - 1] = 2;
                            played++;
                        }
                    } else if (i == 2) {
                        if (gameBoard.board[i][j]==2 && gameBoard.board[i - 1][j]==2 && gameBoard.board[i - 2][j]==0) {
                            gameBoard.board[i - 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i - 1][j]==2 && !(gameBoard.board[i - 2][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==1 && gameBoard.board[i - 1][j]==1 && gameBoard.board[i - 2][j]==0) {
                            gameBoard.board[i - 2][j] = 2;
                            played++;
                        }
                    } else if (i == 0) {
                        if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 1]==2 && !(gameBoard.board[i][j + 2]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 2]==2 && !(gameBoard.board[i][j + 1]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i + 1][j]==2 && !(gameBoard.board[i + 2][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i + 1][j]==2 && gameBoard.board[i + 2][j]==0 && !(gameBoard.board[i][j]==1)) {
                            gameBoard.board[i + 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i + 2][j]==2 && !(gameBoard.board[i + 1][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i + 1][j]==0 && !(gameBoard.board[i + 2][j]==1)) {
                            gameBoard.board[i + 1][j] = 2;
                            played++;
                        }
                    } else if (i == 1) {
                        if (gameBoard.board[i][j]==0 && gameBoard.board[i - 1][j]==2 && !(gameBoard.board[i + 1][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;

                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i + 1][j]==2 && !(gameBoard.board[i - 1][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        }
                    } else if (j == 1) {
                        if (gameBoard.board[i][j]==0 && gameBoard.board[i][j - 1]==2 && !(gameBoard.board[i][j + 1]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;

                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i][j + 1]==2 && !(gameBoard.board[i][j - 1]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        }
                    } else if (i == 2) {
                        if (gameBoard.board[i - 1][j]==2 && gameBoard.board[i - 2][j]==0 && !(gameBoard.board[i][j]==1)) {
                            gameBoard.board[i - 2][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==0 && gameBoard.board[i - 2][j]==2 && !(gameBoard.board[i - 1][j]==1)) {
                            gameBoard.board[i][j] = 2;
                            played++;
                        } else if (gameBoard.board[i][j]==2 && gameBoard.board[i - 1][j]==0 && !(gameBoard.board[i - 2][j]==1)) {
                            gameBoard.board[i - 1][j] = 2;
                            played++;
                        }
                    } else if (gameBoard.board[1][1]==1 && gameBoard.board[0][2]==0 && played == 0) {
                        gameBoard.board[0][2] = 2;
                        played++;
                    }

                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (played == 0 && gameBoard.board[i][j] == 0) {
                    gameBoard.board[i][j] = 2;
                    played++;
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
