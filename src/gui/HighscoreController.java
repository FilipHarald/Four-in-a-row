package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import highscore.Highscore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HighscoreController implements Initializable {

	private Stage primaryStage;

    @FXML
    private ListView<String> list;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items = FXCollections.observableArrayList (Highscore.getHighscore());
		list.setItems(items);
	}


    @FXML
    void goToStartScreen(MouseEvent event) {
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
}
