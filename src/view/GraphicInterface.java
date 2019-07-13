package view;

import static view.Resources.*;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Square;
import model.creatures.Action;

public class GraphicInterface extends Application implements Observer {
	private volatile static Game game;
	private volatile static Scene scene;

	volatile VBox vbox = new VBox();
	private GridPane gridPane = new GridPane();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MazeRunner");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	@Override
	public void init() {
		vbox.getChildren().add(gridPane);
		scene = new Scene(vbox);
		game = new Game();
		gridPane.getChildren().add(buildGrid());
		game.addObserver(this);
	}
	
	public void restart(Stage stage) {
		scene.getWindow().hide();
		init();
		stage.setTitle("MazeRunner");
		stage.setScene(scene);
		stage.show();
	}

	public GridPane buildGrid() {
		GridPane gridPane = new GridPane();

		Square[][] board = game.getBoard();
		Square s;
		ImageView iv;

		for (int y = 0; y < board.length; ++y) {
			for (int x = 0; x < board[0].length; ++x) {
				s = board[y][x];
				if (s.getJumper() != null) {
					if(s.isLadder())
						iv = new ImageView(new Image(jumper_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(jumper_freezer));
					else
						iv = new ImageView(new Image(jumper));
				} else if (s.getPacer() != null && s.getPacer().getDirection() == Action.LEFT) {
					if(s.isLadder())
						iv = new ImageView(new Image(pacer_left_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(pacer_left_freezer));
					else
						iv = new ImageView(new Image(pacer_left));
				} else if (s.getPacer() != null && s.getPacer().getDirection() == Action.RIGHT) {
					if(s.isLadder())
						iv = new ImageView(new Image(pacer_right_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(pacer_right_freezer));
					else
						iv = new ImageView(new Image(pacer_right));
				} else if (s.getRover() != null) {
					if(s.isLadder())
						iv = new ImageView(new Image(rover_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(rover_freezer));
					else
						iv = new ImageView(new Image(rover));
				} else if (s.getHuman() != null && s.getHuman().getDirection() == Action.RIGHT) {
					if(s.isLadder())
						iv = new ImageView(new Image(human_right_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(human_right_freezer));
					else
						iv = new ImageView(new Image(human_right));
				} else if (s.getHuman() != null && s.getHuman().getDirection() == Action.LEFT) {
					if(s.isLadder())
						iv = new ImageView(new Image(human_left_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(human_left_freezer));
					else
						iv = new ImageView(new Image(human_left));
				} else if (s.getApple())
					if(s.isLadder())
						iv = new ImageView(new Image(apple_ladder));
					else if(s.isFreezer())
						iv = new ImageView(new Image(apple_freezer));
					else
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

	public void displayLoose() {
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("GAME OVER");
			alert.setHeaderText("GAME OVER...");
			alert.setContentText("Try again?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				restart(new Stage());
			} else {
				System.exit(0);
			}
		});
	}
	
	public void displayWin() {
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("YOU WIN");
			alert.setHeaderText("YOU WIN!!!");
			alert.setContentText("Continue?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				restart(new Stage());
			} else {
				System.exit(0);
			}
		});
	}

	@Override
	public synchronized void update(Observable arg0, Object arg1) {
		Platform.runLater(() -> {
		//	TextInterface.showBoard();
			vbox.getChildren().clear();
			vbox.getChildren().add(buildGrid());
		});
	}
}
