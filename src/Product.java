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
		System.out.println("Nombre: " + this.getName() + " ID: " + this.getID());
		System.out.println("Unidades disponibles: " + this.getStock());
		System.out.println("Precio: " + this.getPrice());
	}
	
	String getName() {
		return name;
	}
	
	int getID() {
		return id;
	}
	
	int getCategory_id() {
		return category_id;
	}
	
	int getStock() {
		return stock;
	}
	
	float getPrice() {
		return price;
	}
}