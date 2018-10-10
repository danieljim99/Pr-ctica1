import java.util.ArrayList;
import java.util.List;
public class Category {
	String name;
	int id;
	static List<Category> categorylist = new ArrayList<Category>();
	List<Product> productlist = new ArrayList<Product>();
	
	Category(){
		name = null;
		id = -1;
	}
	
	Category(String name){
		this.name = name;
		this.id = categorylist.size() + 1;
		categorylist.add(this);
	}
	
	String getName() {
		return name;
	}
	
	int getId() {
		return id;
	}
	
	void addProduct(Product product) {
		productlist.add(product);
	}
	
	static void printCategories() {
		System.out.print("Categories list: " + categorylist.get(0).getName() + "(ID:0)");
		for(int i = 1; i < categorylist.size(); i++) {
			System.out.print(", " + categorylist.get(i).getName() + "(ID:" + i + ")");
		}
		System.out.println(".");
	}
	
	void printProducts() {
		System.out.print("Product list of " + this.getName() + ": " + productlist.get(0).getName());
		for(int i = 1; i < productlist.size(); i++) {
			System.out.print(", " + productlist.get(i).getName());
		}
		System.out.println(".");
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
			
		}
		return searched;
	}
}