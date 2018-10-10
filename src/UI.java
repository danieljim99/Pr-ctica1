import java.util.Scanner;
public class UI {
	static void userMenu() {
		Scanner keyboard = new Scanner(System.in);
		int op = 0;
		String select = null;
		Category cat = new Category();
		do {
			System.out.println("1 - Show all categories");
			System.out.println("2 - Show products");
			System.out.println("3 - Show product information");
			System.out.println("4 - Exit");
			System.out.print("_>");
			op = keyboard.nextInt();
			switch(op) {
			case 1:
				Category.printCategories();
				break;
			case 2:
				System.out.print("What is the category you are looking for? ");
				select = keyboard.nextLine();
				cat = Category.searchCategory(select);
				if(cat.getName() == null) {
					System.out.println("Error, category not found");
				} else {
					cat.printProducts();
				}
				break;
			case 3:
				System.out.println("What is the product you are looking for? ");
				break;
			case 4:
				break;
			default:
				System.out.println("The introduced number is an invalid option, please introduce it again.");
			}
		} while(op != 4);
	}
}