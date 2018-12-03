import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController {
	@FXML
	private Label usernameConstraint;

	@FXML
	private Label passwordConstraint;
	
    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameLogin;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameRegister;

    @FXML
    private PasswordField passwordRegister;
    
    @FXML
    private Button enterButton;

    @FXML
    void LoginButtonPressed(ActionEvent event) {
    	usernameLogin.setVisible(true);
    	passwordLogin.setVisible(true);
    	usernameRegister.setVisible(false);
    	passwordRegister.setVisible(false);
    	usernameRegister.setText("");
    	passwordRegister.setText("");
    }

    @FXML
    void registerButtonPressed(ActionEvent event) {
    	usernameLogin.setVisible(false);
		passwordLogin.setVisible(false);
		usernameRegister.setVisible(true);
		passwordRegister.setVisible(true);
		usernameLogin.setText("");
    	passwordLogin.setText("");
    }
    
    int errorLogin() {
    	int cont = 0;
    	if(usernameLogin.getText().length() < 8) {
        	usernameLogin.setText("");
        	usernameConstraint.setVisible(true);
        	cont++;
    	}
    	if(passwordLogin.getText().length() < 8) {
        	passwordLogin.setText("");
        	passwordConstraint.setVisible(true);
        	cont++;
        }
    	boolean logged = false;
    	for(int i = 0; i < User.userlist.size(); i++) {
			if (usernameLogin.getText().equals(User.userlist.get(i).getUsername()) && Ui.hash(passwordLogin.getText()).equals(User.userlist.get(i).getPassword())) {
				logged = true;
				User.loggeduser = User.userlist.get(i);
				break;
			}
		}
    	cont = (logged) ? cont : cont + 1;
    	return cont;
    }
    
    int errorRegister() {
    	int cont = 0;
    	if(usernameRegister.getText().length() < 8) {
    		usernameRegister.setText("");
    		usernameConstraint.setVisible(true);
    		cont++;
    	}
		if(passwordRegister.getText().length() < 8) {
    		passwordRegister.setText("");
    		passwordConstraint.setVisible(true);
    		cont++;
    	}
    	return cont;
    }
    
    boolean isAdmin() {
    	return (usernameLogin.getText().equals("admin") && passwordLogin.getText().equals("admin"));
    }
    
    @FXML
    void enterButtonPressed(ActionEvent event) throws IOException {
    	usernameConstraint.setVisible(false);
    	passwordConstraint.setVisible(false);
    	if (isAdmin()) {
    		GraphicInterfaceMain.manager.adminMenuStage.show();
			GraphicInterfaceMain.manager.mainMenuStage.close();
    	} else if(errorLogin() == 0 && usernameLogin.isVisible() && passwordLogin.isVisible()) {
    		GraphicInterfaceMain.manager.userMenuStage.show();
    		GraphicInterfaceMain.manager.mainMenuStage.close();
    	} else if(errorRegister() == 0 && usernameRegister.isVisible() && passwordRegister.isVisible()) {
    		GraphicInterfaceMain.manager.userMenuStage.show();
    		GraphicInterfaceMain.manager.mainMenuStage.close();
    	}
    }
}