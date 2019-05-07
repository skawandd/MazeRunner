package model;

public enum Square implements Element{
	Empty(),
	Floor(),
	Brick(),
	Hyper(),
	Freezer(),
	Ladder(),
	Goal();
	
	private boolean apple;
	
	private Square() {
		this.apple = false;
	}
	
	public void addApple() {
		if(this == Floor)
			Floor.apple = true;
	}
	
	public void removeApple() {
		if(this == Floor)
			Floor.apple = false;
	}

}
