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
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class MainMenuController {
	boolean loginIsVisible = false;
	boolean registerIsVisible = false;
	
	@FXML
	private Label usernameConstraint;

	@FXML
	private Label passwordConstraint;
	
    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameLogin;
    
    @FXML
    private TextField passwordLoginVisible;

    @FXML
    private PasswordField passwordLogin;
    
    @FXML
    private Button showLogin;

    @FXML
    private Button registerButton;

    @FXML
    private Label userExists;
    
    @FXML
    private TextField usernameRegister;
    
    @FXML
    private TextField passwordRegisterVisible;

    @FXML
    private PasswordField passwordRegister;
    
    @FXML
    private Button showRegister;
    
    @FXML
    private Button enterButton;

    @FXML
    void LoginButtonPressed(ActionEvent event) {
    	usernameLogin.setVisible(true);
    	passwordLogin.setVisible(true);
    	showLogin.setVisible(true);
    	usernameRegister.setVisible(false);
    	passwordRegister.setVisible(false);
    	usernameRegister.setText("");
    	passwordRegister.setText("");
    	showRegister.setVisible(false);
    }

    @FXML
    void registerButtonPressed(ActionEvent event) {
    	usernameLogin.setVisible(false);
		passwordLogin.setVisible(false);
		showLogin.setVisible(false);
		usernameRegister.setVisible(true);
		passwordRegister.setVisible(true);
		usernameLogin.setText("");
    	passwordLogin.setText("");
    	showRegister.setVisible(true);
    }
    
    int errorLogin() {
    	int cont = 0;
    	if(usernameLogin.getText().length() < 8) {
        	usernameLogin.setText("");
        	usernameConstraint.setText(LanguageManager.usernameConstraint);
        	usernameConstraint.setVisible(true);
        	cont++;
    	}
    	if(!loginIsVisible) {
    		if(passwordLogin.getText().length() < 8) {
            	passwordLogin.setText("");
            	passwordConstraint.setText(LanguageManager.passwordConstraint);
            	passwordConstraint.setVisible(true);
            	cont++;
            }
    	} else {
    		if(passwordLoginVisible.getText().length() < 8) {
            	passwordLoginVisible.setText("");
            	passwordConstraint.setText(LanguageManager.passwordConstraint);
            	passwordConstraint.setVisible(true);
            	cont++;
            }
    	}
    	boolean logged = false;
    	for(int i = 0; i < User.userlist.size(); i++) {
    		if(!loginIsVisible) {
    			if (usernameLogin.getText().equals(User.userlist.get(i).getUsername()) && Ui.hash(passwordLogin.getText()).equals(User.userlist.get(i).getPassword())) {
    				logged = true;
    				User.loggeduser = User.userlist.get(i);
    				break;
    			}
    		} else {
    			if (usernameLogin.getText().equals(User.userlist.get(i).getUsername()) && Ui.hash(passwordLoginVisible.getText()).equals(User.userlist.get(i).getPassword())) {
    				logged = true;
    				User.loggeduser = User.userlist.get(i);
    				break;
    			}
    		}
		}
    	if(!logged) {
    		userExists.setText(LanguageManager.loginError);
    		usernameLogin.setText("");
    		passwordLogin.setText("");
    		passwordLoginVisible.setText("");
    		userExists.setVisible(true);
    	}
    	cont = (logged) ? cont : cont + 1;
    	return cont;
    }
    
    int errorRegister() {
    	int cont = 0;
    	if(usernameRegister.getText().length() < 8) {
    		usernameRegister.setText("");
    		usernameConstraint.setText(LanguageManager.usernameConstraint);
    		usernameConstraint.setVisible(true);
    		cont++;
    	}
    	if(!registerIsVisible) {
    		if(passwordRegister.getText().length() < 8) {
        		passwordRegister.setText("");
        		passwordConstraint.setText(LanguageManager.passwordConstraint);
        		passwordConstraint.setVisible(true);
        		cont++;
        	}
    	} else {
    		if(passwordRegisterVisible.getText().length() < 8) {
        		passwordRegisterVisible.setText("");
        		passwordConstraint.setText(LanguageManager.passwordConstraint);
        		passwordConstraint.setVisible(true);
        		cont++;
        	}
    	}
		boolean registered = true;
		for(int i = 0; i < User.userlist.size(); i++) {
			if (usernameRegister.getText().equals(User.userlist.get(i).getUsername())) {
				userExists.setText(LanguageManager.userExists);
				userExists.setVisible(true);
				usernameRegister.setText("");
				passwordRegister.setText("");
				registered = false;
				break;
			}
		}
		cont = (registered) ? cont : cont + 1;
    	return cont;
    }
    
    boolean isAdmin() {
    	return (usernameLogin.getText().equals("admin") && passwordLogin.getText().equals("admin"));
    }
    
    @FXML
    void showLoginPressed(ActionEvent event) {
    	if(loginIsVisible) {
    		passwordLogin.setText(passwordLoginVisible.getText());
    		passwordLoginVisible.setVisible(false);
    		passwordLogin.setVisible(true);
    		loginIsVisible = false;
    	} else {
    		passwordLoginVisible.setText(passwordLogin.getText());
    		passwordLogin.setVisible(false);
    		passwordLoginVisible.setVisible(true);
    		loginIsVisible = true;
    	}
    }
    
    @FXML
    void showRegisterPressed(ActionEvent event) {
    	if(registerIsVisible) {
    		passwordRegister.setText(passwordRegisterVisible.getText());
    		passwordRegisterVisible.setVisible(false);
    		passwordRegister.setVisible(true);
    		registerIsVisible = false;
    	} else {
    		passwordRegisterVisible.setText(passwordRegister.getText());
    		passwordRegister.setVisible(false);
    		passwordRegisterVisible.setVisible(true);
    		registerIsVisible = true;
    	}
    }
    
    void setAllEmptyAndInvisible() {
    	usernameLogin.setText("");
    	usernameLogin.setVisible(false);
    	passwordLogin.setText("");
    	passwordLogin.setVisible(false);
    	passwordLoginVisible.setText("");
    	passwordLoginVisible.setVisible(false);
    	showLogin.setVisible(false);
    	usernameRegister.setText("");
    	usernameRegister.setVisible(false);
    	passwordRegister.setText("");
    	passwordRegister.setVisible(false);
    	passwordRegisterVisible.setText("");
    	passwordRegisterVisible.setVisible(false);
    	showRegister.setVisible(false);
    }
    
    @FXML
    void enterButtonPressed(ActionEvent event) throws IOException {
    	usernameConstraint.setVisible(false);
    	passwordConstraint.setVisible(false);
    	userExists.setVisible(false);
    	if (isAdmin()) {
    		GraphicInterfaceMain.manager.adminMenuStage.show();
    		setAllEmptyAndInvisible();
			GraphicInterfaceMain.manager.mainMenuStage.close();
    	} else if(usernameLogin.isVisible() && (passwordLogin.isVisible() || passwordLoginVisible.isVisible())) {
    		if(errorLogin() == 0) {
    			GraphicInterfaceMain.manager.userMenuStage.show();
    			setAllEmptyAndInvisible();
        		GraphicInterfaceMain.manager.mainMenuStage.close();
    		}
    	} else if(usernameRegister.isVisible() && (passwordRegister.isVisible() || passwordRegisterVisible.isVisible())) {
    		if(errorRegister() == 0) {
    			User newuser;
    			if(!registerIsVisible) {
    				newuser = new User(usernameRegister.getText(), Ui.hash(passwordRegister.getText()), true);
    			} else {
    				newuser = new User(usernameRegister.getText(), Ui.hash(passwordRegisterVisible.getText()), true);
    			}
        		User.loggeduser = newuser;
        		GraphicInterfaceMain.manager.userMenuStage.show();
        		setAllEmptyAndInvisible();
        		GraphicInterfaceMain.manager.mainMenuStage.close();
    		}
    	}
    }
}