package model;

import java.io.FileNotFoundException;

import Controller.CSVElement;
import Controller.Controller;
import View.UserInterface;
import model.squares.Brick;
import model.squares.Floor;

public class Game {
	protected Square[][] board;
	private boolean loose;
	private int humanX, humanY, power;

	public Game() throws FileNotFoundException {
		this.board = loadMap();
		this.loose = false;
		this.setHumanX(1);
		this.setHumanY(15);
		this.power = 2;
	}

	public int start() {
		while(!loose) {
			new UserInterface(this).showBoard();
			new Controller(this).getKeyboard();
			//readMap();
			
		}
		System.out.println("GG");
		return 0;
	}
	public Square[][] loadMap() throws FileNotFoundException {
		CSVElement csvElement = new CSVElement(CSVElement.pick_CSVLevel()); 
		board = csvElement.getCsvGrid(); 
		for (int i=0;i<board.length;i++) {
			for(int j = 0 ; j<board[0].length; j++) {
				System.out.print(board[i][j].id);
			}
			System.out.println("\n");
		}
		return board; 
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
	 return board ; 
	}
	
	public void readMap() {
		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
			//	if(board[y][x].isMonster())
				//	((Monster)board[y][x]).move();
				if(board[y][x].isCreature())
					applyGravity((Creature)board[y][x]);
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
	
	public int getPower() {
		return this.power;
	}
	
	public void applyGravity(Creature c) {
		
		while(!board[c.y+1][c.x].isSupport() && !c.getSquare().isLadder() && c.y + 2 < board.length) {
			board[c.getY()][c.getX()] = c.getSquare();
			c.setCurrentSquare(board[c.getY() + 1][c.getX()].getSquare());
			c.setY(c.getY() + 1);
			board[c.getY()][c.getX()] = c;
			
			if(board[c.getY()][c.getX()].getId() == 7) {
				humanX = c.getX();
				humanY = c.getY();
			}
			
		}
	}

}
