import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String email;
	String password;
	static List<User> users = new ArrayList<User>();
	List<Product> user_products = new ArrayList<Product>();
	
	User(String username, String email, String password, boolean update){
		this.username = username;
		this.email = email;
		this.password = password;
		users.add(this);
		if(update) {
			BackUp.updateUserList();
		}
	}
	
	String getUsername() {
		return username;
	}
	
	String getEmail() {
		return email;
	}
	
	String getPassword() {
		return password;
	}
}