package model.creatures;

import model.Creature;
import java.util.Scanner;

public class Human implements Creature{
	private int hp;
	private int power;
	private int range;
	
	public Human() {
		this.hp = 10;
		this.power = 0;
		this.range = 1;
	}
	
	@Override
	public boolean isAlive() {
		if(hp > 0)
			return true;
		return false;
	}

	@Override
	public void move() {		
		
	}

}
