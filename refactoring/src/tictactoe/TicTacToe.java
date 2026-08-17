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
}
