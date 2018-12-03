import java.util.Scanner;

class Ui extends LanguageManager implements Menu {
	private static Menu menu = null;
	
	static int getIntOf(String n) {
		int i;
		try {
			i = Integer.parseInt(n);
		} catch (NumberFormatException e) {
			i = -1;
		}
		return i;
	}
	
	static float getFloatOf(String n) {
		float f;
		try {
			f = Float.parseFloat(n);
		} catch (NumberFormatException e) {
			f = 0;
		}
		return f;
	}
	
	@Override
	public void menu() {
		adminMenu();
	}
	
	static void userMenu() {
		Scanner kop = new Scanner(System.in);
		Scanner kcat = new Scanner(System.in);
		Scanner kpro = new Scanner(System.in);
		Scanner krem = new Scanner(System.in);
		String op = "0";
		String select;
		Category cat = new Category();
		Product pro = new Product();
		do {
			System.out.print("\n");
			System.out.println(printCategories);
			System.out.println(printProducts);
			System.out.println(searchProduct);
			System.out.println(addProduct);
			System.out.println(showCart);
			System.out.println(removeProductCart);
			System.out.println("7 - " + exit);
			System.out.print("_> ");
			op = kop.nextLine();
			switch(op) {
			case "1":
				Category.printCategories();
				break;
			case "2":
				System.out.print(askCategoryName);
				select = kcat.nextLine();
				cat = Category.searchCategory(select);
				if(cat.getName() == null) {
					System.out.println(categoryError);
				} else {
					cat.printProducts();
				}
				break;
			case "3":
				System.out.print(askProductName);
				select = kpro.nextLine();
				pro = Category.searchProduct(select);
				if(pro.getName() == null) {
					System.out.println(productError);
				} else {
					pro.information();
				}
				break;
			case "4":
				System.out.print(askProductName);
				select = kpro.nextLine();
				pro = Category.searchProduct(select);
				if(pro.getName() == null) {
					System.out.println(productError);
				} else {
					User.loggeduser.addProductCart(pro.getName(), true);
				}
				break;
			case "5":
				if (User.loggeduser != null) {
					User.loggeduser.showCart();
				} else {
					System.out.println("Error");
				}
				break;
			case "6":
				System.out.print(askProductRemove);
				select = krem.nextLine();
				User.loggeduser.removeProductCart(select);
				break;
			case "7":
				System.out.println(shutdown);
				User.loggeduser = null;
				break;
			default:
				System.out.println(invalidOption);
			}
			
		} while(!op.equals("7"));
	}
	static void adminMenu() {
		String op = "0";
		Scanner kop = new Scanner(System.in);
		Scanner kname = new Scanner(System.in);
		Scanner kname2 = new Scanner(System.in);
		Scanner kid = new Scanner(System.in);
		Scanner kstock = new Scanner(System.in);
		Scanner kprice = new Scanner(System.in);
		do {
			System.out.print("\n");
			System.out.println(storageTree);
			System.out.println(createCategory);
			System.out.println(createProduct);
			System.out.println(removeCategory);
			System.out.println(removeProduct);
			System.out.println(renameCategory);
			System.out.println("7 - " + exit);
			System.out.print("_> ");
			op = kop.nextLine();
			System.out.flush();
			switch(op) {
			case "1":
				System.out.println(Category.storageTreeToString());
				break;
			case "2":
				System.out.print(categoryName);
				String name = kname.nextLine();
				if(Category.searchCategory(name).getName() != null) {
					System.out.println(categoryExists);
				} else {
					Category newcategory = new Category(name, true);
				}
				break;
			case "3":
				System.out.print(productName);
				name = kname.nextLine();
				if(Category.searchProduct(name).getName() != null) {
					System.out.println(productExists);
				} else {
					System.out.print(categoryId);
					String id = kid.nextLine();
					System.out.print(productStock);
					String pst = kstock.nextLine();
					System.out.print(productPrice);
					String ppr = kprice.nextLine();
					Product newproduct = new Product(name, getIntOf(id), getIntOf(pst), getFloatOf(ppr), true);
				}
				break;
			case "4":
				System.out.println(categoryAdvertisment);
				System.out.print(categoryIdRemove);
				String id = kid.nextLine();
				Category.removeCategory(getIntOf(id));
				break;
			case "5":
				System.out.println(productAdvertisment);
				System.out.print(productIdRemove);
				id = kid.nextLine();
				Product.removeProduct(getIntOf(id));
				break;
			case "6":
				System.out.print(categoryOldName);
				name = kname.nextLine();
				System.out.print(categoryNewName);
				String newname = kname2.nextLine();
				Category.renameCategory(name, newname);
				break;
			case "7":
				System.out.println(shutdown);
				break;
			default:
				System.out.println(invalidOption);
			}
		}while(!op.equals("7"));
	}
	
