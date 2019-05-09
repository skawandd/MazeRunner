package model;

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
		// building board floor
		board = new Square[10][10];
		for (int x = 0; x < board[0].length; x++) {
			for (int y = 0; y < board[1].length; y++) {
				board[x][y] = new Floor();
			}
		}
		// building walls
		for (int i = 0; i < 9; i++) {
			board[0][i] = new Brick();
			board[i][0] = new Brick();
			board[9][i] = new Brick();
			board[i][9] = new Brick();
		}
		// Adding some freezers
		board[3][4] = new Freezer();
		board[4][4] = new Freezer();
		board[5][4] = new Freezer();
		// Adding creatures
		board[2][5] = new Human(board[2][5]);
		board[6][6] = new Rover(board[6][6]);
		board[7][7] = new Pacer(board[7][7]);
		board[8][8] = new Jumper(board[8][8]);
		// adding apples
		board[9][8].addApple();
		// Adding ladder
		board[7][3] = new Ladder();
		// Adding Hyper
		board[7][4] = new Hyper();
		//Adding goal 
		board[7][5] = new Goal();
		//Adding Empty
		board[7][6] = new Empty();
		
		return board;

	}
}
