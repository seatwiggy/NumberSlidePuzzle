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
        gameBoard.setSize(3);
        playerWins = false;
        tie = false;
        setUpBoard();
    }

    /**
     * passes the information from the ui to the Tic Tac Toe game board
     *
     * @param a spot [0,0] in the matrix
     * @param b spot [0,1] in the matrix
     * @param c spot [0,2] in the matrix
     * @param d spot [1,0] in the matrix
     * @param e spot [1,1] in the matrix
     * @param f spot [1,2] in the matrix
     * @param g spot [2,0] in the matrix
     * @param h spot [2,1] in the matrix
     * @param k spot [2,2] in the matrix
     */
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

    @Override
    public boolean checkForWin() {
        int player = 0;
        int bot = 0;
        for (int row = 0; row < gameBoard.getSize(); row++) {
            for (int col = 0; col < gameBoard.getSize(); col++) {
                if (gameBoard.board[row][col] == 1) {
                    player++;
                    bot = 0;
                } else {
                    bot++;
                    player = 0;
                }
            }
            if (player == 3) {
                playerWins = true;
                return true;
            } else if (bot == 3) {
                playerWins = false;
                return true;
            }
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

    public void getBoard(){
        gameBoard.getBoard();
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
