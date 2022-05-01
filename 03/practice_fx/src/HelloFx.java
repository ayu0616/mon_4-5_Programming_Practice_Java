import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloFx extends Application {
    public void start(Stage stage) {
        Label labelJavaFx = new Label("JavaFX " + System.getProperty("javafx.version") + " ( Java "
                + System.getProperty("java.version") + ")");
        Scene scene = new Scene(labelJavaFx);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
