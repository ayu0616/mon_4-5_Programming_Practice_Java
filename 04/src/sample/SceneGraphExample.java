package sample;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneGraphExample extends Application {

	public void start(Stage stage) {
		Font fontBig = new Font(32);

		Label topLabel = new Label("At the top");
		Label bottomLabel = new Label("At the bottom");


		topLabel.setFont(fontBig);
		bottomLabel.setFont(fontBig);

		BorderPane root = new BorderPane();

		root.setTop(topLabel);
		root.setBottom(bottomLabel);
		bottomLabel.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
