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
	
	public int getId() {
		return this.id;
	}

	public boolean getApple() {
		return this.apple;
	}
	
	public boolean getDig() {
		return this.dig;
	}
	/*
	public void addApple() {
		if(this == Floor)
			Floor.apple = true;
	}
	
	public void removeApple() {
		if(this == Floor)
			Floor.apple = false;
	}
	
	public boolean getApple() {
		return this.apple;
	}
	
	public void addDig() {
		if(this == Brick)
			Floor.dig = true;
	}
	
	public void removeDig() {
		if(this == Brick)
			Floor.dig = false;
	}
	
	public boolean getDig() {
		return this.dig;
	}

	@Override
	public Square getElement() {
		return this;
	}
	*/
}
