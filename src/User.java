import java.util.Scanner;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String password;
	static User loggeduser;
	static List<User> userlist = new ArrayList<User>();
	List<Product> cartlist = new ArrayList<Product>();
	
	User(String username, String password, boolean update){
		this.username = username;
		this.password = password;
		userlist.add(this);
		if(update) {
			BackUp.updateUserList();
		}
	}
	
	void addProduct(Product product) {
		if(product.stock == 0) {
			System.out.println("Error, the product is out of stock");
		} else {
			loggeduser.cartlist.add(product);
			BackUp.updateCartList();
			product.stock--;
			BackUp.updateProductList();
		}
	}
	
	Product searchProduct(String name) {
		Product product = new Product();
		for(int i = 0; i < loggeduser.cartlist.size(); i++) {
			if (name.equals(loggeduser.cartlist.get(i).getName())) {
				product = loggeduser.cartlist.get(i);
				break;
			}
		}
		return product;
	}
	
	void removeProduct(String name) {
		boolean found = false;
		int p = 0;
		for(int i = 0; i < loggeduser.cartlist.size(); i++) {
			if (name.equals(loggeduser.cartlist.get(i).getName())) {
				found = true;
				p = i;
				break;
			}
		}
		if (found) {
			loggeduser.cartlist.get(p).stock++;
			loggeduser.cartlist.remove(p);
			BackUp.rebootCartList();
			BackUp.rebootProductList();
		} else {
			System.out.println("Error, product not found.");
		}
	}
	
	static User searchUser(String username) {
		User find = null;
		for(int i = 0; i < userlist.size(); i++) {
			if (username.equals(userlist.get(i).getUsername())) {
				find = userlist.get(i);
				break;
			}
		}
		return find;
	}
	
	void showCart() {
		if (loggeduser.cartlist.size() > 0) {
			System.out.print("Your cart: " + loggeduser.cartlist.get(0).getName());
			for(int i = 1; i < loggeduser.cartlist.size(); i++) {
				System.out.print(", " + loggeduser.cartlist.get(i).getName());
			}
			System.out.println(".");
		} else {
			System.out.println("There are no products in your cart.");
		}
	}
	
	String getUsername() {
		return username;
	}
	
	String getPassword() {
		return password;
	}
}