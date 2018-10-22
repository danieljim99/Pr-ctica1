import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class BackUp {
	static void updateUserList() {
		try(FileWriter write = new FileWriter("UserList.txt")) {
			for(int i = 0; i < User.userlist.size(); i++) {
				write.write(User.userlist.get(i).getUsername() + "#" + User.userlist.get(i).getPassword() + "$");
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println("Error while updating the users list.");
		}
	}
	
	static void rebootUserList() {
		try {
			FileReader read = new FileReader("UserList.txt");
			int caract = read.read();
			char car[] = new char[1];
			String reader;
			while(caract != '!' && caract != -1){
				String username = "";
				String pass = "";
				for(; caract != '#'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					username = username.concat(reader);
				}
				caract = read.read();
				for(; caract != '$'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					pass = pass.concat(reader);
				}
				User newuser = new User(username, pass, false);
				caract = read.read();
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Error while rebooting the users list, the file UserList.txt is not found, this will be created automatically later.");
		}
	}
	
	static void updateCategoryList() {
		try(FileWriter write = new FileWriter("CategoryList.txt")) {
			for(int i = 0; i < Category.categorylist.size(); i++) {
				write.write(Category.categorylist.get(i).getName() + "$");
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println("Error while updating the category list.");
		}
	}
	
	static void rebootCategoryList() {
		try {
			FileReader read = new FileReader("CategoryList.txt");
			int caract = read.read();
			char car[] = new char[1];
			String reader;
			while (caract != '!' && caract != -1) {
				String categoryname = "";
				for(; caract != '$'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					categoryname = categoryname.concat(reader);
				}
				Category newcategory = new Category(categoryname, false);
				caract = read.read();
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Error while rebooting the category list, the file CategoryList.txt is not found, this will be created automatically later.");
		}
	}
	
	static void updateProductList() {
		try(FileWriter write = new FileWriter("ProductList.txt")) {
			for(int i = 0; i < Category.categorylist.size(); i++) {
				for(int j = 0; j < Category.categorylist.get(i).productlist.size(); j++) {
					write.write(Category.categorylist.get(i).productlist.get(j).getName() + "#" + Category.categorylist.get(i).productlist.get(j).getCategoryId() + "#" + Category.categorylist.get(i).productlist.get(j).getStock() + "#" + Category.categorylist.get(i).productlist.get(j).getPrice() + "$");
				}
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println("Error while updating the product list.");
		}
	}
	
	static void rebootProductList() {
		try {
			FileReader read = new FileReader("ProductList.txt");
			int caract = read.read();
			char car[] = new char[1];
			String reader;
			while (caract != '!' && caract != -1) {
				String productname = "";
				String categoryid = "";
				String stock = "";
				String price = "";
				for(;caract != '#'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					productname = productname.concat(reader);
				}
				caract = read.read();
				for(;caract != '#'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					categoryid = categoryid.concat(reader);
				}
				caract = read.read();
				for(;caract != '#'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					stock = stock.concat(reader);
				}
				caract = read.read();
				for(;caract != '$'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					price = price.concat(reader);
				}
				Product newproduct = new Product(productname,Integer.parseInt(categoryid), Integer.parseInt(stock), Float.parseFloat(price), false);
				caract = read.read();
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Error while rebooting the product list, the file ProductList.txt is not found, this will be created automatically later");
		}
	}
	
	static void updateCartList() {
		try(FileWriter write = new FileWriter("CartList.txt")) {
			for(int i = 0; i < User.userlist.size(); i++) {
				for(int j = 0; j < User.userlist.get(i).cartlist.size(); j++){
					if (User.userlist.get(i).cartlist.get(j) != null) {
						write.write(User.userlist.get(i).cartlist.get(j).getName() + "#" + User.userlist.get(i).getUsername() + "$");
					}
				}
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println("Error while updating the cart list.");
		}
	}
	
	static void rebootCartList() {
		try{
			FileReader read = new FileReader("CartList.txt");
			int caract = read.read();
			char car[] = new char[1];
			String reader;
			while (caract != '!' && caract != -1) {
				String productname = "";
				String username = "";
				for(; caract != '#'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					productname = productname.concat(reader);
				}
				caract = read.read();
				for(; caract != '$'; caract = read.read()) {
					car[0] = (char)caract;
					reader = new String(car);
					username = username.concat(reader);
				}
				caract = read.read();
				User tempuser = User.searchUser(username);
				if (tempuser != null) {
					Product tempproduct = Category.searchProduct(productname);
					if (tempproduct.getName() != null) {
						tempuser.addProduct(tempproduct);
					}
				}
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Error while rebooting the cart list, the file CartList.txt is not found, this will be created automatically later.");
		}
	}
	
	static void rebootAll() {		
		rebootUserList();
		rebootCategoryList();
		rebootProductList();
		rebootCartList();
	}
	
	static void updateAll() {
		updateUserList();
		updateCategoryList();
		updateProductList();
		updateCartList();
	}
}