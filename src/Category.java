import java.util.ArrayList;
import java.util.List;

public class Category extends LanguageManager {
	private String name;
	private int id;
	static int cont = 1;
	static List<Category> categorylist = new ArrayList<Category>();
	List<Product> productlist = new ArrayList<Product>();
	
	Category(){
		this.name = null;
		this.id = -1;
	}
	
	Category(String name, boolean update){
		this.name = name;
		this.id = cont++;
		categorylist.add(this);
		if(update) {
			BackUp.updateCategoryList();
		}
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	int getId() {
		return id;
	}
	
	void addProduct(Product product) {
		productlist.add(product);
		BackUp.updateProductList();
	}
	
	static void printCategories() {
		if (categorylist.size() > 0) {
			System.out.print("Categories: " + categorylist.get(0).getName());
			for(int i = 1; i < categorylist.size(); i++) {
				System.out.print(", " + categorylist.get(i).getName());
			}
			System.out.println(".");
		} else {
			System.out.println("There are no categories yet.");
		}
	}
	
	void printProducts() {
		if (productlist.size() > 0) {
			System.out.print("Products of " + this.getName() + ": " + productlist.get(0).getName());
			for(int i = 1; i < productlist.size(); i++) {
				System.out.print(", " + productlist.get(i).getName());
			}
			System.out.println(".");
		} else {
			System.out.println("There are no products in this category yet.");
		}
	}
	static Category searchCategory(String name) {
		Category searched = new Category();
		for(int i = 0; i < categorylist.size(); i++) {
			if(name.equals(categorylist.get(i).getName())) {
				searched = categorylist.get(i);
				break;
			}
		}
		return searched;
	}
	static Product searchProduct(String name) {
		Product searched = new Product();
		for(int i = 0; i < categorylist.size(); i++) {
			for(int j = 0; j < categorylist.get(i).productlist.size(); j++) {
				if(name.equals(categorylist.get(i).productlist.get(j).getName())){
					searched = categorylist.get(i).productlist.get(j);
					break;
				}
			}
		}
		return searched;
	}
	
	static void removeCategory(int id) {
		boolean find = false;
		for(int i = 0; i < categorylist.size(); i++) {
			if(categorylist.get(i).getId() == id) {
				find = true;
				for(int j = 0; j < categorylist.get(i).productlist.size(); j++) {
					categorylist.get(i).productlist.remove(j);
				}
				categorylist.remove(i);
				break;
			}
		}
		if(find) {
			System.out.println("The category has been removed.");
			BackUp.updateCategoryList();
			BackUp.updateProductList();
			BackUp.updateCartList();
		} else {
			System.out.println(categoryError);
		}
	}
	static void storageTree() {
		if(categorylist.size() == 0) {
			System.out.println("There are no data to show");
		} else {
			System.out.println("Showing the storage tree:\n");
			for(int i = 0; i < categorylist.size(); i++) {
				
				System.out.println(categorylist.get(i).getName() + "(ID:" + categorylist.get(i).getId() + "):");
				for(int j = 0; j < categorylist.get(i).productlist.size(); j++) {
					System.out.println("\t" + categorylist.get(i).productlist.get(j).getName() + "(ID:" + categorylist.get(i).productlist.get(j).getId() + ")");
				}
			}
		}
	}
	static void renameCategory(String name, String newname) {
		if(searchCategory(newname).getName() != null) {
			System.out.println(categoryExists);
		} else {
			if(searchCategory(name).getName() == null) {
				System.out.println(categoryError);
			} else {
				searchCategory(name).setName(newname);
				System.out.println("The name has been changed successfully.");
				BackUp.updateCategoryList();
			}
		}
	}
}