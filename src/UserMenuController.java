import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class UserMenuController {

	static Product product = null;
	
	@FXML
	private Pane pane;
	
    @FXML
    private MenuButton categoriesMenuButton;
    
    @FXML
    private Button searchProduct;
    
    @FXML
    private Button changeAccountButton;
    
    @FXML
    private Button buyButton;
    
    @FXML
    private Button cartButton;
    
    @FXML
    private Button removeProductCartButton;
    
    @FXML
    private TextField productName;
    
    @FXML
    private TextField productRemoveName;
    
    @FXML
    private Label errorExists;
    
    @FXML
    private Label productInfo;

    int errorSearchProduct(Product p) {
    	int cont = 0;
    	if(p.getName() == null) {
    		errorExists.setText(LanguageManager.productError);
    		productName.setText("");
    		productInfo.setVisible(false);
    		buyButton.setVisible(false);
    		errorExists.setVisible(true);
    		cont++;
    	}
    	return cont;
    }
    
    int errorBuy() {
    	int cont = 0;
    	if(User.loggeduser.searchProductCart(product.getName()) > -1) {
    		errorExists.setText(LanguageManager.productCart);
    		errorExists.setVisible(true);
    		cont++;
    	}
    	return cont;
    }
    
    int errorRemove() {
    	int cont = 0;
    	if(User.loggeduser.searchProductCart(productRemoveName.getText()) == -1) {
    		errorExists.setText(LanguageManager.productError);
    		errorExists.setVisible(true);
    		productRemoveName.setText("");
    		cont++;
    	}
    	return cont;
    }
    
    void createCategoryList() {
    	categoriesMenuButton.getItems().clear();
    	for(int i = 0; i < Category.categorylist.size(); i++) {
    		MenuItem menuItem = new MenuItem(Category.categorylist.get(i).getName());
    		menuItem.setOnAction(new EventHandler<ActionEvent>() {
    		    @Override public void handle(ActionEvent e) {
    		    	productName.setText("");
    		    	errorExists.setVisible(false);
    		        categoriesMenuButton.setText(menuItem.getText());
    		    }
    		});
    		categoriesMenuButton.getItems().add(menuItem);
    	}
    }
    
    @FXML
    void updatePane(MouseEvent event) {
    	createCategoryList();
    }
    
    @FXML 
    void searchProduct(ActionEvent event){
    	errorExists.setVisible(false);
    	Category c = Category.searchCategory(categoriesMenuButton.getText());
    	product = c.searchProduct(productName.getText());
    	if (errorSearchProduct(product) == 0) {
        	productInfo.setText(product.productInfo());
        	productInfo.setVisible(true);
        	buyButton.setVisible(true);
        	removeProductCartButton.setVisible(false);
        	productRemoveName.setVisible(false);
    	}
    }
    
    @FXML 
    void changeAccountButtonPressed(ActionEvent event) {
    	GraphicInterfaceMain.manager.mainMenuStage.show();
    	productName.setText("");
    	productInfo.setVisible(false);
    	buyButton.setVisible(false);
    	errorExists.setVisible(false);
    	productRemoveName.setText("");
    	productRemoveName.setVisible(false);
    	removeProductCartButton.setVisible(false);
    	GraphicInterfaceMain.manager.userMenuStage.close();
    }
    
    @FXML
    void buyButtonPressed(ActionEvent event){
    	if(errorBuy() == 0) {
    		User.loggeduser.addProductCart(product.getName(), true);
    		productInfo.setText(product.productInfo());
    	}
    }
    
    @FXML
    void cartButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	buyButton.setVisible(false);
    	productInfo.setText(User.loggeduser.cart());
    	productInfo.setVisible(true);
    	removeProductCartButton.setVisible(true);
    	productRemoveName.setVisible(true);
    }
    
    @FXML
    void removeProductCartButtonPressed(ActionEvent event) {
    	errorExists.setVisible(false);
    	if(errorRemove() == 0) {
    		User.loggeduser.removeProductCart(productRemoveName.getText());
    		productInfo.setText(User.loggeduser.cart());
    	}
    }
}