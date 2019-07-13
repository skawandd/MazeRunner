package model.creatures;

import java.awt.event.KeyEvent;

import javafx.scene.input.KeyCode;
import view.GraphicInterface;

public class Human extends Creature implements Runnable {
	private Action direction;
	
	public Human(int y, int x) {
		super(6, y, x);
		direction = Action.RIGHT;
	}

	
	public void KeyListener(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'L':
			move_right();
			direction = Action.RIGHT;
			break;
			
		case 'J':
			move_left();
			direction = Action.LEFT;
			break;
			
		case 'I':
			move_up();
			break;
			
		case 'K':
			move_down();
			break;
			
		case 'S':
			dig_sw();
			break;
			
		case 'F':
			dig_se();
			break;
			
		default:
			break;
		}
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
