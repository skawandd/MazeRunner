package model.creatures;

import java.util.Random;

import View.GraphicInterface;
import model.Game;
import model.Square;

public abstract class Creature {
	private int id;
	protected int y, x;
	private boolean teleported, freezed;
	protected boolean alive;
	
	public Creature(int id, int y, int x) { 
		this.id = id;
		this.x = x;
		this.y = y;
		teleported = false;
		freezed = false;
		alive = true;
	}
	
	public abstract void move();
	
	public int getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isTeleported() {
		return teleported;
	}
	
	public void setTeleported(boolean teleported) {
		this.teleported = teleported;
	}
	
	public boolean isFreezed() {
		return freezed;	
	}
	
	public void setFreezed(boolean freezed) {
		this.freezed = freezed;	
	}
	
	public boolean isHuman() {
		if(id == 6)
			return true;
		return false;
	}
	public boolean isJumper() {
		if(id == 7)
			return true;
		return false;
	}
	public boolean isRover() {
		if(id == 9)
			return true;
		return false;
	}
	
	public boolean isPacer() {
		if(id == 8)
			return true;
		return false;
	}
	
	public boolean isFalling() {
		Square[][] board = GraphicInterface.getGame().getBoard();
		if (!board[y + 1][x].isSupport() && !board[y][x].isLadder()
				&& y + 2 < board.length)
			return true;
		return false;
	}
	
	public boolean isStuck() {
		Square[][] board = GraphicInterface.getGame().getBoard();
		if(board[y-1][x].isFree())
			return false;
		if(board[y+1][x].isFree())
			return false;
		if(board[y][x-1].isFree())
			return false;
		if(board[y][x+1].isFree())
			return false;
		return true;
	}
	
	public void freeze() {
		Game game = GraphicInterface.getGame();
		if (game.getBoard()[y][x].isFreezer() && !isFreezed()) {
			setFreezed(true);
			int time = new Random().nextInt(3-1)+1;
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}