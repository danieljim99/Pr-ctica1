import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class AdminMenuController {
	@FXML
	private ToggleGroup AdminMenuGroup;
	
    @FXML
    private RadioButton storageTreeButton;
    
    @FXML
    private RadioButton createCategoryButton;

    @FXML
    private RadioButton createProductButton;

    @FXML
    private RadioButton removeCategoryButton;

    @FXML
    private RadioButton removeProductButton;

    @FXML
    private RadioButton renameCategoryButton;

    @FXML
    private TextArea storageTree;

    @FXML
    private TextField categoryName;
    
    @FXML
    private Button categoryCreateButton;
    
	@FXML
	private Button returnButton;

    @FXML
    void storageTreeButtonPressed(ActionEvent event) {
    	storageTree.setText(Category.storageTreeToString());
    	categoryName.setVisible(false);
    	storageTree.setVisible(true);
    	categoryCreateButton.setVisible(false);
    }
	
    @FXML
    void createCategoryButtonPressed(ActionEvent event) {
    	categoryName.setVisible(true);
    	storageTree.setVisible(false);
    	categoryCreateButton.setVisible(true);
    }
    
    @FXML
    void createProductButtonPressed(ActionEvent event) {
    	categoryName.setVisible(false);
    	storageTree.setVisible(false);
    	categoryCreateButton.setVisible(false);
    }

    @FXML
    void removeCategoryButtonPressed(ActionEvent event) {
    	categoryName.setVisible(false);
    	storageTree.setVisible(false);
    	categoryCreateButton.setVisible(false);
    }

    @FXML
    void removeProductButtonPressed(ActionEvent event) {
    	categoryName.setVisible(false);
    	storageTree.setVisible(false);
    	categoryCreateButton.setVisible(false);
    }

    @FXML
    void renameCategoryButtonPressed(ActionEvent event) {
    	categoryName.setVisible(false);
    	storageTree.setVisible(false);
    	categoryCreateButton.setVisible(false);
    }
    
    @FXML
    void categoryCreateButtonPressed(ActionEvent event) {
    	
    }
    
	@FXML
	void returnButtonPressed(ActionEvent event) {
		GraphicInterfaceMain.manager.adminMenuStage.close();
		GraphicInterfaceMain.manager.mainMenuStage.show();
	}
}
