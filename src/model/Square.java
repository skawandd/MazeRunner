package model;

import java.util.ArrayList;

public abstract class Square {
	protected int id, x, y;
	private boolean apple, dig, alive;
	public ArrayList<Creature> list;
		
	public Square(int id) {
		this.id = id;
		apple = false;
		dig = false;
		list = new ArrayList<Creature>();
		
		if(id > 6) {
			this.alive = true;	
		}else 
			this.alive = false;	
	}
	
	public Square(int id, int y, int x) {
		this(id);
		this.y = y;
		this.x = x;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public int getId() {
		return id;
	}

	public boolean getApple() {
		return apple;
	}
	
	public boolean getDig() {
		return this.dig;
	}

	public void addApple() {
		if(id == 0)
			apple = true;
	}
	
	public void removeApple() {
		if(id == 0)
			apple = false;
	}
	
	public void addDig() {
		if(id == 1)
			dig = true;
	}
	
	public void removeDig() {
		if(id == 1)
			dig = false;
	}
	
	public Square getSquare() {
		return this;
	}
	
	public boolean getAlive() {
		return this.alive;
	}
	
	public boolean isFree() {
		if(!isBrick() || isDig())
			return true;
		return false;
	}
	
	public boolean isLadder() {
		if(id == 4)
			return true;
		return false;
	}
	
	public boolean isBrick() {
		if(id == 1)
			return true;
		return false;
	}

	public boolean isDig() {
		return dig;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isHyper() {
		if(id == 2)
			return true;
		return false;
	}
	
	public boolean isFreezer() {
		if(id == 3)
			return true;
		return false;
	}
	
	public boolean isSupport() {
		if((isBrick() && !isDig())|| isLadder())
			return true;
		return false;
	}
	
	public Creature getCreature(int i) {
		return list.get(i);
	}
	
	public Creature getCreature(Creature c) {
		System.out.println("getC");
		for(int i = 0; i < list.size(); ++i) {
			System.out.println("in");
			if(list.get(i).getId() == c.getId()) {
				System.out.println("GET");
				return list.get(i);
			}
		}
		return null;
	}
	
	public void addCreature(Creature c) {
		list.add(c);
	}
	
	public void removeCreature(Creature c) {
		list.remove(c);
	}
	
	public int getListSize() {
		return list.size();
	}
	
	public boolean isCreature() {
		if(list.size() == 0)
			return true;
		return false;
	}
	
	public Creature getHuman() {
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i).getId() == 6)
				return list.get(i);
		}
		return null;
	}
	public Creature getJumper() {
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i).getId() == 7)
				return list.get(i);
		}
		return null;
	}
	public Creature getRover() {
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i).getId() == 9)
				return list.get(i);
		}
		return null;
	}
	public Creature getPacer() {
		for(int i = 0; i < list.size(); ++i) {
			if(list.get(i).getId() == 8)
				return list.get(i);
		}
		return null;
	}
	
	public int getHyperId() {
		return -1;
	}

}
