public class Product {
	String name;
	int id;
	int category_id;
	int stock;
	float price;
	static int cont_products = 0;
	
	Product(){
		name = null;
		id = -1;
		category_id = -1;
		stock = -1;
		price = -1;
	}
	
	Product(String name, int category_id, int stock, float price){
		this.name = name;
		this.id = ++cont_products;
		this.category_id = category_id;
		this.stock = stock;
		this.price = price;
		boolean encontrado = false;
		for(int i = 0; i < Category.categorylist.size(); i++) {
			if(category_id == Category.categorylist.get(i).getId()) {
				Category.categorylist.get(i).addProduct(this);
				encontrado = true;
			}
		}
		if(!encontrado) {
			Category category = new Category("Undefindedcategory(" + category_id + ")");
		}
	}
	
	void information() {
		System.out.println("Name: " + this.getName());
		System.out.println("ID: " + this.getId());
		System.out.println("Stock: " + this.getStock());
		System.out.println("Prize: " + this.getPrice());
	}
	
	static void removeProduct(int id) {
		boolean find = false;
		for(int i = 0; i < Category.categorylist.size(); i++) {
			for(int j = 0; j < Category.categorylist.get(i).productlist.size(); j++){
				if(Category.categorylist.get(i).productlist.get(j).getId() == id) {
					find = true;
					Category.categorylist.get(i).productlist.remove(j);
					break;
				}
			}
		}
		if(find) {
			System.out.println("The product has been removed.");
		} else {
			System.out.println("Error, product not found.");
		}
	}
	
	String getName() {
		return name;
	}
	
	int getId() {
		return id;
	}
	
	int getCategoryId() {
		return category_id;
	}
	
	int getStock() {
		return stock;
	}
	
	float getPrice() {
		return price;
	}
}