import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BackUp extends LanguageManager{
	static int updateUserList() {
		try(FileWriter write = new FileWriter("UserList.txt")) {
			for(int i = 0; i < User.userlist.size(); i++) {
				write.write(User.userlist.get(i).getUsername() + "#" + User.userlist.get(i).getPassword() + "$");
			}
			write.write("!");
			write.close();
		} catch (IOException e) {
			System.out.println(errorUpdateUser);
		}
		return 0;
	}
	
	static int rebootUserList() {
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
		} catch (IOException e) {
			System.out.println(errorRebootUser);
		}
		return 0;
	}
	
	static int updateCategoryList() {
		try(FileWriter write = new FileWriter("CategoryList.txt")) {
			for(int i = 0; i < Category.categorylist.size(); i++) {
				write.write(Category.categorylist.get(i).getName() + "$");
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println(errorUpdateCategory);
		}
		return 0;
	}
	
	static int rebootCategoryList() {
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
				if (Category.categorylist.size() == 0) {
					Category newcategory = new Category(categoryname, false);
				} else {
					if (!categoryname.equals(Category.searchCategory(categoryname).getName())) {
						Category newcategory = new Category(categoryname, false);
					}
				}
				caract = read.read();
			}
			read.close();
		} catch (Exception e) {
			System.out.println(errorRebootCategory);
		}
		return 0;
	}
	
	static int updateProductList() {
		try(FileWriter write = new FileWriter("ProductList.txt")) {
			for(int i = 0; i < Category.categorylist.size(); i++) {
				for(int j = 0; j < Category.categorylist.get(i).productlist.size(); j++) {
					write.write(Category.categorylist.get(i).productlist.get(j).getName() + "#" + Category.categorylist.get(i).productlist.get(j).getCategoryId() + "#" + Category.categorylist.get(i).productlist.get(j).getStock() + "#" + Category.categorylist.get(i).productlist.get(j).getPrice() + "$");
				}
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println(errorUpdateProduct);
		}
		return 0;
	}
	
	static int rebootProductList() {
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
				if (!productname.equals(Category.searchProduct(productname).getName())){
					Product newproduct = new Product(productname,Integer.parseInt(categoryid), Integer.parseInt(stock), Float.parseFloat(price), false);
				}
				caract = read.read();
			}
			read.close();
		} catch (Exception e) {
			System.out.println(errorRebootProduct);
		}
		return 0;
	}
	
	static int updateCartList() {
		try(FileWriter write = new FileWriter("CartList.txt")) {
			for(int i = 0; i < User.userlist.size(); i++) {
				for(int j = 0; j < User.userlist.get(i).cartlist.size(); j++){
					if (User.userlist.get(i).cartlist.get(j) != null) {
						write.write(User.userlist.get(i).cartlist.get(j) + "#" + User.userlist.get(i).getUsername() + "$");
					}
				}
			}
			write.write("!");
			write.close();
		} catch (Exception e) {
			System.out.println(errorUpdateCart);
		}
		return 0;
	}
	
	static int rebootCartList() {
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
				User.loggeduser = User.searchUser(username);
				if (User.loggeduser != null) {
					Product tempproduct = Category.searchProduct(productname);
					if (tempproduct.getName() != null) {
						User.loggeduser.addProductCart(tempproduct.getName(), false);
					}
				}
				User.loggeduser = null;
			}
			read.close();
		} catch (IOException e) {
			System.out.println(errorRebootCart);
		}
		return 0;
	}
	
	static int rebootAll() {		
		rebootUserList();
		rebootCategoryList();
		rebootProductList();
		rebootCartList();
		return 0;
	}
	
	static int updateAll() {
		updateUserList();
		updateCategoryList();
		updateProductList();
		updateCartList();
		return 0;
	}
}