package model;

import Controller.Controller;
import View.UserInterface;
import model.creatures.Human;
import model.creatures.Jumper;
import model.creatures.Monster;
import model.creatures.Pacer;
import model.creatures.Rover;
import model.squares.Brick;
import model.squares.Floor;
import model.squares.Goal;
import model.squares.Ladder;

public class Game {
	protected Square[][] board;
	private boolean loose;
	private int humanX, humanY, power;

	public Game() {
		this.board = createMap(10, 30);
		this.loose = false;
		this.setHumanX(2);
		this.setHumanY(1);
		this.power = 0;
	}

	public int start() {
		while(!loose) {
			new UserInterface(this).showBoard();
			new Controller(this).getKeyboard();
			
		}
		System.out.println("GG");
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
	
	public void readMap() {
		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				if(board[y][x].isMonster())
					((Monster)board[y][x]).move();
			}
		}
	}
	
	public Square[][] getBoard() {
		return this.board;
	}

	public int getHumanY() {
		return humanY;
	}

	public void setHumanY(int humanY) {
		this.humanY = humanY;
	}

	public int getHumanX() {
		return humanX;
	}

	public void setHumanX(int humanX) {
		this.humanX = humanX;
	}
	
	public void powerUp() {
		++power;
	}
	
	public void powerDown() {
		if(power > 0)
			--power;
	}

}
