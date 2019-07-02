package View;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class RunnableGridPane extends GridPane implements Runnable {
	
	public RunnableGridPane() {
		super();
	}
	
	public void add(Node n, int x, int y) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				add(n, x, y);
			}
			
		});
		
	}
	
	public void clear() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				clear();
			}
			
		});
		
	}

	public void setGrid(GridPane gridPane) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getChildren().setAll(gridPane.getChildren());
			}
		});
	}
	
	public Node getNodeFromGridPane(GridPane gridPane, int row, int col) {
		for(Node n: gridPane.getChildren()) {
			if (GridPane.getColumnIndex(n) == col && GridPane.getRowIndex(n) == row) {
				return n;
			}
		}
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
