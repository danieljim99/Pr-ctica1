public class Main {
	public static void main(String[] args) {
		Category books = new Category("Books");
		Category kk = new Category("Games");
		Product HarryPotter = new Product("Harry Potter", 1, 1, 20);
		Product SherlockHolmes = new Product("Sherlock Holmes", 1, 1, 20);
		Product hola = new Product("GTA V", 2, 1, 20);
		UI.adminMenu();
	}
}