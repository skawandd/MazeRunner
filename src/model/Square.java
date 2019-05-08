package model;

public enum Square implements Element{
	Empty(),
	Floor(),
	Brick(),
	Hyper(),
	Freezer(),
	Ladder(),
	Goal();
	
	private boolean apple, dig;
	
	private Square() {
		this.apple = false;
		this.dig = false;
	}
	
	public void addApple() {
		if(this == Floor)
			Floor.apple = true;
	}
	
	public void removeApple() {
		if(this == Floor)
			Floor.apple = false;
	}
	
	public boolean getApple() {
		return this.apple;
	}
	
	public void addDig() {
		if(this == Brick)
			Floor.dig = true;
	}
	
	public void removeDig() {
		if(this == Brick)
			Floor.dig = false;
	}
	
	public boolean getDig() {
		return this.dig;
	}

}
