package View;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class RunnableVBox extends VBox implements Runnable {
	private VBox vbox;
	
	public RunnableVBox() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void add(Node n) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getChildren().add(n);
			}
			
		});
		
	}
	
	public void clear() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getChildren().clear();
				
			}
			
		});

	}
	
	public void refresh(Node n) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getChildren().clear();
				getChildren().add(n);
			}
			
		});

	}

}
