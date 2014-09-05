package game;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	TicTacToe game = new TicTacToe();
	
    @Test
    public void testWinDiagonallyAsX() {
		game.currentLocation(1,1);
		game.getLocation(1,1);
		game.getWinner();
    }
    
    @Test
    public void testWinHorizontallyAsO() {
		game.currentLocation(1,1);
		game.getLocation(1,1);
		game.changePlayer();
		game.currentLocation(2,0);
		game.getLocation(2,0);
		game.changePlayer();
		game.getWinner();
    }
	
	@Test
	public void testForceATie() {
		assertEquals("TIE",game.getWinner());
	}
}