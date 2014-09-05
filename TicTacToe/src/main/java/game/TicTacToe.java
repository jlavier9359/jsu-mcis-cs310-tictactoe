package game;

public class TicTacToe {
	public String[][] board;
	public String currentPlayer;
	public final int ROW = 3;
	public final int COL = 3;
	
	
	public TicTacToe() {
		board = new String[ROW][COL];
		currentPlayer = "X";
		startGame();
	}
	
	public void startGame() {
	    for(int row = 0; row < 3; row++) {
	        for(int col = 0; col < 3; col++) {
	          board[row][col] = "";
	        }
	     }
	}
	
	public String getLocation(int row, int col) {
		return (board[row][col]);
	}
	
	public void currentLocation(int row, int col) {
		if (board[row][col] == "") {
			board[row][col] = currentPlayer;
		}
	}
	 
	public boolean checkBoard(String one, String two, String three) {
		  	return ((one != "") && (one == two) && (two == three));
	}
	
	public boolean winDiagonally() {
		 return ((checkBoard(board[0][0], board[1][1], 
		 board[2][2]) == true) || (checkBoard(board[0][2], 
		 board[1][1], board[2][0]) == true));
	}
	
	public boolean winHorizontally() {
		for (int row = 0; row < 3; row++) {
			if (checkBoard(board[row][0], board[row][1], 
			board[row][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean winner() {
		return (winHorizontally() || winDiagonally());	    
	}

    public String getWinner() {
		if (winner() == true) 
		{
			changePlayer();
			return currentPlayer;
		}
		else {
			return "TIE";
		}
    }
	
	public void changePlayer() {
    	if (currentPlayer == "X") {
    		currentPlayer = "O";
    	}
    	else {
        	currentPlayer = "X";
    	}
    }
}