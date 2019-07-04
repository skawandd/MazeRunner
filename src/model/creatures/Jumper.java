package model.creatures;

import View.GraphicInterface;

public class Jumper extends Creature implements Runnable {
	
	public Jumper(int y, int x) {
		super(7, y, x);
		GraphicInterface.getGame();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
	
		int x,y;
		x = this.x; 
		y = this.y; 
	  
		GraphicInterface.getGame().RandomTeleport(this);
			int rand = (int)(Math.random()*(4-1));
			if(rand == 4)
			{
				GraphicInterface.getGame().getBoard()[y][x].addApple();
			}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int rand = (int)(Math.random()*(8-3));
		move();
		try {
			Thread.sleep(rand*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}


}
