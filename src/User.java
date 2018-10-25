import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String password;
	static User loggeduser;
	static List<User> userlist = new ArrayList<User>();
	List<String> cartlist = new ArrayList<String>();
	
	User(String username, String password, boolean update){
		this.username = username;
		this.password = password;
		userlist.add(this);
		if(update) {
			BackUp.updateUserList();
		}
	}
	
	void addProductCart(String product, boolean update) {
		boolean found = false;
		if(Category.searchProduct(product).stock == 0) {
			System.out.println("Error, the product is out of stock");
		} else {
			for(int i = 0; i < loggeduser.cartlist.size(); i++) {
				if (product.equals(loggeduser.cartlist.get(i))) {
					found = true;
					System.out.println("You have already that product in your cart.");
					break;					
				}
			}
			if (!found) {
				loggeduser.cartlist.add(product);
				if (update) {
					Category.searchProduct(product).removeStock();
					BackUp.updateProductList();
					BackUp.updateCartList();
				}
			}
		}
	}
	
	int searchProductCart(String name) {
		int p = -1;
		for(int i = 0; i < loggeduser.cartlist.size(); i++) {
			if (name.equals(loggeduser.cartlist.get(i))) {
				p = i;
				break;
			}
		}
		return p;
	}
	
	void removeProductCart(String name) {
		boolean found = false;
		int p = -1;
		for(int i = 0; i < loggeduser.cartlist.size(); i++) {
			if (name.equals(loggeduser.cartlist.get(i))) {
				found = true;
				p = i;
				break;
			}
		}
		if (found) {
			Category.searchProduct(name).addStock();
			loggeduser.cartlist.remove(p);
			BackUp.updateCartList();
			BackUp.updateProductList();
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
			System.out.print("Your cart: " + loggeduser.cartlist.get(0));
			for(int i = 1; i < loggeduser.cartlist.size(); i++) {
				System.out.print(", " + loggeduser.cartlist.get(i));
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