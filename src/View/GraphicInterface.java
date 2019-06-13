package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GraphicInterface extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new HBox());
		primaryStage.setTitle("MazeRunner");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();

	}

}
