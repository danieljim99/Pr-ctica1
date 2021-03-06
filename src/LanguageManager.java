import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LanguageManager {
	static String printCategories = null;
	static String printProducts = null;
	static  String searchProduct = null;
	static  String addProduct = null;
	static  String showCart = null;
	static  String removeProductCart = null;
	static  String exit = null;
	static  String askCategoryName = null;
	static  String categoryError = null;
	static  String askProductName = null;
	static  String productError = null;
	static  String askProductRemove = null;
	static  String shutdown = null;
	static  String invalidOption = null;
	static  String storageTree = null;
	static  String createCategory = null;
	static  String createProduct = null;
	static  String removeCategory = null;
	static  String removeProduct = null;
	static  String renameCategory = null;
	static String categoryName = null;
	static String categoryExists = null;
	static String productName = null;
	static String productExists = null;
	static String categoryId = null;
	static String productStock = null;
	static String productPrice = null;
	static String categoryAdvertisment = null;
	static String categoryIdRemove = null;
	static String productAdvertisment = null;
	static String productIdRemove = null;
	static String categoryOldName = null;
	static String categoryNewName = null;
	static String language = null;
	static String registrer = null;
	static String login = null;
	static String settings = null;
	static String loginError = null;
	static String bye = null;
	static String welcome = null;
	static String introduceUsername = null;
	static String introducePassword = null;
	static String usernameConstraint = null;
	static String passwordConstraint = null;
	static String userExists = null;
	static String errorUpdateUser = null;
	static String errorRebootUser = null;
	static String errorUpdateCategory = null;
	static String errorRebootCategory = null;
	static String errorUpdateProduct = null;
	static String errorRebootProduct = null;
	static String errorUpdateCart = null;
	static String errorRebootCart = null;
	static String errorProductStock = null;
	static String productCart = null;
	static String yourCart = null;
	static String emptyCart = null;
	static String errorCategoryId = null;
	static String name = null;
	static String stock = null;
	static String price = null;
	static String productRemoved = null;
	static String categories = null;
	static String noCategories = null;
	static String productsOf = null;
	static String noProducts = null;
	static String categoryRemoved = null;
	static String noData = null;
	static String showStorage = null;
	static String nameChanged = null;
	
	static protected int setLanguageSpanish() {
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
			introduceUsername = espa�ol.getProperty("introduceUsername");
			introducePassword = espa�ol.getProperty("introducePassword");
			usernameConstraint = espa�ol.getProperty("usernameConstraint");
			passwordConstraint = espa�ol.getProperty("passwordConstraint");
			userExists = espa�ol.getProperty("userExists");
			errorUpdateUser = espa�ol.getProperty("errorUpdateUser");
			errorRebootUser = espa�ol.getProperty("errorRebootUser");
			errorUpdateCategory = espa�ol.getProperty("errorUpdateCategory");
			errorRebootCategory = espa�ol.getProperty("errorRebootCategory");
			errorUpdateProduct = espa�ol.getProperty("errorUpdateProduct");
			errorRebootProduct = espa�ol.getProperty("errorRebootProduct");
			errorUpdateCart = espa�ol.getProperty("errorUpdateCart");
			errorRebootCart = espa�ol.getProperty("errorRebootCart");
			errorProductStock = espa�ol.getProperty("errorProductStock");
			productCart = espa�ol.getProperty("productCart");
			yourCart = espa�ol.getProperty("yourCart");
			emptyCart = espa�ol.getProperty("emptyCart");
			errorCategoryId = espa�ol.getProperty("errorCategoryId");
			name = espa�ol.getProperty("name");
			stock = espa�ol.getProperty("stock");
			price = espa�ol.getProperty("price");
			productRemoved = espa�ol.getProperty("productRemoved");
			categories = espa�ol.getProperty("categories");
			noCategories = espa�ol.getProperty("noCategories");
			productsOf = espa�ol.getProperty("productsOf");
			noProducts = espa�ol.getProperty("noProducts");
			categoryRemoved = espa�ol.getProperty("categoryRemoved");
			noData = espa�ol.getProperty("noData");
			showStorage = espa�ol.getProperty("showStorage");
			nameChanged = espa�ol.getProperty("nameChanged");
		} catch (IOException e) {
			System.out.println("Error");
		}
		return 0;
	}
	
	static protected int setLanguageEnglish() {
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
			introduceUsername = english.getProperty("introduceUsername");
			introducePassword = english.getProperty("introducePassword");
			usernameConstraint = english.getProperty("usernameConstraint");
			passwordConstraint = english.getProperty("passwordConstraint");
			userExists = english.getProperty("userExists");
			errorUpdateUser = english.getProperty("errorUpdateUser");
			errorRebootUser = english.getProperty("errorRebootUser");
			errorUpdateCategory = english.getProperty("errorUpdateCategory");
			errorRebootCategory = english.getProperty("errorRebootCategory");
			errorUpdateProduct = english.getProperty("errorUpdateProduct");
			errorRebootProduct = english.getProperty("errorRebootProduct");
			errorUpdateCart = english.getProperty("errorUpdateCart");
			errorRebootCart = english.getProperty("errorRebootCart");
			errorProductStock = english.getProperty("errorProductStock");
			productCart = english.getProperty("productCart");
			yourCart = english.getProperty("yourCart");
			emptyCart = english.getProperty("emptyCart");
			errorCategoryId = english.getProperty("errorCategoryId");
			name = english.getProperty("name");
			stock = english.getProperty("stock");
			price = english.getProperty("price");
			productRemoved = english.getProperty("productRemoved");
			categories = english.getProperty("categories");
			noCategories = english.getProperty("noCategories");
			productsOf = english.getProperty("productsOf");
			noProducts = english.getProperty("noProducts");
			categoryRemoved = english.getProperty("categoryRemoved");
			noData = english.getProperty("noData");
			showStorage = english.getProperty("showStorage");
			nameChanged = english.getProperty("nameChanged");
		} catch (IOException e) {
			System.out.println("Error");
		}
		return 0;
	}
}