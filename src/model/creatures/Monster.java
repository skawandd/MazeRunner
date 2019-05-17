package model.creatures;

import model.Creature;
import model.Square;

public abstract class Monster extends Creature{

	public abstract void move();
	
	public Monster(int id, int y, int x, Square currentSquare) {
		super(id, y, x, currentSquare);
		// TODO Auto-generated constructor stub
	}

}
