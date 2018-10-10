import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Config {
	static void print() {
		try(FileReader reader = new FileReader("config")){
			Properties properties = new Properties();
			properties.load(reader);
			for(int i = 0; i < User.users.size(); i++) {
				String username = properties.getProperty("username" + i);
				String email = properties.getProperty("email" + i);
				String password = properties.getProperty("password" + i);
				System.out.println("Usuario [" + (i + 1) + "] " + username);
				System.out.println("Email[" + (i + 1) + "] " + email);
				System.out.println("Contraseña[" + (i + 1) + "] " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String hash(String password) {
		char crypted_pass [] = password.toCharArray();
		for(int i = 0; i < password.length(); i++) {
			crypted_pass[i] = (char) ((crypted_pass[i] + i * i + 2) % 256);
		}
		String cryp = new String (crypted_pass);
		return cryp;
	}
	
	static void save_log(String username, String email, String password) {
		try (FileWriter write = new FileWriter("config")){
			Properties properties = new Properties();
			//properties.load(write);
			properties.setProperty("username" + User.users.size(), username);
			properties.setProperty("email" + User.users.size(), email);
			properties.setProperty("password" + User.users.size(), password);
			properties.store(write, "Lista de inicio de sesion");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}