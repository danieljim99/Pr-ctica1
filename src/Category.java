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
	
	int setName(String name) {
		this.name = name;
		return 0;
	}
	
	int setId(int id) {
		this.id = id;
		return 0;
	}
	
	int getId() {
		return id;
	}
	
	void addProduct(Product product) {
		productlist.add(product);
		BackUp.updateProductList();
	}
	
	static int printCategories() {
		if (categorylist.size() > 0) {
			System.out.print(categories + categorylist.get(0).getName());
			for(int i = 1; i < categorylist.size(); i++) {
				System.out.print(", " + categorylist.get(i).getName());
			}
			System.out.println(".");
		} else {
			System.out.println(noCategories);
		}
		return 0;
	}
	
	int printProducts() {
		if (productlist.size() > 0) {
			System.out.print(productsOf + this.getName() + ": " + productlist.get(0).getName());
			for(int i = 1; i < productlist.size(); i++) {
				System.out.print(", " + productlist.get(i).getName());
			}
			System.out.println(".");
		} else {
			System.out.println(noProducts);
		}
		return 0;
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
	
	static int removeCategory(int id) {
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
			BackUp.updateCategoryList();
			BackUp.updateProductList();
			BackUp.updateCartList();
			System.out.println(categoryRemoved);
		} else {
			System.out.println(categoryError);
		}
		return 0;
	}
	
	static String storageTreeToString() {
		String storageTree;
		if (categorylist.size() == 0) {
			storageTree = new String(noData);
		} else {
			storageTree = new String(showStorage + "\n");
			for(int i = 0; i < categorylist.size(); i++) {
				storageTree = storageTree.concat(categorylist.get(i).getName() + "(ID:" + categorylist.get(i).getId() + "):\n");
				for(int j = 0; j < categorylist.get(i).productlist.size(); j++) {
					storageTree = storageTree.concat("\t" + categorylist.get(i).productlist.get(j).getName() + "(ID:" + categorylist.get(i).productlist.get(j).getId() + ")\n");
				}
			}
		}
		return storageTree;
	}
	
	static int storageTree() {
		if(categorylist.size() == 0) {
			System.out.println(noData);
		} else {
			System.out.println(showStorage + "\n");
			for(int i = 0; i < categorylist.size(); i++) {
				System.out.println(categorylist.get(i).getName() + "(ID:" + categorylist.get(i).getId() + "):");
				for(int j = 0; j < categorylist.get(i).productlist.size(); j++) {
					System.out.println("\t" + categorylist.get(i).productlist.get(j).getName() + "(ID:" + categorylist.get(i).productlist.get(j).getId() + ")");
				}
			}
		}
		return 0;
	}
	
	static int renameCategory(String name, String newname) {
		if(searchCategory(newname).getName() != null) {
			System.out.println(categoryExists);
		} else {
			if(searchCategory(name).getName() == null) {
				System.out.println(categoryError);
			} else {
				searchCategory(name).setName(newname);
				System.out.println(nameChanged);
				BackUp.updateCategoryList();
			}
		}
		return 0;
	}
}