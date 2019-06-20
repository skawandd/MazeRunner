package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;
import model.Square;

public class GraphicInterface extends Application {
	volatile Game game;

	@Override
	public void start(Stage primaryStage) throws Exception {
		game = new Game();
		Thread thread1 = new Thread(game);
		thread1.start();

		Label label = new Label(game.getPower() + "");
		Pane pane = new Pane(label);
		Scene scene = new Scene(pane);
		primaryStage.setTitle("MazeRunner");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	public GridPane buildGrid() {
		Square[][] board = game.getBoard();
		Square s;

		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				s = board[y][x];
				if (s.getHuman() != null) {
					// return "&";
				} else if (s.getApple()) {
					// return "*";
				} else if (s.getDig())
					// return "¤";

					switch (s.getId()) {
					case 0:
						// return "X";
					case 1:
						// return ".";
					case 2:
						// return "#";
					case 3:
						// return "Y";
					case 4:
						// return "F";
					case 5:
						// return"H";
					case 6:
						// return "G";
					case 7:
						// return "&";
					case 8:
						// return "J";
					case 9:
						// return "P";
					case 10:
						// return "R";
					default:
						// return " ";
					}
			}
		}
		return new GridPane();
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
