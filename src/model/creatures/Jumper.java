package model.creatures;

import model.Creature;
import View.GraphicInterface;

public class Jumper extends Creature implements Runnable {
	
	public Jumper(int y, int x) {
		super(7, y, x);
		GraphicInterface.getGame();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
