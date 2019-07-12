package View;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainMenuController extends Application implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image img = new Image(getClass().getResource("/background.png").toExternalForm());
		BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, false, true);
		BackgroundImage bgImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bgSize);
		Background bg = new Background(bgImage);
		rootPane.setBackground(bg);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Load
		AnchorPane rootPane = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
		//Scene
		Scene scene = new Scene(rootPane);
		//Appliquer la scene stage
		stage.setScene(scene);
		stage.setResizable(false);
		//show
		stage.show();
	}
	
	public static void startWindow() {
		launch();
	}

	@FXML
	private void playPressed(ActionEvent event){

	}

	@FXML
	private void levelPressed(ActionEvent event){
		GraphicInterface gI = new GraphicInterface();
		Scene scene = gI.getScene();

		Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
		stage.setTitle("MazeRunner");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.show();
	}

	@FXML
	private void playersPressed(){

	}
}
