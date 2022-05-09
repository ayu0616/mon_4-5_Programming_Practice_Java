package sample;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DrawingTest extends Application {

	private void DrawOnCanvas(GraphicsContext gc, int width, int height) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);

		int centerX = (int) (Math.random() * width);
		int centerY = (int) (Math.random() * height);

		gc.setFill(Color.BLUEVIOLET);
		gc.setStroke(Color.WHITE);

		gc.fillOval(centerX - 25, centerY - 25, 50, 50);
		gc.strokeOval(centerX - 25, centerY - 25, 50, 50);

	}

	public void start(Stage stage) {

		int width = 800, height = 600;

		Canvas canvas = new Canvas(width, height);

		Button drawButton = new Button("Draw");
		drawButton.setFont(new Font(32));
		drawButton.setOnAction(e -> DrawOnCanvas(canvas.getGraphicsContext2D(), width, height));

		Button quitButton = new Button("Quit");
		quitButton.setFont(new Font(32));
		quitButton.setOnAction(e -> javafx.application.Platform.exit());

		HBox buttonHBox = new HBox(50, drawButton, quitButton);

		BorderPane root = new BorderPane();
		root.setCenter(canvas);
		root.setBottom(buttonHBox);

		buttonHBox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root);

		stage.setTitle("Drawing Test");
		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
