package model.creatures;

import model.Creature;
import model.Square;

public abstract class Monster extends Creature{

	public abstract void move();
	
	public Monster(int id, Square currentSquare) {
		super(id, currentSquare);
		// TODO Auto-generated constructor stub
	}

}
