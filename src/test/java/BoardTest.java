import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardInitialization() {
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j]);
            }
        }
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace() {
        board.place(1, 1, 'O');
        assertEquals('O', board.getCells()[1][1]);
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testClear() {
        board.place(0, 0, 'X');
        board.clear();
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j]);
            }
        }
    }
}
