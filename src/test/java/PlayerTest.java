import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @org.junit.Test
    @Test
    public void testPlayerInitialization() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @org.junit.Test
    @Test
    public void testGetMarker() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }
}
