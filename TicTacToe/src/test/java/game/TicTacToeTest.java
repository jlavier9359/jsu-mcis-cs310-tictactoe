package game;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
    @Test
    public void winDiagonallyAsX() {
		TicTacToe game = new TicTacToe(); 
		game.markLocation(1,1);
		// check if "X" is being marked
		assertEquals("X",game.checkLocation(1,1)); 
		game.changePlayer();
		game.markLocation(0,1);
		// check if "O" is being marked
		assertEquals("O",game.checkLocation(0,1));  
		game.changePlayer();
		game.markLocation(0,0);
		game.checkLocation(0,0);
		game.changePlayer();
		game.markLocation(0,2);
		game.checkLocation(0,2);
		game.changePlayer();
		game.markLocation(2,2);
		game.checkLocation(2,2);
		assertTrue(game.checkDiagonals()); // check if "X" has won diagonally
		assertEquals("X",game.getWinner()); // "X" wins
    }
    
    @Test
    public void winHorizontallyAsO() {
		TicTacToe game = new TicTacToe(); 
		game.markLocation(1,1);
		assertEquals("X",game.checkLocation(1,1)); 
		game.changePlayer();
		game.markLocation(2,0);
		assertEquals("O",game.checkLocation(2,0)); 
		game.changePlayer();
		game.markLocation(0,0);
		game.checkLocation(0,0);
		game.changePlayer();
		game.markLocation(2,2);
		game.checkLocation(2,2);
		game.changePlayer();
		game.markLocation(0,2);
		game.checkLocation(0,2);
		game.changePlayer();
		game.markLocation(2,1);
		game.checkLocation(2,1);
		assertTrue(game.checkRows()); // check if "O" has won horizontally
		assertEquals("O",game.getWinner()); // "O" wins

    }
	
	@Test
	public void forceATie() {
		TicTacToe game = new TicTacToe(); 
		game.markLocation(1,1);
		assertEquals("X",game.checkLocation(1,1)); 
		game.changePlayer();
		game.markLocation(0,0);
		assertEquals("O",game.checkLocation(0,0)); 
		game.changePlayer();
		game.markLocation(2,0);
		game.checkLocation(2,0);
		game.changePlayer();
		game.markLocation(0,2);
		game.checkLocation(0,2);
		game.changePlayer();
		game.markLocation(0,1);
		game.checkLocation(0,1);
		game.changePlayer();
		game.markLocation(2,1);
		game.checkLocation(2,1);
		game.changePlayer();
		game.markLocation(1,2);
		game.checkLocation(1,2);
		game.changePlayer();
		game.markLocation(1,0);
		game.checkLocation(1,0);
		game.changePlayer();
		game.markLocation(2,2);
		game.checkLocation(2,2);
		
		// Checks to see if their is no winner 
		assertFalse(game.checkRows()); 
		assertFalse(game.checkColumns());
		assertFalse(game.checkDiagonals());
		assertEquals("TIE",game.getWinner()); // It's a "TIE"

	}
}