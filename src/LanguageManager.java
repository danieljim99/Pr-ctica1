import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LanguageManager {
	static protected String printCategories = null;
	static protected String printProducts = null;
	static protected String searchProduct = null;
	static protected String addProduct = null;
	static protected String showCart = null;
	static protected String removeProductCart = null;
	static protected String exit = null;
	static protected String askCategoryName = null;
	static protected String categoryError = null;
	static protected String askProductName = null;
	static protected String productError = null;
	static protected String askProductRemove = null;
	static protected String shutdown = null;
	static protected String invalidOption = null;
	static protected String storageTree = null;
	static protected String createCategory = null;
	static protected String createProduct = null;
	static protected String removeCategory = null;
	static protected String removeProduct = null;
	static protected String renameCategory = null;
	static protected String categoryName = null;
	static protected String categoryExists = null;
	static protected String productName = null;
	static protected String productExists = null;
	static protected String categoryId = null;
	static protected String productStock = null;
	static protected String productPrice = null;
	static protected String categoryAdvertisment = null;
	static protected String categoryIdRemove = null;
	static protected String productAdvertisment = null;
	static protected String productIdRemove = null;
	static protected String categoryOldName = null;
	static protected String categoryNewName = null;
	static protected String language = null;
	static protected String registrer = null;
	static protected String login = null;
	static protected String settings = null;
	static protected String loginError = null;
	static protected String bye = null;
	static protected String welcome = null;
	
	static protected void setLanguageSpanish() {
		Properties español = new Properties();
		FileReader fich = null;
		try {
			fich = new FileReader("languages\\ES.txt");
			español.load(fich);
			printCategories = español.getProperty("printCategories");
			printProducts = español.getProperty("printProducts");
			searchProduct = español.getProperty("searchProduct");
			addProduct = español.getProperty("addProduct");
			showCart = español.getProperty("showCart");
			removeProductCart = español.getProperty("removeProductCart");
			exit = español.getProperty("exit");
			askCategoryName = español.getProperty("askCategoryName");
			categoryError = español.getProperty("categoryError");
			askProductName = español.getProperty("askProductName");
			productError = español.getProperty("productError");
			askProductRemove = español.getProperty("askProductRemove");
			shutdown = español.getProperty("shutdown");
			invalidOption = español.getProperty("invalidOption");
			storageTree = español.getProperty("storageTree");
			createCategory = español.getProperty("createCategory");
			createProduct = español.getProperty("createProduct");
			removeCategory = español.getProperty("removeCategory");
			removeProduct = español.getProperty("removeProduct");
			renameCategory = español.getProperty("renameCategory");
			categoryName = español.getProperty("categoryName");
			categoryExists = español.getProperty("categoryExists");
			productName = español.getProperty("productName");
			productExists = español.getProperty("productExists");
			categoryId = español.getProperty("categoryId");
			productStock = español.getProperty("productStock");
			productPrice = español.getProperty("productPrice");
			categoryAdvertisment = español.getProperty("categoryAdvertisment");
			categoryIdRemove = español.getProperty("categoryIdRemove");
			productAdvertisment = español.getProperty("productAdvertisment");
			productIdRemove = español.getProperty("productIdRemove");
			categoryOldName = español.getProperty("categoryOldName");
			categoryNewName = español.getProperty("categoryNewName");
			language = español.getProperty("language");
			registrer = español.getProperty("registrer");
			login = español.getProperty("login");
			settings = español.getProperty("settings");
			loginError = español.getProperty("loginError");
			bye = español.getProperty("bye");
			welcome = español.getProperty("welcome");
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	static protected void setLanguageEnglish() {
		Properties english = new Properties();
		FileReader fich = null;
		try {
			fich = new FileReader("languages\\EN.txt");
			english.load(fich);
			printCategories = english.getProperty("printCategories");
			printProducts = english.getProperty("printProducts");
			searchProduct = english.getProperty("searchProduct");
			addProduct = english.getProperty("addProduct");
			showCart = english.getProperty("showCart");
			removeProductCart = english.getProperty("removeProductCart");
			exit = english.getProperty("exit");
			askCategoryName = english.getProperty("askCategoryName");
			categoryError = english.getProperty("categoryError");
			askProductName = english.getProperty("askProductName");
			productError = english.getProperty("productError");
			askProductRemove = english.getProperty("askProductRemove");
			shutdown = english.getProperty("shutdown");
			invalidOption = english.getProperty("invalidOption");
			storageTree = english.getProperty("storageTree");
			createCategory = english.getProperty("createCategory");
			createProduct = english.getProperty("createProduct");
			removeCategory = english.getProperty("removeCategory");
			removeProduct = english.getProperty("removeProduct");
			renameCategory = english.getProperty("renameCategory");
			categoryName = english.getProperty("categoryName");
			categoryExists = english.getProperty("categoryExists");
			productName = english.getProperty("productName");
			productExists = english.getProperty("productExists");
			categoryId = english.getProperty("categoryId");
			productStock = english.getProperty("productStock");
			productPrice = english.getProperty("productPrice");
			categoryAdvertisment = english.getProperty("categoryAdvertisment");
			categoryIdRemove = english.getProperty("categoryIdRemove");
			productAdvertisment = english.getProperty("productAdvertisment");
			productIdRemove = english.getProperty("productIdRemove");
			categoryOldName = english.getProperty("categoryOldName");
			categoryNewName = english.getProperty("categoryNewName");
			language = english.getProperty("language");
			registrer = english.getProperty("registrer");
			login = english.getProperty("login");
			settings = english.getProperty("settings");
			loginError = english.getProperty("loginError");
			bye = english.getProperty("bye");
			welcome = english.getProperty("welcome");
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}