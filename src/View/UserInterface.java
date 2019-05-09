package View;

import model.Game;
import model.Square;

public class UserInterface {
	private Game game;
	
	public UserInterface(Game game) {
		this.game = game;
	}
	
	public void showMap() {
		Square[][] board = game.getBoard();
		
		for(int x = 0; x < board[0].length; ++x) {
			for(int y = 0; y < board[1].length; ++y) {
				
				System.out.print(getSquareStyle(board[x][y]) + " ");
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
			return "+";
		case 4:
			return "-";
		case 5:
			return "L";
		case 6:
			return "@";
		case 7:
			return "H";
		case 8:
			return "J";
		case 9:
			return "P";
		case 10:
			return "5";
		default:
			return " ";
		}

	}

}
