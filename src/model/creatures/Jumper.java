package model.creatures;

import static model.Game.loose;
import static model.Game.win;

import java.util.Random;

import view.GraphicInterface;

public class Jumper extends Creature implements Runnable {
	
	public Jumper(int y, int x) {
		super((byte) 7, y, x);
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
		while(!win && !loose) {
				int time = new Random().nextInt(8-3)+3;
				sleep(time*1000);
				move();
		}
	}


}
