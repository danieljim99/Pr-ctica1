import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private TextField productName;
    
    @FXML
    private TextField categoryId;
    
    @FXML
    private TextField productStock;
    
    @FXML
    private TextField productPrice;
    
    @FXML
    private Button categoryCreateButton;
    
    @FXML 
    private Button productCreateButton;
    
    @FXML
    private Button categoryRemoveButton;
    
    @FXML
    private Button productRemoveButton;
    
	@FXML
	private Button returnButton;
	
	@FXML
	private Label errorExists;

	void setAllFalse() {
    	storageTree.setVisible(false);
		categoryName.setVisible(false);
    	categoryCreateButton.setVisible(false);
    	productName.setVisible(false);
    	categoryId.setVisible(false);
    	productStock.setVisible(false);
    	productPrice.setVisible(false);
    	productCreateButton.setVisible(false);
    	categoryRemoveButton.setVisible(false);
    	errorExists.setVisible(false);
    	productRemoveButton.setVisible(false);
	}
	
	void setAllEmpty() {
		categoryName.setText("");
		productName.setText("");
		categoryId.setText("");
		productStock.setText("");
		productPrice.setText("");
	}
	
	int errorCreateCategory() {
		int cont = 0;
		if (categoryName.getText().equals(Category.searchCategory(categoryName.getText()).getName())) {
			errorExists.setText(LanguageManager.categoryExists);
			errorExists.setVisible(true);
			categoryName.setText("");
			cont++;
		}
		return cont;
	}
	
	int errorCreateProduct() {
		int cont = 0;
		if (productName.getText().equals(Category.searchProduct(productName.getText()).getName())) {
			errorExists.setText(LanguageManager.productExists);
			errorExists.setVisible(true);
			productName.setText("");
			categoryId.setText("");
			productStock.setText("");
			productPrice.setText("");
			cont++;
		}
		return cont;
	}
	
	int errorRemoveCategory() {
		int cont = 0;
		if (!categoryName.getText().equals(Category.searchCategory(categoryName.getText()).getName())) {
			categoryName.setText("");
			errorExists.setText(LanguageManager.categoryError);
			errorExists.setVisible(true);
		}
		return cont;
	}
	
	int errorRemoveProduct() {
		int cont = 0;
		if(!productName.getText().equals(Category.searchProduct(productName.getText()).getName())) {
			productName.setText("");
			errorExists.setText(LanguageManager.productError);
			errorExists.setVisible(true);
		}
		return cont;
	}
	
    @FXML
    void storageTreeButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    	storageTree.setVisible(true);
    	storageTree.setText(Category.storageTreeToString());
    }
	
    @FXML
    void createCategoryButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    	categoryName.setVisible(true);
    	categoryCreateButton.setVisible(true);
    }
    
    @FXML
    void createProductButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    	productName.setVisible(true);
    	categoryId.setVisible(true);
    	productStock.setVisible(true);
    	productPrice.setVisible(true);
    	productCreateButton.setVisible(true);
    }

    @FXML
    void removeCategoryButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    	categoryName.setVisible(true);
    	categoryRemoveButton.setVisible(true);
    }

    @FXML
    void removeProductButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    	productName.setVisible(true);
    	productRemoveButton.setVisible(true);
    }

    @FXML
    void renameCategoryButtonPressed(ActionEvent event) {
    	setAllFalse();
    	setAllEmpty();
    }
    
    @FXML
    void categoryCreateButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	if(errorCreateCategory() == 0 && !categoryName.getText().isEmpty()) {
    		Category newcategory = new Category(categoryName.getText(), true);
    	}
    }
    
    @FXML
    void productCreateButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	if(errorCreateProduct() == 0 && !productName.getText().isEmpty()) {
    		Product newproduct = new Product(productName.getText(), Ui.getIntOf(categoryId.getText()), Ui.getIntOf(productStock.getText()), Ui.getFloatOf(productPrice.getText()), true);
    	}
    }
    
    @FXML
    void categoryRemoveButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	if(errorRemoveCategory() == 0 && !categoryName.getText().isEmpty()) {
    		Category.removeCategory(Category.searchCategory(categoryName.getText()).getId());
    	}
    }
    
    @FXML
    void productRemoveButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	if(errorRemoveProduct() == 0 && !productName.getText().isEmpty()) {
    		Product.removeProduct(Category.searchProduct(productName.getText()).getId());
    	}
    }
    
	@FXML
	void returnButtonPressed(ActionEvent event) {
		GraphicInterfaceMain.manager.adminMenuStage.close();
		GraphicInterfaceMain.manager.mainMenuStage.show();
	}
}
