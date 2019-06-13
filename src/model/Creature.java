package model;

public abstract class Creature {
	private int id;
	private int y, x;
	private boolean teleported;
	
	public Creature(int id, int y, int x) { 
		this.id = id;
		this.x = x;
		this.y = y;
		teleported = false;
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
}