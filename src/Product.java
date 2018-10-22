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
	
	Product(String name, int category_id, int stock, float price, boolean update){
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
			Category category = new Category("Undefinedcategory(" + category_id + ")", true);
			BackUp.updateCategoryList();
			Category.searchCategory("Undefinedcategory(" + category_id + ")").addProduct(this);
		}
		if (update) {
			BackUp.updateProductList();
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
				if (Category.categorylist.get(i).productlist.get(j).getId() == id) {
					find = true;
					for(int k = 0; k < User.userlist.size(); k++) {
						for(int l = 0; l < User.userlist.get(k).cartlist.size(); l++) {
							if (User.userlist.get(k).cartlist.get(l).equals(Category.categorylist.get(i).productlist.get(j).getName())) {
								User.userlist.get(k).cartlist.remove(l);
							}
						}
					}
					Category.categorylist.get(i).productlist.remove(j);
					break;
				}
			}
		}
		if(find) {
			System.out.println("The product has been removed.");
			BackUp.updateProductList();
			BackUp.updateCartList();
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
	
	void addStock () {
		this.stock++;
	}
	
	void removeStock() {
		this.stock--;
	}
}