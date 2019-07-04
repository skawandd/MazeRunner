package model.creatures;

import java.util.Random;

import View.GraphicInterface;

public class Jumper extends Creature implements Runnable {
	
	public Jumper(int y, int x) {
		super(7, y, x);
		GraphicInterface.getGame();
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
		while(alive) {
			try {
				int time = new Random().nextInt(8-3)+3;
				Thread.sleep(time*1000);
				move();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
