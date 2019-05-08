package model;

import Controller.Controller;
import model.creatures.Human;

public class Game {
	private Element[][] board;
	
	public Game() {
		this.board = new Element[10][10];
	}
	
	public int start() {
		this.board[0][0] = Square.Floor;
		this.board[0][1] = new Human();
		System.out.println(new Controller().getKeyboard());
		return 0;
	}
}