	static String hash(String password) {
		char crypted_pass [] = password.toCharArray();
		for(int i = 0; i < password.length(); i++) {
			crypted_pass[i] = (char) ((crypted_pass[i] + i * i + 2) % 25 + 65);
		}
		String cryp = new String (crypted_pass);
		return cryp;
	}
	
	static void registerMenu() {
		String username = "";
		String password = "";	
		Scanner kus = new Scanner(System.in);
		Scanner kpa = new Scanner(System.in);
		boolean checkusername;
		boolean checkpassword;
		boolean checkequals;
		do {
			checkusername = false;
			checkpassword = false;
			checkequals = true;
			System.out.print(introduceUsername);
			username = kus.nextLine();
			System.out.print(introducePassword);
			password = kpa.nextLine();
			if (username.length() >= 8) {
				checkusername = true;
			} else {
				System.out.println(usernameConstraint);
			}
			if (password.length() >= 8) {
				checkpassword = true;
			} else {
				System.out.println(passwordConstraint);
			}
			for(int i = 0; i < User.userlist.size(); i++) {
				if (username.equals(User.userlist.get(i).getUsername()) || username.equals("admin")) {
					System.out.println(userExists);
					checkequals = false;
					break;
				}
			}
		} while(!checkusername || !checkpassword || !checkequals);
		User newuser = new User(username, hash(password), true);
		User.loggeduser = newuser;
	}
	
	static boolean loginMenu() {
		boolean admin = false;
		boolean logged = false;
		String username;
		String password;
		Scanner kus = new Scanner(System.in);
		Scanner kpa = new Scanner(System.in);
		System.out.print(introduceUsername);
		username = kus.nextLine();
		System.out.print(introducePassword);
		password = kpa.nextLine();
		for(int i = 0; i < User.userlist.size(); i++) {
			if (username.equals(User.userlist.get(i).getUsername()) && hash(password).equals(User.userlist.get(i).getPassword())) {
				logged = true;
				User.loggeduser = User.userlist.get(i);
				break;
			}
		}
		if(logged) {
			admin = false;
		} else {
			if (username.equals("admin") && password.equals("admin")) {
				admin = true;
			}
		}
		return admin;
	}
	
	static void settingsMenu() {
		Scanner klan = new Scanner(System.in);
		String op = "0";
		do {
			System.out.println(language);
			System.out.println("\t 1 - English.");
			System.out.println("\t 2 - Español.");
			System.out.print("_> ");
			op = klan.nextLine();
			switch (op) {
			case "1":
				LanguageManager.setLanguageEnglish();
				break;
			case "2":
				LanguageManager.setLanguageSpanish();
				break;
			default:
				System.out.println(invalidOption);
			}
		} while(!op.equals("1") && !op.equals("2"));
	}
	
	static void mainMenu() {
		String op = "0";
		Scanner kop = new Scanner(System.in);
		System.out.println(welcome + "\n");
		do {
			System.out.print("\n");
			System.out.println(registrer);
			System.out.println(login);
			System.out.println(settings);
			System.out.println("4 - " + exit);
			System.out.print("_> ");
			op = kop.nextLine();
			switch (op) {
			case "1":
				registerMenu();
				userMenu();
				break;
			case "2":
				if(loginMenu()) {
					menu = new Ui();
					menu.menu();
				} else {
					if (User.loggeduser != null) {
						menu = new ProxyMenu();
						menu.menu();
					} else {
						System.out.println(loginError);
					}
				}
				break;
			case "3":
				settingsMenu();
				break;
			case "4":
				System.out.println(bye);
				BackUp.updateAll();
				break;
			default:
				System.out.println(invalidOption);
			}
		} while (!op.equals("4"));
	}
}