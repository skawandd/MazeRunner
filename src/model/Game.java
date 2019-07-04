package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import View.TextInterface;
import controller.CSVElement;
import controller.Controller;
import model.creatures.Creature;
import model.creatures.Human;
import model.creatures.Jumper;
import model.squares.Brick;
import model.squares.Floor;
import model.squares.Freezer;
import model.squares.Goal;
import model.squares.Hyper;
import model.squares.Ladder;

public class Game extends Observable implements Runnable {
	protected Square[][] board;
	private boolean loose;
	private int humanX, humanY, power, moves;
	private ArrayList<Creature> creatureList = new ArrayList<Creature>();
	private ArrayList<Hyper> hyperList = new ArrayList<Hyper>();
	
	public Game() {
	//	board = createMap(17, 20); TODO default map
		this.board = loadMap();
		initElements();
		loose = false;
		power = 2;
		generateApple();
	}

	public int start() {
		while (!loose) {
			new TextInterface(this).showBoard();
			new Controller(this).getKeyboard();
			// readMap();
			//setChanged();
			//notifyObservers(this);
		}
		System.out.println("GG");
		return 0;
	}

	public Square[][] loadMap() {
		try {
			CSVElement csvElement = new CSVElement(CSVElement.pick_CSVLevel());
			board = csvElement.getCsvGrid(); 
			return board; 
		} catch (Exception e) {
			return createMap(17, 20);
		}
	}

