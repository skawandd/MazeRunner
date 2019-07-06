package View;

import model.Game;
import model.Square;

public class TextInterface {
	private Game game;
	
	public TextInterface(Game game) {
		this.game = game;
	}
	
	public static void showBoard() {
		Square[][] board = GraphicInterface.getGame().getBoard();
		
		System.out.println(" ============ MAZE RUNNER ============ ");
		
		for(int y = 0; y < board.length; ++y) {
			for(int x = 0; x < board[0].length; ++x) {
				
				System.out.print(getSquareStyle(board[y][x]) + " ");
			}
			System.out.println("");
		}
	}
	
	public static String getSquareStyle(Square s) {
		if(s.getHuman() != null)
			return "&";
		else if(s.getApple())
			return "*";
		else if(s.getDig())
			return "¤";
		
		switch (s.getId()) {
		case 0:
			return ".";
		case 1:
			return "#";
		case 2:
			return "Y";
		case 3:
			return "F";
		case 4:
			return"H";
		case 5:
			return "G";
		case 6:
			return "&";
		case 7:
			return "J";
		case 8:
			return "P";
		case 9:
			return "R";
		default:
			return " ";
		}

	}

}
