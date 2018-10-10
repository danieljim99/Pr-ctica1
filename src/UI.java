import java.util.Scanner;
public class UI {
	static void userMenu() {
		Scanner kop = new Scanner(System.in);
		Scanner kcat = new Scanner(System.in);
		Scanner kpro = new Scanner(System.in);
		int op = 0;
		String select;
		Category cat = new Category();
		Product pro = new Product();
		do {
			System.out.println("\n1 - Show all categories");
			System.out.println("2 - Show products");
			System.out.println("3 - Show product information");
			System.out.println("4 - Exit");
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
				System.out.println("Shutting down the application");
				break;
			default:
				System.out.println("The introduced number is an invalid option, please introduce it again.");
			}
			
		} while(op != 4);
	}
}