package model;

import Controller.Controller;
import View.UserInterface;
import model.creatures.Human;
import model.creatures.Jumper;
import model.creatures.Pacer;
import model.creatures.Rover;
import model.squares.Brick;
import model.squares.Empty;
import model.squares.Floor;
import model.squares.Freezer;
import model.squares.Goal;
import model.squares.Hyper;
import model.squares.Ladder;

public class Game {
	private Square[][] board;
	private boolean loose;

	public Game() {
		this.board = createMap(10, 30);
		this.loose = false;
	}

	public int start() {
		while(!loose) {
			new UserInterface(this).showMap();
			System.out.println(new Controller().getKeyboard());
		}
		return 0;
	}
	
	public Square[][] createMap(int w, int h) {
		Square[][] board = new Square[w][h];
		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				if(y > 0 && y < board.length -1 && x > 0 && x < board[0].length -1)
					board[y][x] = new Floor();
				else
					board[y][x] = new Brick();
			}
		}
		
		board[1][2] = new Human(board[1][2]);
		board[3][2] = new Brick();
		board[4][2] = new Brick();
		board[5][2] = new Brick();
		board[6][2] = new Brick();

		board[1][1] = new Ladder();
		board[8][28] = new Goal();
		
		board[3][26] = new Rover(board[3][26]);
		board[4][26] = new Pacer(board[4][26]);
		board[5][26] = new Jumper(board[5][26]);
		
		return board;
	}
	public Square[][] getBoard() {
		return this.board;
	}

}
