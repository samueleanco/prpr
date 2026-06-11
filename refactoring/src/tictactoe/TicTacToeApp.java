package tictactoe;

import ch.trick17.gui.Color;
import ch.trick17.gui.Gui;


public class TicTacToeApp {

    private static final int FIELD_SIZE = 150;
    private static final int MARGIN = 10;
    private static final int PADDING = 20;
    private static final int BOARD_SIZE = 3 * FIELD_SIZE + 4 * MARGIN;
    private static final Color GAME_OVER_COLOR = new Color(200, 200, 200);

    public static void main(String[] args) {
        new TicTacToeApp().start();
    }

    private final Gui gui = Gui.create("Tic Tac Toe", BOARD_SIZE, BOARD_SIZE);
    private int[][] board;
    private int moves;

    private void start() {
        board = new int[3][3];
        moves = 0;

        drawBoard();
        gui.open();

        while (gui.isOpen()) {
            if (gui.wasLeftMouseButtonClicked()) {
                int row = (int) (gui.getMouseY() - MARGIN / 2) / (FIELD_SIZE + MARGIN);
                int col = (int) (gui.getMouseX() - MARGIN / 2) / (FIELD_SIZE + MARGIN);
                if (board[row][col] == 0) {
                    board[row][col] = moves % 2 + 1;
                    moves++;
                }
            }

            if (getWinner() != 0 || moves == 9) {
                do {
                    drawBoard();
                    gui.refreshAndClear(20);
                } while (gui.isOpen() && !gui.wasLeftMouseButtonClicked());

                // start new game
                board = new int[3][3];
                moves = 0;
            }

            drawBoard();
            gui.refreshAndClear(20);
        }
    }

    private int getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 &&
                board[i][0] == board[i][1] &&
                board[i][0] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != 0 &&
                board[0][i] == board[1][i] &&
                board[0][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != 0 &&
            board[0][0] == board[1][1] &&
            board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != 0 &&
            board[0][2] == board[1][1] &&
            board[0][2] == board[2][0]) {
            return board[0][2];
        }
        return 0;
    }

    private void drawBoard() {
        gui.setColor(220, 220, 220);
        gui.fillRect(0, 0, BOARD_SIZE, BOARD_SIZE);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                var x = col * FIELD_SIZE + (col + 1) * MARGIN;
                var y = row * FIELD_SIZE + (row + 1) * MARGIN;
                gui.setColor(255, 255, 255);
                gui.fillRect(x, y, FIELD_SIZE, FIELD_SIZE);

                gui.setStrokeWidth(20);
                if (board[row][col] == 1) {
                    gui.setColor(getXColor());
                    gui.drawLine(
                            x + PADDING, y + PADDING,
                            x + FIELD_SIZE - PADDING, y + FIELD_SIZE - PADDING);
                    gui.drawLine(
                            x + FIELD_SIZE - PADDING, y + PADDING,
                            x + PADDING, y + FIELD_SIZE - PADDING);
                } else if (board[row][col] == 2) {
                    gui.setColor(getOColor());
                    gui.drawOval(x + PADDING, y + PADDING,
                            FIELD_SIZE - 2 * PADDING, FIELD_SIZE - 2 * PADDING);
                }
            }
        }
    }

    private Color getXColor() {
        if (getWinner() == 2 || moves == 9 && getWinner() != 1) {
            return GAME_OVER_COLOR;
        } else {
            return new Color(200, 50, 50);
        }
    }

    private Color getOColor() {
        if (getWinner() == 1 || moves == 9 && getWinner() != 2) {
            return GAME_OVER_COLOR;
        } else {
            return new Color(40, 40, 220);
        }
    }
}
