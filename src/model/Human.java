package model;

public class Human implements Creature{
	private int hp;
	private int power;
	
	public Human() {
		this.hp = 10;
		this.power = 0;
	}
	
	@Override
	public boolean isAlive() {
		if(hp > 0)
			return true;
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
