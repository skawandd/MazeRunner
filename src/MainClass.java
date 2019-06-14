

import java.io.FileNotFoundException;

import View.GraphicInterface;
import javafx.application.Application;
import model.Game;

public class MainClass {
	
	public static void main(String[] args) throws FileNotFoundException {
		Game game = new Game();
		Thread thread1 = new Thread(game);
		thread1.start();
		Application.launch(GraphicInterface.class, args);
	}
	
}