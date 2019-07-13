package model.creatures;

import java.util.Random;

import static model.Game.loose;

import view.GraphicInterface;

public class Jumper extends Creature implements Runnable {
	
	public Jumper(int y, int x) {
		super(7, y, x);
	}

	@Override
	public void move() {
		int y = this.y;
		int x = this.x;
		
		GraphicInterface.getGame().RandomTeleport(this);
		if(new Random().nextInt(100) <= 25)
			GraphicInterface.getGame().getBoard()[y][x].addApple();
	}

	@Override
	public void run() {
		while(!loose) {
				int time = new Random().nextInt(8-3)+3;
				sleep(time*1000);
				move();
		}
	}


}
