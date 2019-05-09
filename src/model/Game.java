package model;

import View.UserInterface;
import model.creatures.Human;
import model.squares.Floor;

public class Game {
	private Square[][] board;
	private boolean loose;
	
	public Game() {
		this.board = test();
		this.loose = false;
	}
	
	public int start() {
		this.board[1][1] = new Human(board[1][1]);
	//	System.out.println((board[0][0].isAlive()));
	//	System.out.println(new Controller().getKeyboard());
		new UserInterface(this).showMap();
		return 0;
	}
	
	public Square[][] getBoard() {
		return this.board;
	}
	
	public Square[][] test() {
		Square[][] board = new Square[10][10];
		for(int x = 0; x < board[0].length; ++x) {
			for(int y = 0; y < board[0].length; ++y) {
				board[x][y] = new Floor();
			}
		}
		return board;
	}
	

}
