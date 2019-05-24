package model;

import Controller.Controller;
import View.UserInterface;
import model.creatures.Human;
import model.squares.Brick;
import model.squares.Floor;
import model.squares.Goal;
import model.squares.Ladder;

public class Game {
	protected Square[][] board;
	private boolean loose;
	private int humanX, humanY, power;

	public Game() {
		this.board = createMap(17, 20);
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
		// Fair les apple 
		
		// Human 
	//	board[15][1] = new Human(15, 1, board[15][1]);
		board[15][1].addCreature(new Human(15, 1));
				
		// Ladder 
		board[3][4]= new Ladder();
		board[4][4]= new Ladder();
		board[5][4]= new Ladder();
		board[6][4]= new Ladder();
		board[7][4]= new Ladder();
		board[5][7]= new Ladder();
		board[6][7]= new Ladder();
		board[7][7]= new Ladder();
		board[5][17]= new Ladder();
		board[6][17]= new Ladder();
		board[7][17]= new Ladder();
		board[8][2]= new Ladder();
		board[9][2]= new Ladder();
		board[10][2]= new Ladder();
		board[11][6]= new Ladder();
		board[12][6]= new Ladder();
		board[13][6]= new Ladder();
		board[14][3]= new Ladder();
		board[15][3]= new Ladder();
		board[8][13]= new Ladder();
		board[9][13]= new Ladder();
		board[10][13]= new Ladder();
		board[11][13]= new Ladder();
		board[12][13]= new Ladder();
		board[13][13]= new Ladder();
		board[14][18]= new Ladder();
		board[15][18]= new Ladder();
		board[5][8]= new Ladder();
		board[6][8]= new Ladder();
		board[7][8]= new Ladder();
		
		
		// Goal 
		
		board[2][8]= new Goal();
		
		// Brick 
		
		board[3][1]= new Brick();
		board[3][2]= new Brick();
		board[3][3]= new Brick();
		board[3][5]= new Brick();
		board[3][6]= new Brick();
		board[3][7]= new Brick();
		board[3][8]= new Brick();
		board[5][7]= new Brick();
		board[5][11]= new Brick();
		board[5][12]= new Brick();
		board[5][13]= new Brick();
		board[5][14]= new Brick();
		board[5][15]= new Brick();
		board[5][16]= new Brick();
		board[5][18]= new Brick();
		board[6][7]= new Brick();
		board[7][7]= new Brick();
		board[8][1]= new Brick();
		board[8][3]= new Brick();
		board[8][4]= new Brick();
		board[8][7]= new Brick();
		board[8][8]= new Brick();
		board[8][9]= new Brick();
		board[8][10]= new Brick();
		board[8][11]= new Brick();
		board[8][12]= new Brick();
		board[8][14]= new Brick();
		board[8][15]= new Brick();
		board[8][16]= new Brick();
		board[8][17]= new Brick();
		board[8][18]= new Brick();
		board[11][1]= new Brick();
		board[11][2]= new Brick();
		board[11][3]= new Brick();
		board[11][4]= new Brick();
		board[11][5]= new Brick();
		board[11][7]= new Brick();
		board[11][8]= new Brick();
		board[11][9]= new Brick();
		board[11][10]= new Brick();
		board[11][11]= new Brick();
		board[11][12]= new Brick();
		board[14][4]= new Brick();
		board[14][5]= new Brick();
		board[14][6]= new Brick();
		board[14][13]= new Brick();
		board[14][14]= new Brick();
		board[14][15]= new Brick();
		board[14][16]= new Brick();
		board[14][17]= new Brick();
				
		return board;
	}
	
	public void readMap() {
		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
			
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
		
		while(!board[c.getY()+1][c.getX()].isSupport() && !board[c.getY()][c.getX()].isLadder() && c.getY() + 2 < board.length) {
			board[c.getY()][c.getX()].removeCreature(c);
			c.setY(c.getY() + 1);
			board[c.getY()][c.getX()].addCreature(c);
			
			if(board[c.getY()][c.getX()].getHuman() != null) {
				humanX = c.getX();
				humanY = c.getY();
			}
			
		}
		
	}

}
