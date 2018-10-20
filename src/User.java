import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String password;
	static User loggeduser;
	static List<User> userlist = new ArrayList<User>();
	List<Product> cart = new ArrayList<Product>();
	
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
			cart.add(product);
			BackUp.updateCartList();
			product.stock--;
		}
	}
	
	User searchUser(String username) {
		User find = null;
		for(int i = 0; i < userlist.size(); i++) {
			if (username.equals(userlist.get(i).getUsername()));
			find = 
		}
		return find;
	}
	
	String getUsername() {
		return username;
	}
	
	String getPassword() {
		return password;
	}
}