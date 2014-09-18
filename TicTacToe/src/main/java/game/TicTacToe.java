package game;

import java.util.Scanner;

public final class TicTacToe {
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
	          board[row][col] = " ";
	        }
	     }
	}
	
	public String checkLocation(int row, int col) {
	
		if(board[row][col]== "X"){
			return "X";
		}
		else if (board[row][col] =="O"){
			return "O";
		}
		else {
			return " ";
		}
	}
	
	public boolean checkBoard(String one, String two, String three) { 
	
		 return((one != " ") && (one == two) && (two == three));
	}
	
	public void markLocation(int row, int col) {

    if (" ".equals(board[row][col])) {
        board[row][col] = currentPlayer;           
       } 
    }

    public String getWinner() {
	
		if (checkRows() || checkColumns() || checkDiagonals()
			== true) 
		{
			return currentPlayer;
		}
		else {
			return "TIE"; 
		}
    }
	
	public void changePlayer() {
    	if ("X".equals(currentPlayer)) {
    		currentPlayer = "O";
    	}
    	else {
        	currentPlayer = "X";
    	}
    }
	
    public void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
	

	// These last 3 methods are good to go!
    public boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkBoard(board[i][0], board[i][1], board[i][1]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkBoard(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        if ((checkBoard(board[0][0], board[1][1], board[2][2])) || 
		(checkBoard(board[0][2], board[1][1], board[2][0]))){
			return true;
		}
		else{
			return false;
		}
    }

    
    // Game works great in command prompt 
    // but does not have any GUI 
    
    public static void main (String[] args){
		TicTacToe game = new TicTacToe();
        Scanner first = new Scanner(System.in);
        Scanner second = new Scanner(System.in);
		
        for(int i = 0;i < 8;i++){
             System.out.println("Player " + 
                     game.currentPlayer + " mark your location");
					 
             int row = first.nextInt();
             int col = second.nextInt();
             game.markLocation(row,col);
             game.printBoard(); 
             
             if (game.checkColumns() || game.checkRows() 
                     || game.checkDiagonals() == true){
                 break;
             }
             game.changePlayer();
        }
		if(game.getWinner().equals("X") || game.getWinner().equals("O")){
            System.out.println("Player " + game.getWinner()+ " won!");
        }
        else{
            System.out.println("It's a " + game.getWinner());
        }
    }
}