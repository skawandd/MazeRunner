package model;

public abstract class Square {
	private int id;
	private boolean apple, dig, alive;
	private Square currentSquare;
		
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
		if(id > 6) {
			return this.currentSquare;
		}
		return this;
	}
	
	public boolean getAlive() {
		return this.alive;
	}

	public boolean isJumper() {
		if(id == 8)
			return true;
		return false;
	}
	
	public boolean isPacer() {
		if(id == 9)
			return true;
		return false;
	}
	
	public boolean isRover() {
		if(id == 10)
			return true;
		return false;
	}
	
	public boolean isMonster() {
		if(isJumper() || isPacer() || isRover())
			return true;
		return false;
	}
	
	
	public boolean isFree() {
		if(id != 2)
			return true;
		return false;
	}
	
	

}
