package model;

import Controller.Controller;
import model.creatures.Human;
import model.squares.Floor;

public class Game {
	private Square[][] board;
	
	public Game() {
		this.board = testMap();
	}
	
	public int start() {
		/*
		board[0][0] = new Floor();
		this.board[0][0] = new Human(board[0][0]);
		System.out.println((board[0][0].isAlive()));
		*/
		System.out.println(new Controller().getKeyboard());
		return 0;
	}
	
	public Square[][] testMap() {
		return null;
	}
}
