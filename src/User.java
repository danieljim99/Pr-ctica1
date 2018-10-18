import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String password;
	static User loggeduser;
	static List<User> userlist = new ArrayList<User>();
	List<Product> userproducts = new ArrayList<Product>();
	
	User(String username, String password, boolean update){
		this.username = username;
		this.password = password;
		userlist.add(this);
		if(update) {
			BackUp.updateUserList();
		}
	}
	
	void addProduct(Product product) {
		userproducts.add(product);
	}
	
	String getUsername() {
		return username;
	}
	
	String getPassword() {
		return password;
	}
}