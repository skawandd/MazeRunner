package model.creatures;

import View.GraphicInterface;
import javafx.scene.input.KeyCode;

public class Human extends Creature implements Runnable {
	private Action direction;
	
	public Human(int y, int x) {
		super(6, y, x);
		direction = Action.RIGHT;
	}

	@Override
	public void move() {
		GraphicInterface.getScene().setOnKeyPressed(e -> {
			if(isFreezed())
				e.consume();
			if(e.getCode() == KeyCode.L) {
				move_right();
				direction = Action.RIGHT;
			}
			if(e.getCode() == KeyCode.J) {
				move_left();
				direction = Action.LEFT;
			}
			if(e.getCode() == KeyCode.I)
				move_up();
			if(e.getCode() == KeyCode.K)
				move_down();
			if(e.getCode() == KeyCode.S)
				dig_sw();
			if(e.getCode() == KeyCode.F)
				dig_se();
			
		});
		
	}
	
	public Action getDirection() {
		return direction;
	}
	
	@Override
	public void run() {
		move();
	}
	
	
}
