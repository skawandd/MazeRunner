package model.creatures;

import View.GraphicInterface;
import javafx.scene.input.KeyCode;

public class Human extends Creature implements Runnable {
	
	public Human(int y, int x) {
		super(6, y, x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		System.out.println("Listener");
		GraphicInterface.getScene().setOnKeyPressed(e -> {
			if(isFreezed())
				e.consume();
			if(e.getCode() == KeyCode.L) 
				move_right();
			if(e.getCode() == KeyCode.J)
				move_left();
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
	
	
	@Override
	public void run() {
		System.out.println("HUMAN THREAD");
		move();
	}
	
	
}
