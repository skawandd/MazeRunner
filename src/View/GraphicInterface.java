package View;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Square;

public class GraphicInterface extends Application implements Runnable {
	volatile Game game;
	volatile boolean win = false;

	volatile RunnableVBox vbox = new RunnableVBox();
	volatile RunnableGridPane gridPane = new RunnableGridPane();

	final private String sprites_path = "file:res/sprites/";
	final private String floor = sprites_path + "floor.png";
	final private String brick = sprites_path + "brick.png";
	final private String apple = sprites_path + "apple.png";
	final private String freezer = sprites_path + "freezer.png";
	final private String goal = sprites_path + "goal.png";
	final private String human_right = sprites_path + "human_right.png";
	final private String human_left = sprites_path + "human_left.png";
	final private String hyper = sprites_path + "hyper.png";
	final private String jumper = sprites_path + "jumper.png";
	final private String ladder = sprites_path + "ladder.png";
	final private String pacer_left = sprites_path + "pacer_left.png";
	final private String pacer_right = sprites_path + "pacer_right.png";
	final private String rover = sprites_path + "rover.png";
	final private String dig = sprites_path + "dig.png";

	@Override
	public void start(Stage primaryStage) throws Exception {
		game = new Game();
		Thread thread1 = new Thread(game);
		thread1.start();
		Thread thread2 = new Thread(this);
		thread2.start();
		gridPane.getChildren().add(buildGrid());

		System.out.println(game.getBoard()[0][0].getId());

		Label label = new Label(game.getPower() + "");
		vbox.getChildren().add(gridPane);
		Scene scene = new Scene(vbox);
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
				if (s.getHuman() != null) {
					iv = new ImageView(new Image(human_right));
					/*
					 * if (s.getJumper() != null) { FIXME: add getJumper, getPacer, getRover + side
					 * iv = new ImageView(new Image(jumper)); if (s.getPacer() != null) { iv = new
					 * ImageView(new Image(pacer_right)); if (s.getRover() != null) { iv = new
					 * ImageView(new Image(rover));
					 */
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
						iv = new ImageView(new Image(floor));
						break;
					case 2:
						iv = new ImageView(new Image(brick));
						break;
					case 3:
						iv = new ImageView(new Image(hyper));
						break;
					case 4:
						iv = new ImageView(new Image(freezer));
						break;
					case 5:
						iv = new ImageView(new Image(ladder));
						break;
					case 6:
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

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		while (!win) {
			
			//vbox.clear();
			//vbox.add(buildGrid());
			vbox.refresh(buildGrid());
			//System.out.println(".");
		//	gridPane.clear();
		//	gridPane = buildGrid();
		//	System.out.println("human x: " + game.getHumanX());
			try {
				Thread.sleep(200);
			//	wait(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
