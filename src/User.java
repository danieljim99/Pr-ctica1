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
		}
	}
	
	Product searchProduct(String name) {
		Product product = new Product();
		for(int i = 0; i < cartlist.size(); i++) {
			if (name.equals(cartlist.get(i).getName())) {
				product = cartlist.get(i);
				break;
			}
		}
		return product;
	}
	
	void removeProduct(String name) {
		boolean found = false;
		int p = 0;
		for(int i = 0; i < cartlist.size(); i++) {
			if (name.equals(cartlist.get(i).getName())) {
				found = true;
				p = i;
				break;
			}
		}
		if (found) {
			cartlist.remove(p);
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
		if (cartlist.size() > 0) {
			System.out.print("Your cart: " + cartlist.get(0).getName());
			for(int i = 1; i < cartlist.size(); i++) {
				System.out.print(", " + cartlist.get(i).getName());
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