	public Square[][] createMap(int w, int h) {
		Square[][] board = new Square[w][h];
		
		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				if (y > 0 && y < board.length - 1 && x > 0 && x < board[0].length - 1)
					board[y][x] = new Floor();
				else
					board[y][x] = new Brick();
			}
		}

		// Human
		board[15][1].addCreature(new Human(15, 1));

		// Ladder
		board[3][4] = new Ladder();
		board[4][4] = new Ladder();
		board[5][4] = new Ladder();
		board[6][4] = new Ladder();
		board[7][4] = new Ladder();
		board[5][7] = new Ladder();
		board[6][7] = new Ladder();
		board[7][7] = new Ladder();
		board[5][17] = new Ladder();
		board[6][17] = new Ladder();
		board[7][17] = new Ladder();
		board[8][2] = new Ladder();
		board[9][2] = new Ladder();
		board[10][2] = new Ladder();
		board[11][6] = new Ladder();
		board[12][6] = new Ladder();
		board[13][6] = new Ladder();
		board[14][3] = new Ladder();
		board[15][3] = new Ladder();
		board[8][13] = new Ladder();
		board[9][13] = new Ladder();
		board[10][13] = new Ladder();
		board[11][13] = new Ladder();
		board[12][13] = new Ladder();
		board[13][13] = new Ladder();
		board[14][18] = new Ladder();
		board[15][18] = new Ladder();
		board[5][8] = new Ladder();
		board[6][8] = new Ladder();
		board[7][8] = new Ladder();

		// Goal

		board[2][8] = new Goal();

		// Brick

		board[3][1] = new Brick();
		board[3][2] = new Brick();
		board[3][3] = new Brick();
		board[3][5] = new Brick();
		board[3][6] = new Brick();
		board[3][7] = new Brick();
		board[3][8] = new Brick();
		board[5][7] = new Brick();
		board[5][11] = new Brick();
		board[5][12] = new Brick();
		board[5][13] = new Brick();
		board[5][14] = new Brick();
		board[5][15] = new Brick();
		board[5][16] = new Brick();
		board[5][18] = new Brick();
		board[6][7] = new Brick();
		board[7][7] = new Brick();
		board[8][1] = new Brick();
		board[8][3] = new Brick();
		board[8][4] = new Brick();
		board[8][7] = new Brick();
		board[8][8] = new Brick();
		board[8][9] = new Brick();
		board[8][10] = new Brick();
		board[8][11] = new Brick();
		board[8][12] = new Brick();
		board[8][14] = new Brick();
		board[8][15] = new Brick();
		board[8][16] = new Brick();
		board[8][17] = new Brick();
		board[8][18] = new Brick();
		board[11][1] = new Brick();
		board[11][2] = new Brick();
		board[11][3] = new Brick();
		board[11][4] = new Brick();
		board[11][5] = new Brick();
		board[11][7] = new Brick();
		board[11][8] = new Brick();
		board[11][9] = new Brick();
		board[11][10] = new Brick();
		board[11][11] = new Brick();
		board[11][12] = new Brick();
		board[14][4] = new Brick();
		board[14][5] = new Brick();
		board[14][6] = new Brick();
		board[14][13] = new Brick();
		board[14][14] = new Brick();
		board[14][15] = new Brick();
		board[14][16] = new Brick();
		board[14][17] = new Brick();

		board[15][5] = new Hyper(15, 5);
		board[7][1] = new Hyper(7, 1);
		board[4][18] = new Hyper(4, 18);
		board[15][10] = new Freezer();
		
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
		/*
		for (int i = 0; i < creatureList.size(); i++) {
			if(creatureList.get(i).isHuman())
				return creatureList.get(i).getY();
		}
		return -1;
		*/
	}

	public void setHumanY(int y) {
		this.humanY = y;
	}

	public int getHumanX() {
		return humanX;
		/*
		for (int i = 0; i < creatureList.size(); i++) {
			if(creatureList.get(i).isHuman())
				return creatureList.get(i).getX();
		}
		return -1;
		*/
	}

	public void setHumanX(int x) {
		this.humanX = x;
	}

	public void refreshHuman(int y, int x) {
		humanY = y;
		humanX = x;
	}

	public void incrtMoves() {
		++moves;
	}

	public int getMoves() {
		return moves;
	}
	
	public int getHyperSize() {
		return hyperList.size();
	}
	
	public Hyper getHyper(int id) {
		for(int i = 0; i < hyperList.size(); ++i) {
			if(hyperList.get(i).getHyperId() == id)
				return hyperList.get(i);
		}
		return null;
	}
	
	public Hyper getNextHyper(int id) {
		if(id < hyperList.size()-1 && id >= 0) {
			System.out.println(id + " L221"+getHyper(id+1) + getHyper(id+1).y +";"+getHyper(id+1).x);
			return getHyper(id+1);
		}
		return getHyper(0);
	}
	
	public void addHyper(Hyper h) {
		h.setHyperId(hyperList.size());
		hyperList.add(h);
	}

	public void powerUp() {
		++power;
	}

	public void powerDown() {
		if (power > 0)
			--power;
	}

	public int getPower() {
		return this.power;
	}

	public void generateApple() {
		Random r = new Random();
		int x, y;
		int i = 0;

		while (i < 3) {
			x = r.nextInt(board[0].length - 1);
			y = r.nextInt(board.length - 1);

			if (board[y][x].isFree() && !board[y][x].isLadder() && board[y + 1][x].isSupport()) {
				board[y][x].addApple();
				++i;
			}
		}
	}
	
	public void move(Creature c, int toY, int toX) {
		if(board[toY][toX].isFree()) {
			board[c.getY()][c.getX()].removeCreature(c);
			c.setY(toY);
			c.setX(toX);
			board[c.getY()][c.getX()].addCreature(c);
			
			if (board[c.getY()][c.getX()].getHuman() != null)
				refreshHuman(c.getY(), c.getX());
		}
		checkAll(board[c.getY()][c.getX()]);
		setChanged(); 
		notifyObservers();
	}

	public void dig(int y , int x) {
		board[y][x].addDig();
		powerDown(); 
		setChanged(); 
		notifyObservers(); 
	}
	
	public void RandomTeleport(Creature c) {
		Random r = new Random();
		int x, y;
		boolean flag = false;
		System.out.println("TELEPORT");
		while (!flag) {
			x = r.nextInt(board[0].length - 1);
			y = r.nextInt(board.length - 1);

			if (board[y][x].isFree() && !board[y][x].isLadder() && board[y + 1][x].isSupport()) {
				move(c, y, x);
				flag = true;
			}
		}

		if (board[c.getY()][c.getX()].getHuman() != null)
			refreshHuman(c.getY(), c.getX());
	}
	
	public void hyperTeleport(Creature c) {
		Hyper nextHyper;
		if(board[c.getY()][c.getX()].isHyper()) {
			nextHyper = getNextHyper(hyperList.indexOf((Hyper)board[c.getY()][c.getX()]));
			if(!c.isTeleported()) {
				c.setTeleported(true);
				move(c, nextHyper.getY(), nextHyper.getX());
			}
		}	
	}
	
	public void teleportStatus(Creature c) {
		if(!board[c.getY()][c.getX()].isHyper())
			c.setTeleported(false);
	}

	public void applyGravity(Creature c) {
		while (!board[c.getY() + 1][c.getX()].isSupport() && !board[c.getY()][c.getX()].isLadder()
				&& c.getY() + 2 < board.length)
			move(c, c.getY()+1, c.getX());
	}
	
	public void initElements() {
		for (int y = board.length-1; y > 0 ; --y) {
			for (int x = board[0].length-1; x > 0; --x) {
				if(board[y][x].isHyper())
					addHyper((Hyper)board[y][x]);
				if(board[y][x].getHuman() != null) {
					setHumanY(y);
					setHumanX(x);
				}
				if(board[y][x].getHuman() != null) {
					setHumanY(y);
					setHumanX(x);
				}
				if(board[y][x].getJumper()!= null) {
					 Thread thread  = new Thread((Jumper)board[y][x].getJumper()); 
					 thread.start();
					 
				}
		
			}
		}
	}

	public void checkAll(Square s) {
		if (s.getApple()) {
			powerUp();
			s.removeApple();
		}
		Creature c = null;
		if(s.getHuman() != null)
			c = s.getHuman();
		else if(s.getJumper() != null) {
			System.out.println("JUMPER");
			c = s.getJumper();
				}
		else if(s.getPacer() != null)
			c = s.getPacer();
		else if(s.getRover() != null)
			c = s.getRover();
		if (s.isHyper())
			hyperTeleport(c);
		teleportStatus(c);
		applyGravity(c);
	}
	
	@Override
	public void run() {
		start();
	}

}
