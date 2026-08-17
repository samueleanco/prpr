package tictactoe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    void firstToPlayIsX() {
        TicTacToe game = new TicTacToe();
        assertEquals(Player.X, game.getCurrentPlayer());
    }
}
