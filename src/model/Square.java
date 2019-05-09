package model;

public class Square {
	private int id;
	private boolean apple, dig, alive;
	
	public Square(int id) {
		this.id = id;
		this.apple = false;
		this.dig = false;
		this.alive = false;
	}
	
	public Square(int id, boolean alive) {
		this(id);
		this.alive = alive;
	}
	
	public boolean isAlive() {
		return alive;
	}

	
	public void addApple() {
		if(id == 1)
			apple = true;
	}
	
	public void removeApple() {
		if(id == 1)
			apple = false;
	}
	
	public boolean getApple() {
		return this.apple;
	}
	
	public void addDig() {
		if(id == 2)
			dig = true;
	}
	
	public void removeDig() {
		if(id == 2)
			dig = false;
	}
	
	public boolean getDig() {
		return this.dig;
	}

}
