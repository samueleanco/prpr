package tictactoe;



public class TicTacToe {
    private Player[][] board;
    private int moves;

    public TicTacToe() {
        board = new Player[3][3];
        moves = 0;
    }

    public Player getCurrentPlayer() {
        if (isOver()) {
            throw new IllegalStateException();
        }
        if (moves % 2 == 0) return Player.X;
        else {
            return Player.O;
        }
    }

    public boolean isOver() {
        return false;
    }
    public void play(int row, int col) {
        if (isOver()) throw new IllegalStateException();
        else if (row < 0 || row > 2 || col < 0 || col > 2) throw new IllegalArgumentException();

        if (board[row][col] == null) {
            board[row][col] = getCurrentPlayer();
            moves++;
        }
    }
    public Player getField(int row, int col) {
        return board[row][col];
    }

    public Player getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null &&
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != null &&
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != null &&
                board[0][0] == board[1][1] &&
                board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != null &&
                board[0][2] == board[1][1] &&
                board[0][2] == board[2][0]) {
            return board[0][2];
        }
        return null;
    }
}
