package model;

public class Creature extends Square{
	private Square currentSquare;
	
	public Creature(int id, Square currentSquare) {
		super(id, currentSquare);
		this.currentSquare = currentSquare;
	}
	
	@Override
	public Square getSquare() {
		return this.currentSquare;
	}

}
