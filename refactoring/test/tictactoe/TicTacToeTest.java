package tictactoe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    void firstToPlayIsX() {
        TicTacToe game = new TicTacToe();
        assertEquals(Player.X, game.getCurrentPlayer());
    }
    @Test
    void currentPlayerAlternatesAfterEachMove() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); // X
        assertEquals(Player.O, game.getCurrentPlayer());
        game.play(1, 1); // O
        assertEquals(Player.X, game.getCurrentPlayer());
    }

    @Test
    void playThrowsForOutOfBoundsCoordinates() {
        TicTacToe game = new TicTacToe();
        assertThrows(IllegalArgumentException.class, () -> game.play(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> game.play(3, 0));
        assertThrows(IllegalArgumentException.class, () -> game.play(0, -1));
        assertThrows(IllegalArgumentException.class, () -> game.play(0, 3));
    }

    @Test
    void playOnOccupiedFieldIsIgnored() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0);
        game.play(0, 0);
        assertEquals(Player.X, game.getField(0, 0));
        assertEquals(Player.O, game.getCurrentPlayer());
    }

    @Test
    void getFieldReflectsBoardState() {
        TicTacToe game = new TicTacToe();
        assertNull(game.getField(1, 2)); // leer
        game.play(1, 2);
        assertEquals(Player.X, game.getField(1, 2));
    }

    @Test
    void noWinnerAndNotOverAtStart() {
        TicTacToe game = new TicTacToe();
        assertNull(game.getWinner());
        assertFalse(game.isOver());
    }

    @Test
    void gameOverThrowsOnPlayAndGetCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); // X
        game.play(1, 0); // O
        game.play(0, 1); // X
        game.play(1, 1); // O
        game.play(0, 2); // X gewinnt Zeile 0
        assertTrue(game.isOver());
        assertThrows(IllegalStateException.class, () -> game.play(2, 2));
        assertThrows(IllegalStateException.class, game::getCurrentPlayer);
    }

    @Test
    void gameEndsInDrawWithNoWinner() {
        TicTacToe game = new TicTacToe();
        // X O X
        // X O O
        // O X X
        game.play(0, 0); game.play(0, 1); game.play(0, 2);
        game.play(1, 1); game.play(1, 0); game.play(1, 2);
        game.play(2, 1); game.play(2, 0); game.play(2, 2);
        assertTrue(game.isOver());
        assertNull(game.getWinner());
    }


    @Test
    void winRow0() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); game.play(1, 0);
        game.play(0, 1); game.play(1, 1);
        game.play(0, 2);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void winRow1() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); game.play(1, 0);
        game.play(0, 1); game.play(1, 1);
        game.play(2, 2); game.play(1, 2);
        assertEquals(Player.O, game.getWinner());
    }

    @Test
    void winRow2() {
        TicTacToe game = new TicTacToe();
        game.play(2, 0); game.play(0, 0);
        game.play(2, 1); game.play(0, 1);
        game.play(2, 2);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void winCol0() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); game.play(0, 1);
        game.play(1, 0); game.play(1, 1);
        game.play(2, 0);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void winCol1() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); game.play(0, 1);
        game.play(1, 0); game.play(1, 1);
        game.play(2, 2); game.play(2, 1);
        assertEquals(Player.O, game.getWinner());
    }

    @Test
    void winCol2() {
        TicTacToe game = new TicTacToe();
        game.play(0, 2); game.play(0, 0);
        game.play(1, 2); game.play(0, 1);
        game.play(2, 2);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void winMainDiagonal() {
        TicTacToe game = new TicTacToe();
        game.play(0, 0); game.play(0, 1);
        game.play(1, 1); game.play(0, 2);
        game.play(2, 2);
        assertEquals(Player.X, game.getWinner());
    }

    @Test
    void winAntiDiagonal() {
        TicTacToe game = new TicTacToe();
        game.play(0, 2); game.play(0, 0);
        game.play(1, 1); game.play(0, 1);
        game.play(2, 0);
        assertEquals(Player.X, game.getWinner());
    }
}
