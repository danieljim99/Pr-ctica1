import java.io.IOException;

public class GraphicInterfaceMain {
	static StageManager manager = new StageManager();

	public static void main(String[] args) throws IOException {
		LanguageManager.setLanguageEnglish();
		BackUp.rebootAll();
		manager.initialize();
	}
}