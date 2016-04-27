package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import game.*;
import highscore.Highscore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController implements Initializable {
	
	private Stage primaryStage;
	private Match match;
	
    @FXML
    private GridPane gridPane;
	
    @FXML
    private Button abortGameBtn;

    @FXML
    private Label playerOne;

    @FXML
    private Label playerTwo;

    @FXML
    private Label whoseTurn;

    @FXML
    void abortGame(MouseEvent event) {
    	goToStart();
    }
    
	private void goToStart() {
		FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/gui/Start.fxml"));
		
		Pane startPane = null;
		try {
			startPane = (Pane)startLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StartController controller = (StartController) startLoader.getController();
		
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(startPane, 400, 400);
		
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setUpMatch(Match match) {
		this.match = match;
		playerOne.setText(match.getPlayerName(1));
		playerTwo.setText(match.getPlayerName(2));
		for (int x = 0; x < match.getGameBoardCols(); x++) {
			for (int y = 0; y < match.getGameBoardRows(); y++) {
				final GridButton btn =  new GridButton(x, y);
				btn.setPrefSize(30, 30);
				btn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					buttonClicked(btn);
				});
				gridPane.add(btn, x, y);
			}
		}
		whoseTurn.setText("X");
	}
	
	private void buttonClicked(GridButton btn) {
		System.out.println("button pressed by player: " + match.getPreviousPlayer() + " x: " + btn.getX() + " y: " + btn.getY());
		if(match.makeMove(btn.getX(), btn.getY())){
			btn.label(match.getPreviousPlayer());
			int victor = match.checkForVictor(btn.getX(), btn.getY());			
			if(victor != 0){
				finishGame(victor);
			}
			whoseTurn.setText((match.getPreviousPlayer() == 1) ? "O" : "X");
		}else{
			System.out.println("INVALID MOVE");
		}
		
	}

	private void finishGame(int victor) {
		Highscore.addToHighScore(match.getPlayerName(victor));
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("We have a winner!");
		alert.setHeaderText(null);
		alert.setContentText("The winner is: " + match.getPlayerName(victor));

		alert.showAndWait();
		goToStart();
	}

	private class GridButton extends Button{
		private int x;
		private int y;
		
		public GridButton(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}

		public void label(int playerID){
			if (playerID == 1) {
				this.setText("X");				
			}else if (playerID == 2){
				this.setText("O");
			}else{
				this.setText("E");
			}
		}
	}
}
