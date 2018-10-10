import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class User {
	String username;
	String email;
	String password;
	static List<User> users = new ArrayList<User>();
	List<Product> user_products = new ArrayList<Product>();
	
	User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = Config.hash(password);
		Config.save_log(this.username, this.email, this.password);
		users.add(this);
	}
	static void register() {
		Scanner keyboard = new Scanner(System.in);
		String username;
		String email;
		String pass1;
		String pass2;
		boolean repetir = false;
		do {
			repetir = false;
			System.out.print("Nombre de usuario: ");
			username = keyboard.nextLine();
			System.out.print("Correo electronico: ");
			email = keyboard.nextLine();
			System.out.print("Contraseña: ");
			pass1 = keyboard.nextLine();
			System.out.print("Repita contraseña: ");
			pass2 = keyboard.nextLine();
			if (username.indexOf(' ') != -1 || username.length() < 4) {
				repetir = true;
				System.out.println("El nombre de usuario debe tener como minimo 4 letras y no debe contener espacios");
			}
			if(email.indexOf(' ') != -1 || email.indexOf('@') == -1) {
				repetir = true;
				System.out.println("El correo debe contener @ y no tener espacios en blanco");
			}
			if(!pass1.equals(pass2) || pass1.length() < 8 || pass1.indexOf(' ') != -1) {
				repetir = true;
				System.out.println("Las contraseñas deben coincidir , tener como minimo 8 letras y no tener espacios en blanco");
			}
		} while (repetir);
		User newUser = new User (username, email, pass1);
		keyboard.close();
	}
}