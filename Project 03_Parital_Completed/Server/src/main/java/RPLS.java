import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RPLS extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		String fxmlFile = "/src/main/fxml/RPSLSP.fxml";
		FXMLLoader loader = new FXMLLoader();
		Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

		primaryStage.setTitle("Rock, Paper, Scissor, Lizard, Spock!!!");
		Scene scene = new Scene(root, 650,650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
