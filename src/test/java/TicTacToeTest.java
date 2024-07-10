import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
    }

    @Test
    public void testSwitchCurrentPlayer() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testHasWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(game.hasWinner());

        board.clear();
        board.place(0, 0, 'O');
        board.place(1, 1, 'O');
        board.place(2, 2, 'O');
        assertTrue(game.hasWinner());

        board.clear();
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'O');
        assertFalse(game.hasWinner());
    }

    @Test
    public void testStartNewGame() {
        // To simulate user input, you may need a mocking framework like Mockito
    }
}
