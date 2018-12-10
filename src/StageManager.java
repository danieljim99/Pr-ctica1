import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager extends Application{
	static Stage mainMenuStage;
	static Stage adminMenuStage;
	static Stage userMenuStage;

	void initialize() throws IOException {
		launch(null);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		mainMenuStage = new Stage();
		URL resMain = getClass().getClassLoader().getResource("MainMenu.fxml");
		Parent rootMain = FXMLLoader.load(resMain);
		Scene sceneMain = new Scene(rootMain);
		mainMenuStage.setTitle("Main Menu");
		mainMenuStage.setScene(sceneMain);
		mainMenuStage.show();
		
		adminMenuStage = new Stage();
		URL resAdmin = getClass().getClassLoader().getResource("AdminMenu.fxml");
		Parent rootAdmin = FXMLLoader.load(resAdmin);
		Scene sceneAdmin = new Scene(rootAdmin);
		adminMenuStage.setTitle("Admin Menu");
		adminMenuStage.setScene(sceneAdmin);
		
		userMenuStage = new Stage();
		URL resUser = getClass().getClassLoader().getResource("UserMenu.fxml");
		Parent rootUser = FXMLLoader.load(resUser);
		Scene sceneUser = new Scene(rootUser);
		userMenuStage.setTitle("User Menu");
		userMenuStage.setScene(sceneUser);
		
	}
}