import game.*; 

public class TicTacToeKeywords {
	private TicTacToe game;
	
	public void startNewGame() {
		game = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		game.currentLocation(row,col);
		game.changePlayer();
	}
	
	public void checkLocation(int row, int col, String mark) {
		String location = getLocation(row,col);
	}
	
	public String getLocation(int row, int col) {
		return game.getLocation(row,col);
	}
	
	public void winnerShouldBe(String winner)	{
		String result = getWinner();
	}
	
	public String getWinner() {
		if (game.winner() == true) 
		{
			game.changePlayer();
			return game.currentPlayer;
		}
		else{
			return "TIE";
		}
	}
}