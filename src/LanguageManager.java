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
		Properties espa�ol = new Properties();
		FileReader fich = null;
		try {
			fich = new FileReader("languages\\ES.txt");
			espa�ol.load(fich);
			printCategories = espa�ol.getProperty("printCategories");
			printProducts = espa�ol.getProperty("printProducts");
			searchProduct = espa�ol.getProperty("searchProduct");
			addProduct = espa�ol.getProperty("addProduct");
			showCart = espa�ol.getProperty("showCart");
			removeProductCart = espa�ol.getProperty("removeProductCart");
			exit = espa�ol.getProperty("exit");
			askCategoryName = espa�ol.getProperty("askCategoryName");
			categoryError = espa�ol.getProperty("categoryError");
			askProductName = espa�ol.getProperty("askProductName");
			productError = espa�ol.getProperty("productError");
			askProductRemove = espa�ol.getProperty("askProductRemove");
			shutdown = espa�ol.getProperty("shutdown");
			invalidOption = espa�ol.getProperty("invalidOption");
			storageTree = espa�ol.getProperty("storageTree");
			createCategory = espa�ol.getProperty("createCategory");
			createProduct = espa�ol.getProperty("createProduct");
			removeCategory = espa�ol.getProperty("removeCategory");
			removeProduct = espa�ol.getProperty("removeProduct");
			renameCategory = espa�ol.getProperty("renameCategory");
			categoryName = espa�ol.getProperty("categoryName");
			categoryExists = espa�ol.getProperty("categoryExists");
			productName = espa�ol.getProperty("productName");
			productExists = espa�ol.getProperty("productExists");
			categoryId = espa�ol.getProperty("categoryId");
			productStock = espa�ol.getProperty("productStock");
			productPrice = espa�ol.getProperty("productPrice");
			categoryAdvertisment = espa�ol.getProperty("categoryAdvertisment");
			categoryIdRemove = espa�ol.getProperty("categoryIdRemove");
			productAdvertisment = espa�ol.getProperty("productAdvertisment");
			productIdRemove = espa�ol.getProperty("productIdRemove");
			categoryOldName = espa�ol.getProperty("categoryOldName");
			categoryNewName = espa�ol.getProperty("categoryNewName");
			language = espa�ol.getProperty("language");
			registrer = espa�ol.getProperty("registrer");
			login = espa�ol.getProperty("login");
			settings = espa�ol.getProperty("settings");
			loginError = espa�ol.getProperty("loginError");
			bye = espa�ol.getProperty("bye");
			welcome = espa�ol.getProperty("welcome");
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