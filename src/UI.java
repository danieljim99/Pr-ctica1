import java.util.Scanner;
public class Ui {
	static void userMenu() {
		Scanner kop = new Scanner(System.in);
		Scanner kcat = new Scanner(System.in);
		Scanner kpro = new Scanner(System.in);
		int op = 0;
		String select;
		Category cat = new Category();
		Product pro = new Product();
		do {
			System.out.println("\n1 - Show all categories.");
			System.out.println("2 - Show products by category.");
			System.out.println("3 - Search product.");
			System.out.println("4-Add product to your cart.");
			System.out.println("5 - Exit.");
			System.out.print("_> ");
			op = kop.nextInt();
			switch(op) {
			case 1:
				Category.printCategories();
				break;
			case 2:
				System.out.print("What is the category you are looking for? ");
				select = kcat.nextLine();
				cat = Category.searchCategory(select);
				if(cat.getName() == null) {
					System.out.println("Error, category not found");
				} else {
					cat.printProducts();
				}
				break;
			case 3:
				System.out.println("What is the product you are looking for? ");
				select = kpro.nextLine();
				pro = Category.searchProduct(select);
				if(pro.getName() == null) {
					System.out.println("Error, product not found");
				} else {
					pro.information();
				}
				break;
			case 4:
				System.out.println("What is the product you are looking for? ");
				select = kpro.nextLine();
				pro = Category.searchProduct(select);
				if(pro.getName() == null) {
					System.out.println("Error, product not found");
				} else {
					User.loggeduser.addProduct(pro);
				}
				break;
			case 5:
				System.out.println("Shutting down the application");
				break;
			default:
				System.out.println("The introduced number is an invalid option, please introduce it again.");
			}
			
		} while(op != 5);
	}
	static void adminMenu() {
		int op = 0;
		Scanner kop = new Scanner(System.in);
		Scanner kname = new Scanner(System.in);
		Scanner kname2 = new Scanner(System.in);
		Scanner kid = new Scanner(System.in);
		Scanner kstock = new Scanner(System.in);
		Scanner kprize = new Scanner(System.in);
		do {
			System.out.println("\n1 - Show storage tree.");
			System.out.println("2 - Create category.");
			System.out.println("3 - Create product.");
			System.out.println("4 - Remove category.");
			System.out.println("5 - Remove product.");
			System.out.println("6 - Rename category.");
			System.out.println("7 - Exit.");
			System.out.print("_> ");
			op = kop.nextInt();
			switch(op) {
			case 1:
				Category.storageTree();
				break;
			case 2:
				System.out.print("Introduce the category name: ");
				String name = kname.nextLine();
				if(Category.searchCategory(name).getName() != null) {
					System.out.println("There is already a category with that name.");
				} else {
					Category newcategory = new Category(name, true);
				}
				break;
			case 3:
				System.out.print("Introduce the product name: ");
				name = kname.nextLine();
				if(Category.searchProduct(name).getName() != null) {
					System.out.println("There is already a product with that name.");
				} else {
					System.out.print("Introduce the category ID: ");
					int id = kid.nextInt();
					System.out.print("Introduce the number of products you are going to create: ");
					int pst = kstock.nextInt();
					System.out.print("Introduce the price of this product: ");
					float ppr = kprize.nextFloat();
					Product newproduct = new Product(name, id, pst, ppr);
				}
				break;
			case 4:
				System.out.println("ATTENTION!  This option will remove a category and all its products, this cannot be undone.");
				System.out.print("Introduce the category id you want to remove: ");
				int id = kid.nextInt();
				Category.removeCategory(id);
				break;
			case 5:
				System.out.println("ATTENTION! this option will remove a product, this cannot be undone.");
				System.out.print("Introduce the product id you want to remove: ");
				id = kid.nextInt();
				Product.removeProduct(id);
				break;
			case 6:
				System.out.print("Introduce the name of the category you want to rename: ");
				name = kname.nextLine();
				System.out.print("Introduce the new name: ");
				String newname = kname2.nextLine();
				Category.renameCategory(name, newname);
				break;
			case 7:
				System.out.println("Shutting down the application.");
				break;
			default:
				System.out.println("The introduced number is an invalid option, please introduce it again.");
			}
		}while(op != 7);
	}
	
	static String hash(String password) {
		char crypted_pass [] = password.toCharArray();
		for(int i = 0; i < password.length(); i++) {
			crypted_pass[i] = (char) ((crypted_pass[i] + i * i + 2) % 256);
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
			checkequals = false;
			System.out.print("Username: ");
			username = kus.nextLine();
			System.out.print("Password: ");
			password = kpa.nextLine();
			if (username.length() >= 8) {
				checkusername = true;
			} else {
				System.out.println("The username must have at least 8 characters.");
			}
			if (password.length() >= 8){
				checkpassword = true;
			} else {
				System.out.println("The password must have at least 8 characteres.");
			}
			for(int i = 0; i < User.userlist.size(); i++) {
				if (!username.equals(User.userlist.get(i).getUsername())) {
					checkequals = true;
				} else {
					System.out.println("There is already an user with that username.");
				}
			}
		} while(!checkusername || !checkpassword || !checkequals);
		User newuser = new User(username, hash(password), true);
		User.loggeduser = newuser;
	}
	
	static void loginMenu() {
		
	}
	
	static void mainMenu() {
		int op = 0;
		Scanner kop = new Scanner(System.in);
		do {
			System.out.println("Welcome!\n");
			System.out.println("1-Register.");
			System.out.println("2-Login");
			System.out.println("3-Exit.");
			System.out.print("_>");
			op = kop.nextInt();
			switch (op) {
			case 1:
				registerMenu();
				break;
			case 2:
				loginMenu();
				break;
			case 3:
				System.out.println("Good Bye!");
				break;
			default:
				System.out.println("The introduced number is an invalid option, please introduce it again.");
			}
		} while (op != 3);
	}
}