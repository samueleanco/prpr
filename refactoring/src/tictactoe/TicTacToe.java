package tictactoe;



public class TicTacToe {
    private int[][] board;
    private int moves;

    public TicTacToe() {
        board = new int[3][3];
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
}
