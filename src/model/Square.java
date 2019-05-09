package model;

public abstract class Square {
	private int id;
	private boolean apple, dig, alive;
	private Square currentSquare;
	
	public abstract void move();
	
	public Square(int id) {
		this.id = id;
		this.apple = false;
		this.dig = false;
		this.alive = false;
	}
	
	public Square (int id, Square currentSquare) {
		if(id > 6)
			this.alive = true;
		else
			this.alive = false;
		this.id = id;
		this.currentSquare = currentSquare;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public int getId() {
		return this.id;
	}

	public boolean getApple() {
		return this.apple;
	}
	
	public boolean getDig() {
		return this.dig;
	}

	public void addApple() {
		if(id == 1)
			apple = true;
	}
	
	public void removeApple() {
		if(id == 1)
			apple = false;
	}
	
	public void addDig() {
		if(id == 2)
			dig = true;
	}
	
	public void removeDig() {
		if(id == 2)
			dig = false;
	}
	
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	
	public boolean getAlive() {
		return this.alive;
	}

}
