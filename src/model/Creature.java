package model;

public class Creature extends Square{
	private Square currentSquare;
	
	public Creature(int id, int y, int x, Square currentSquare) {
		super(id, y, x);
		this.currentSquare = currentSquare;
	}
	
	@Override
	public Square getSquare() {
		return this.currentSquare;
	}
	
	public void isFalling() {
	
	}
}
