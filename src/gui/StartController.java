package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import game.Match;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartController implements Initializable  {
	
	Stage primaryStage;

    @FXML
    private TextField playerOneText;

    @FXML
    private TextField playerTwoText;

	@FXML
	private Button newGame;
	
	@FXML
	private Button highscoreBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

    @FXML
    void showHighscore(MouseEvent event) {
		FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/gui/Highscore.fxml"));
		Pane startPane = null;
		try {
			startPane = (Pane)startLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HighscoreController controller = (HighscoreController) startLoader.getController();
		controller.setPrimaryStage(primaryStage);
		Scene scene = new Scene(startPane, 400, 400);
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void startNewGame(MouseEvent event) {
		FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/gui/Game.fxml"));
		Pane startPane = null;
		try {
			startPane = (Pane)startLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		GameController controller = (GameController) startLoader.getController();
		controller.setPrimaryStage(primaryStage);
		Scene scene = new Scene(startPane, 600, 600);
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
		controller.setUpMatch(new Match(playerOneText.getText(), playerTwoText.getText()));
    }
    
    public void setPrimaryStage(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    }
}
