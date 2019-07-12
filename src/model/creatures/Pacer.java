package model.creatures;

import View.GraphicInterface;
import model.Game;

public class Pacer extends Creature implements Runnable {
	private Action direction;

	public Pacer(int y, int x) {
		super(8, y, x);
		direction = Action.LEFT;
	}

	public void move() {
		Game game = GraphicInterface.getGame();
		
		while(game.getBoard()[y+1][x-1].isSupport() && game.getBoard()[y][x-1].isFree()) {
			sleep(500);
			game.move(this, y, x-1);
			direction = Action.LEFT;
		}

		while(game.getBoard()[y+1][x+1].isSupport() && game.getBoard()[y][x+1].isFree()) {
			sleep(500);
			game.move(this, y, x+1);
			direction = Action.RIGHT;
		}		
	}

	public Action getDirection() {
		return direction;
	}
	
	@Override
	public void run() {
		System.out.println("PACER");
		while(alive)
			move();
	}

}
