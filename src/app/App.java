package app;
import gui.StartController;
import highscore.Highscore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/gui/Start.fxml"));
		
		Pane startPane = (Pane)startLoader.load();
		
		StartController controller = (StartController) startLoader.getController();
		
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(startPane, 400, 400);
		
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
