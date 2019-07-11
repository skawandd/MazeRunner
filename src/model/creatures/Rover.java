package model.creatures;

import java.util.Random;

import View.GraphicInterface;
import model.Game;

public class Rover extends Creature implements Runnable {

	public Rover(int y, int x) {
		super(9, y, x);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		Game game = GraphicInterface.getGame();
		Action a = flipCoin(Action.HORIZONTAL, Action.VERTICAL);
		boolean flag = false;
		
		if(a.equals(Action.HORIZONTAL)) {
			if(x < game.getHumanX() && game.getBoard()[y][x+1].isFree()) {
				game.move(this, y, x+1);
				flag = true;
			} else if(x > game.getHumanX() && game.getBoard()[y][x-1].isFree()) {
				game.move(this, y, x-1);
				flag = true;
			}
		}else if(a.equals(Action.VERTICAL)){
			if(y < game.getHumanY() && game.getBoard()[y+1][x].isFree()) {
				game.move(this, y+1, x);
				flag = true;
			} else if(y > game.getHumanY() && game.getBoard()[y-1][x].isFree()) {
				game.move(this, y-1, x);
				flag = true;
			}
		}else if(!isStuck() && flag == false)
			moveRandomly();
	}
	
	public Action flipCoin(Action a, Action b) {
		if(new Random().nextInt(100) < 50)
			return a;
		return b;
	}
	
	public void moveRandomly() {
		Game game = GraphicInterface.getGame();
		int i; 
		boolean flag = false;
		
		while(!flag) {
			i = new Random().nextInt(100);
			if(i <= 25 && game.getBoard()[y-1][x].isFree()) {
				game.move(this, y-1, x);
				flag = true;
			} else if(25 < i && i <= 50 && game.getBoard()[y+1][x].isFree()) {
				game.move(this, y+1, x);
				flag = true;
			} else if(50 < i && i <= 75 && game.getBoard()[y][x-1].isFree()) {
				game.move(this, y, x-1);
				flag = true;
			} else if(75 < i && i <= 100 && game.getBoard()[y][x-1].isFree()) {
				game.move(this, y, x+1);
				flag = true;
			}
		}
	}

	@Override
	public void run() {
		System.out.println("ROVER");
		while(alive) {
				int time = 300;
				sleep(time);
				move();
		}
		
	}

	

}
