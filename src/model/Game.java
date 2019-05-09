package model;

import Controller.Controller;
import model.creatures.Human;
import model.squares.Floor;
import model.squares.Brick;

public class Game {
	private Square[][] board;

	public Game() {
		this.board = createMap();
	}

	public int start() {
		this.board[0][0] = new Floor();
		this.board[0][0] = new Human(board[0][0]);
		// System.out.println((board[0][0].isAlive()));
		// System.out.println(new Controller().getKeyboard());
		return 0;
	}

	public Square[][] createMap() {

		// building walls
		board = new Square[10][10];
		for (int x = 0; x < board[0].length; x++) {
			for (int y = 0; y < board[1].length; y++) {
				board[x][y] = new Floor();
			}
		}
		for (int i = 0; i < 9; i++) {
			board[0][i] = new Brick();
			board[i][0] = new Brick();
			board[9][i] = new Brick();
			board[i][9] = new Brick();
		}
		return board;

	}
}
