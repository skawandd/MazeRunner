package model.squares;

import model.Square;

public class Hyper extends Square {
	private int hyperId;
	
	public Hyper() {
		super(3);
	}
	
	public Hyper(int y, int x) {
		super(3, y, x);
	}

	@Override
	public int getHyperId() {
		return hyperId;
	}
	
	public void setHyperId(int id) {
		hyperId = id;
	}
	
	@Override
	public String toString() {
		return "\n Hyper\n SquareID: "+7+"\n HyperID: "+hyperId+"\n";
	}
}
