package model;

public abstract class Creature extends Square{
	private boolean alive;
	private Square currentSquare;

	public abstract void move();
	
	public Creature(int id, Square currentSquare) {
		super(id, true);
		this.currentSquare = currentSquare;
		this.alive = true;
	}
	
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	
	public boolean getAlive() {
		return this.alive;
	}
	
}