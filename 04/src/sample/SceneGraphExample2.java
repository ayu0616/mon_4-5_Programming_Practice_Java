package sample;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneGraphExample2 extends Application {

	public void start(Stage stage) {
		Font fontBig = new Font(32);

		Label topLabel = new Label("Top");
		topLabel.setFont(fontBig);

		Label bottomLeftLabel = new Label("Left");
		bottomLeftLabel.setFont(fontBig);

		Label bottomCenterLabel = new Label("Center");
		bottomCenterLabel.setFont(fontBig);

		Label bottomRightLabel = new Label("Right");
		bottomRightLabel.setFont(fontBig);

		HBox topHBox = new HBox(topLabel);
		HBox bottomHBox = new HBox(50, bottomLeftLabel, bottomCenterLabel, bottomRightLabel);

		GridPane root = new GridPane();

		root.add(topHBox, 0, 0);
		root.add(bottomHBox, 0, 1);

		topHBox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
