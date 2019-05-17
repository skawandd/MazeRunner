package View;

import model.Game;
import model.Square;

public class UserInterface {
	private Game game;
	
	public UserInterface(Game game) {
		this.game = game;
	}
	
	public void showBoard() {
		Square[][] board = game.getBoard();
		
		System.out.println(" ====================== MAZE RUNNER ====================== ");
		
		for(int y = 0; y < board.length; ++y) {
			for(int x = 0; x < board[0].length; ++x) {
				
				System.out.print(getSquareStyle(board[y][x]) + " ");
			}
			System.out.println("");
		}
	}
	
	public String getSquareStyle(Square s) {
		if(s.getApple())
			return "*";
		else if(s.getDig())
			return "¤";
		
		switch (s.getId()) {
		case 0:
			return "X";
		case 1:
			return ".";
		case 2:
			return "#";
		case 3:
			return "Y";
		case 4:
			return "F";
		case 5:
			return"H";
		case 6:
			return "G";
		case 7:
			return "&";
		case 8:
			return "J";
		case 9:
			return "P";
		case 10:
			return "R";
		default:
			return " ";
		}

	}

}
