package view;

import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Square;
import model.creatures.Action;
import model.creatures.Jumper;
import static view.Resources.*;

public class GraphicInterface extends Application implements Observer {
	private volatile static Game game;
	private volatile static Scene scene;
	volatile boolean win = false;

	volatile VBox vbox = new VBox();
	private GridPane gridPane = new GridPane();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		vbox.getChildren().add(gridPane);
		scene = new Scene(vbox);
		game = new Game();
		gridPane.getChildren().add(buildGrid());
		game.addObserver(this);
		
		primaryStage.setTitle("MazeRunner");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public GridPane buildGrid() {
		GridPane gridPane = new GridPane();

		Square[][] board = game.getBoard();
		Square s;
		ImageView iv;

		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				s = board[y][x];
				if (s.getJumper()!= null){
					iv = new ImageView(new Image(jumper));
				}else if(s.getPacer() != null && s.getPacer().getDirection() == Action.LEFT) {
					iv = new ImageView(new Image(pacer_left));
				}else if(s.getPacer() != null && s.getPacer().getDirection() == Action.RIGHT) {
					iv = new ImageView(new Image(pacer_right));
				}else if(s.getRover() != null) {
					iv = new ImageView(new Image(rover));
				} else if(s.getHuman() != null && s.getHuman().getDirection() == Action.RIGHT) {
					iv = new ImageView(new Image(human_right));
				}else if(s.getHuman() != null && s.getHuman().getDirection() == Action.LEFT) {
					iv = new ImageView(new Image(human_left));
				} else if (s.getApple())
					iv = new ImageView(new Image(apple));
				else if (s.getDig())
					iv = new ImageView(new Image(dig));

				else {

					switch (s.getId()) {
					case 0:
						iv = new ImageView(new Image(floor));
						break;
					case 1:
						iv = new ImageView(new Image(brick));
						break;
					case 2:
						iv = new ImageView(new Image(hyper));
						break;
					case 3:
						iv = new ImageView(new Image(freezer));
						break;
					case 4:
						iv = new ImageView(new Image(ladder));
						break;
					case 5:
						iv = new ImageView(new Image(goal));
						break;
					default:
						iv = null;
						System.out.println("NULL " + y + ";" + x + "id: " + board[y][x].getId());
						break;
					}
				}
				try {
					gridPane.add(iv, x, y);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return gridPane;
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static Scene getScene() {
		return scene;
	}

	@Override
	public synchronized void update(Observable arg0, Object arg1) {
		Platform.runLater(() -> {
			TextInterface.showBoard();
			vbox.getChildren().clear();
			vbox.getChildren().add(buildGrid());
		});
	}
}
