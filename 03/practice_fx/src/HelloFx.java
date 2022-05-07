import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloFX extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) {
		Label labelJavaFX = new Label("JavaFX " + System.getProperty("javafx.version") + " ( Java "
				+ System.getProperty("java.version") + ")");
		Scene scene = new Scene(labelJavaFX);
		stage.setScene(scene);
		stage.show();
	}
}
